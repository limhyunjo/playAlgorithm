package com.beyond.linkedlist.practice;

public interface List<T> { // alt + enter로 인터페이스 구현

    void addFirst(T data);

    void addLast(T data);



    void add(int index, T data);


    int size();

    T get(int index); // 재정의를 하지 않으면 singlylinkedlist에서 오류남 인터페이스 구현 시 전부 재정의해야 함

    boolean contains(T data);

    void removeFirst();

    void removeLast();

    void remove(int index);

    void remove(T data);

}
