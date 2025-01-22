package com.beyond.stack.practice;

public class ArrayStack<E> implements Stack<E> {


    // stack의 최상위 요소의 인덱스 값
    private int top;


    // stack의 최대 크기
    private int maxSize;


    // stack 배열
    private E[] values;

    public ArrayStack(){
        this(16);
    }

    public ArrayStack(int maxSize) {

        this.top = -1;
        this.maxSize = maxSize;
        this.values =(E[]) new Object[maxSize]; // 타입 파라미터로 직접 객체를 만들 수 없음 (object로 객체를 만들고 E로 형 변환)


    }

        public void push(E value){

            if(top == maxSize -1){
                throw new RuntimeException("스택이 가득 찼습니다.");
            }else{
                values[++top] = value;
            }
        }


    //--------------------------------------------------------------------------------------

    @Override
    public int size() {




        return (top + 1);
    }

    @Override
    public boolean isEmpty() {
        return (top == -1); // -1이면 데이터가 없는 것임
    }
    
    //--------------------------------------------------

    @Override
    public E pop() { // 가장 위에 있는 것을 반환
        
        if(isEmpty()){ // 스택이 비어있는 지 확인
            throw new RuntimeException("스택이 비어 있습니다.");
        }else{
            
            return values[top--]; // top 가장 위의 인덱스
        }
        
    }

    //--------------------------------------


    @Override
    public boolean contains(E value) {

        boolean result = false;

        for(int i =0; i<=top; i++){
            if(values[i].equals(value)){
                result = true;

                break;
            }
        }



        return result;
    }

    @Override
    public E peek() {
        // peek은 마지막 인덱스의 값만 가져옴( 스택에는 남아있음)


        if(isEmpty()){ // 스택이 비어있는 지 확인
            throw new RuntimeException("스택이 비어 있습니다.");
        }else{

            return values[top]; // top 가장 위의 인덱스
        }

    }


    @Override
    public String toString() {


        StringBuffer sb = new StringBuffer();
        sb.append("[");


        for(int i = 0; i< top; i++){
            sb.append(values[i] +", ");
        }


        if(sb.lastIndexOf(",") != -1){
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");


        }else{
            sb.append("]");
        }


        return sb.toString();
    }
}
