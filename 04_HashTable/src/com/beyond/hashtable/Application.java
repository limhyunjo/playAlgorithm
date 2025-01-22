package com.beyond.hashtable;


import com.beyond.hashtable.practice.Hashtable;
// 패키지만 다르고 파일 이름명이 같은 class는 import할 수 없다(에러)

public class Application {

    public static void main(String[] args) {


        Hashtable<String, String> hashtable = new Hashtable<>(3);


        // put() 메서드 구현
        hashtable.put("strawberry","딸기");
        hashtable.put("apple","사과");
        hashtable.put("grape","포도");
        hashtable.put("banana","바나나");
        hashtable.put("banana","초코바나나"); // 중복 키
        hashtable.put("peach","복숭아");
        hashtable.put("orange","오렌지");

        System.out.println(hashtable);
        System.out.println(hashtable.size()); // alt+enter로 메서드 생성
        System.out.println(hashtable.isEmpty());
        System.out.println();


        // get() 메소드 테스트
        // value만 가져옴
        System.out.println(hashtable.get("banana"));
        System.out.println(hashtable.get("melon"));
        System.out.println();

        // contains() 메소드 테스트
        System.out.println(hashtable.contains("banana"));
        System.out.println(hashtable.contains("melon"));
        System.out.println(hashtable.contains("apple"));
        System.out.println();


        // remove() 메소드 테스트
        System.out.println(hashtable.remove("banana"));
        System.out.println(hashtable.remove("strawberry"));
        System.out.println(hashtable.remove("melon"));

        System.out.println(hashtable);
        System.out.println(hashtable.size());
        System.out.println(hashtable.isEmpty());
        System.out.println();






    }
}
