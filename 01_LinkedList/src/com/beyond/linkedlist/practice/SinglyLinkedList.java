package com.beyond.linkedlist.practice;


public class SinglyLinkedList<T> implements List<T> {
// alt + enter로 메서드 구현 


    // 연결 리스트의 첫 번째 노드를 가리키는 참조
    private Node<T> head;


    private int size;

    // 생성자
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size(){
        return size;
    }

     @Override
     public T get(int index){
        if(index < 0 || index >= size){ // 인덱스가 음수값으로 던져지는 경우도 에러남
            throw new IndexOutOfBoundsException();
        }
        return search(index).data; // 해당하는 노드의 데이터만 반환
     }


     @Override
     public boolean contains(T data){

        Node<T> current = head; // head가 참조하는 node를 current에 담아서 값을 비교하고 true/ false 반환

         while(current != null){
             if(current.data.equals(data)){

                 return true;
             }

             // current가 null이거나 같은 값을 찾을 때까지 반복
             current = current.next;  // 다음 노드도 참조할 수 있게 함
         }

        return false;
     }


     @Override
     public void removeFirst(){

        if(head == null){
            return; // 헤드(리스트)에 아무것도 없으면 메소드 종료
        }else {

            Node<T> first = head; // 첫 번째 노드를 가져옴
            head = first.next; //
            first.data = null;
            first.next = null;


            size--;
        }

     }

     @Override
     public void removeLast(){

        if(head == null){
            return;

        }else if ((size -2) <0){
            removeFirst();
            return;
        }else{
            Node<T> lastPrevNode = search(size -2); // 마지막의 이전 요소를 가져온

            lastPrevNode.next.data = null;
            lastPrevNode.next = null;

            size--;
        }
     }

     @Override
     public void remove(int index){

        if(index < 0 || index >= size){

            throw new IndexOutOfBoundsException();
        }

        if(index == 0){

            removeFirst();

            return;
        }

         if(index == (size -1)){ // 사이즈가 마지막 인덱스와 같은 경우

             removeLast();

             return;
         }

        Node<T> prevNode = search(index -1);
        Node<T> targetNode = prevNode.next;

        prevNode.next = targetNode.next;
        targetNode.data = null;
         targetNode.next= null;

         size--;

     }

     @Override
     public void remove(T data){

        // head가 null인 경우
        Node<T> currentNode = head;
        if(currentNode ==null){

            return;
        }

        // 삭제할 노드가 맨 처음인 경우
        if(currentNode.data.equals(data)){

            removeFirst();

            return;
        }


        for(int i = 0 ; i< size -1 ; i++){

            if(currentNode.next.data.equals(data)){
                Node<T> nextNode = currentNode.next;
                currentNode.next = nextNode.next;
                nextNode.data = null;
                nextNode.next = null;

                size--;

                break;
            }
            currentNode= currentNode.next;
        }
     }

     //----------------------------------------------------------------------------------




    @Override
    public void addFirst(T data) {

        // 새 노드 생성
        Node<T> newNode = new Node<>(data); 
        
        //리스트가 비어있는 경우
        if(head == null){
           head =  newNode;
        }else{
            newNode.next = head; // 새 노트에 head를 넘겨줌
            
            head = newNode;
        }
        // 사이즈 증가
        size++;
    }

    @Override
    public void addLast(T data) {

        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        }else{
            // node 검색을 메소드로 만들기
            Node<T> lastNode = search(size -1); // 자주 사용해서 메소드로 만들음

            lastNode.next= newNode; // 마지막 노드를 받아서 다음 노드를 생성
        }

        size++;
    }

    @Override
    public void add(int index, T data) {


        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            addFirst(data);

            return;
        }

        if(index == size){
            addLast(data);

            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> prevNode = search(index - 1); // 이전 인덱스를 만들어냄

        newNode.next = prevNode.next;
        prevNode.next = newNode;

        size++;


    }

    @Override
    public String toString() {

        Node<T> currentNode = head;
        // 데이터가 없으면 head는 null
        StringBuilder sb = new StringBuilder();
        sb.append("[");



        while(currentNode != null){

            sb.append(currentNode.data + ", ");

            currentNode = currentNode.next; // Node의 주소값을 다시 current로 넘김
        }

        if (sb.lastIndexOf(",") != -1) {
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");

        }else{
            sb.append("]");
        }
        return sb.toString();
    }

    // 클래스 선언
    /*
      클래스 안에 클래스를 선언하는 것을 내부 클래스, 이너 클래스라고 한다
      - static으로 만들지 않는 경우 instance를 먼저 만들어야 한다
      - 대부분은 static으로 생성
      - static 메서드는 클래스의 이름으로 접근 가능
      - 클래스에 붙는 경우 다른 클래스(외부 클래스)의 멤버이므로 클래스 이름으로만 접근 가능
      - 외부 클래스에는 static을 단독으로 붙일 수 없음
     */

    
    
    //-------------------------------------

     // node 반환하는 search 메소드
     private Node<T> search(int index){ // 외부에서는 접근 못하게 하려고 private
         
         // head에서부터 차례로 index까지 검색
         Node<T> currentNode = head;
         
         for(int i = 0; i < index; i++){
             currentNode = currentNode.next;
         }
         
         return currentNode; // 인덱스 번호에 해당되는 노드를 반환해줌
     }



    //-------------------------------------
    
    
    // 내부 클래스
    private static class Node<T> {
        // 중첩 클래스에서만 static 사용 가능
       
        // 노드가 저장하는 데이터
        private T data;
        
        // 다음 노드를 가리키는 참조
        private Node<T> next;
        
        // 노드를 생산할 때 사용할 생성자
        private Node(T data){
            this.data = data;
            this.next = null;
        }
        
    }
}
