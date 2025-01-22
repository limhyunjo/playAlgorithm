package com.beyond.queue.practice;

public interface Queue<E> { // 구현 객체 생성 시 구체적인 타입을 지정하도록 제네릭스 지정

    void enqueue( E value);

    int size();

    boolean isEmpty();

    E dequeue();

    E peek();

    boolean contains( E value);


}
