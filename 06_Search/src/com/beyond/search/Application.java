package com.beyond.search;

import com.beyond.search.practice.Search;

public class Application {

    public static void main(String[] args) {



        // 선형 탐색

        // 정수 배열 생성
        int[] numbers = {3, 8, 5, 4, 9, 2};

        System.out.println(Search.linearSearch(numbers, 9)); // Search 클래스 생성
        // alt + enter로 클래스 생성 ( 패키지 이름까지 지정 )

        System.out.println(Search.minValue(numbers));
        System.out.println(Search.linearSearch("Hello", 'e'));
        System.out.println();


        // 이진 탐색

        numbers = new int[]{2, 3, 5, 9, 12, 15, 30};
        System.out.println(Search.binarySearch(numbers, 5));

        // 재귀호출 사용
        System.out.println(Search.binarySearch(numbers, 5, 0, numbers.length -1)); // left와 right 값을 한번에 보냄





    }
}
