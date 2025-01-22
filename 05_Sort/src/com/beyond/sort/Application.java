package com.beyond.sort;


import com.beyond.sort.practice.ArraySort;

import java.util.Arrays;

public class Application {


    public static void main(String[] args) {

        // 테스트할 배열 생성

        // 삽입 정렬
        int[] array = { 3, 1, 5, 4, 9, 2};


        System.out.println(Arrays.toString(array));

        ArraySort.insertionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();


        // 버블 정렬
        array = new int[]{ 3, 1, 5, 4, 9, 2}; // 선언과 동시가 아니어서 new 연산자

        System.out.println(Arrays.toString(array));

        ArraySort.bubbleSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println();

    }
}
