package com.beyond.stack.practice;

public interface Stack<E> {// alt + enter로 인터페이스 구현



    // 공통으로 구현해야 하는 메서드
    void push( E value);

    int size();

    boolean isEmpty();

    E pop();


    boolean contains( E value);

    E peek();

}
