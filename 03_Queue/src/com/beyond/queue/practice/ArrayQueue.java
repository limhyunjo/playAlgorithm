package com.beyond.queue.practice;

public class ArrayQueue<E> implements Queue<E> { // alt + enter로 메서드 구현
   
   
    
    private int front; // queue의 첫 번째 데이터가 저장되어 있는 인덱스를 저장할 필드
    private int rear; // queue의 마지막 데이터가 저장되어 있는 배열의 인덱스
    
    private int maxSize; // queue의 최대 크기
    private int size; // queue에 저장되어 있는 데이터의 수를 저장할 필드

    // 데이터를 저장할 배열
    private Object[] values; // object 타입으로 배열을 만들고 반환할 때만 E 타입으로 바꿔줄 예정




    //생성자


    public ArrayQueue() {
/*        this.front = 0; // 배열은 0부터 시작
        this.rear = -1; // 데이터가 없는 경우 -1 시작*/
        this.maxSize = 16;
  /*      this.size = 0;
        this.values = new Object[maxSize]; // 16크기의 배열*/
    }
    // 기본 생성자와 매개 변수가 있는 생성자에서 중복되는 코드 리팩터링

    public ArrayQueue(int maxSize) {

        this.front = 0; // 배열은 0부터 시작
        this.rear = -1;
        this.maxSize = maxSize;
        this.size = 0;
        this.values = new Object[maxSize];
    }


    @Override
    public void enqueue(E value) {

        if(size == maxSize){
            throw new RuntimeException("큐가 가득 찼습니다.");

        }
        //values[++rear] = value;
                // rear 는 처음에 -1이라 0부터 나오게 ++rear로 만들어줌
        // 처음 배열에 들어가면 rear가 1 증가해서 0부터 시작함



        // 큐의 끝에 rear가 도달한 경우(큐가 꽉찬 경우) 다시 0번 인덱스부터 들어가도록 만듦
        if( rear == maxSize -1){
            rear = -1;
        }

        values[++rear] = value;


        size++; // enqueue로 배열에 저장과 원하는 인덱스에 삽입 가능
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size ==0);
    }

    @Override
    public E dequeue() {

        // queue가 비어있으면 예외 던짐
        if(isEmpty()){
            throw new RuntimeException("큐가 비어있습니다.");
        }

        // 데이터가 있으면 배열에서 꺼내옴
        E value = (E)values[front++]; // front 값을 꺼내서 value에 담음
                  // Object 타입이라 E타입으로 바꿔서 담아줌 ( 형변환해서 꺼내옴)
        // 이후 front 1 증가 시킴

        // 큐의 끝에 도달해서 새 데이터가 들어온 경우
        if(front == maxSize){
            front =0;
        }

        size--; // 크기를 1 줄이고

        return value;

    }

    @Override
    public E peek() {

        // 비어있는지 확인
        if(isEmpty()){
            throw new RuntimeException("큐가 비어있습니다.");
        }

        return (E) values[front]; // 실제 큐에서 데이터를 지우는 게 아니라 값만 출력해줌
    }

    @Override
    public boolean contains(E value) {
        boolean result = false;

        int front = this.front; // front 값을 읽어옴
        for (int i = 0; i < size; i++) { // 데이터 개수 만큼 반복

            if(values[front].equals(value)){ // values의 front값 부터 차례대로 값 비교

                result = true;

                break;
            }

            front = front +1 % maxSize;

        }

        return result;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        // 반복으로 출력 시 5 크기의 배열 중에 데이터가 3개면 비어있는 2칸도 0 , 0 으로 나옴 -> 데이터 개수만큼 접근하도록 만들기

        int front = this.front;
        sb.append("[");

        for( int i = 0; i< size; i++){ // 빈 부분은 출력하지 않기 위해 maxSize가 아니라 size(저장된 데이터)로 만듦
            sb.append(values[front] + ", ");
            // 0부터 시작하는데 dequeue한다고 진짜 값이 빠지는게 아니라 front만 옴겨가는 거라
            // 데이터가 잘못나옴
            // i 가 아니라 front 부터 가져오게 하기 -> rear가 0번 인덱스로 간 경우 front는 5번이 되어 꺼내려 하면 오류남

            front= (front + 1)%maxSize; // 이렇게 하면 0번에 들어간 rear가 마지막에 들어간 것 처럼 출력됨
            // 나머지로 계산
        }
        
        if(sb.lastIndexOf(",")!= -1){
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");
            // 데이터가 존재하는 경우 ,를 , 부터 전체까지를 }로 바꾼다
        }else{
            sb.append("]");
        }


        return sb.toString();
    }



}
