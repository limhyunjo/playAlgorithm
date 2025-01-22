package com.beyond.queue.practice;

public class LinkedQueue<E> implements Queue<E> {



    private Node<E> front;

    private Node<E> rear;

    private int size;





    @Override
    public void enqueue(E value) {

        // 새 노드 생성

        Node<E> newNode = new Node<>(value);

        if(isEmpty()) {
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode; // 새 노드를 rear(끝)의 옆으로 새로 넣어줘야 함
            rear = newNode;

        }

        size++; // 아무것도 없으면 새 노드 생성하고 front, rear가 새 노드를 참조하고 사이즈 +1




    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return (size == 0);
    }

    @Override
    public E dequeue() { // 맨 앞의 노드를 꺼냄, front가  다음 노드가 됨

        if(isEmpty()) {
            throw new RuntimeException(("큐가 비어있습니다."));
        }

        Node<E> tempNode = front;
        E value = tempNode.data;

        front = tempNode.next;  // 다음 노드를 첫번째 노드로 참조
        
        tempNode.data = null;
        tempNode.next = null;

        size--;

        return value;
    }

    @Override
    public E peek() {

        if(isEmpty()) {
            throw new RuntimeException("큐가 비어있습니다.");
        }


        return front.data;
    }

    @Override
    public boolean contains(E value) {

        boolean result = false;
        Node<E> currentNode = front;

        while(currentNode != null) {
            if(currentNode.data.equals(value)) {
                result = true;

                break; // null이 들어오면 반복 빠져나옴
            }

            currentNode = currentNode.next; // 다음 노드를 가져와서 반복
        }

        return result;
    }


    @Override
    public String toString() {

        Node<E> current = front;

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (current != null){
            sb.append(current.data+ ", ");
            current = current.next;
        }

        if( sb.lastIndexOf(",") !=-1){
            sb.replace(sb.lastIndexOf(","), sb.length(), "]");
        }else {
            sb.append("]");
        }

        return sb.toString();
    }

    // 내부 클래스 생성
    private static class Node<E> {

        private E data;
        private Node<E> next;

        Node(E data){
            this.data = data;
            this.next = null;
        }


    }
}
