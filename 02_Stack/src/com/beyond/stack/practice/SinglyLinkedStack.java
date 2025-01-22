package com.beyond.stack.practice;

public class SinglyLinkedStack<E> implements Stack<E> {

    private Node<E> top;

    private int size;

    // 생성자


    public SinglyLinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E value) {

        Node<E>  newNode = new Node<>(value);
        // top 은 현재 null인데 새 node가 value값을 받고 새로 생성됨

        newNode.next = top; // 새노드와 연결
        // 새 노드에게 top의 값이 들어감

        top = newNode; // 새 노드에 참조
        // top은 첫 번째 노드를 참조하게 된다

        // 각각의 노드들은 이전 노드를 참조하고 있다.

        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new RuntimeException("스택이 비어있습니다.");

        };

        Node<E> tempNode = top;// 아래의 노드를 참조하도록 함
        E data = tempNode.data; // 데이터만 담아서 리턴

        top = tempNode.next;
        tempNode.data = null;
        tempNode.next= null;

        size--;


        return data;
    }

    @Override
    public boolean contains(E value) {

        boolean result = false;

        Node<E> currentNode = top;

                while(currentNode !=null){
                    if(currentNode.data.equals(value)){

                        result = true;

                        break;
                    }

                    currentNode = currentNode.next;
                }

                return result;

    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new RuntimeException(("스택이 비어있었습니다."));
        }
        return top.data;

    }
    
    
    //----
    
    // 내부 클래스 생성
    private static class Node<E>{
        // 내부에서만 쓸 거라 private
        
        private E data;
        
        public Node<E> next;
        
        public Node(E data) { // 노드 클래스 생성
            this.data = data;
            
            this.next = null;
        }
    }


    @Override
    public String toString() {

        Node<E> currentNode = top;
         StringBuilder sb = new StringBuilder();

        sb.append("[");

        while(currentNode != null){
            sb.insert(0,currentNode.data + ", ");

            currentNode = currentNode.next;
        }

        sb.insert(0, "[");
        if(sb.lastIndexOf(",") !=-1){
            sb.replace(sb.lastIndexOf(","),sb.length(),"]");
        }

        // 마지막 넣은 상태로 동화

        return sb.toString();
    }
}
