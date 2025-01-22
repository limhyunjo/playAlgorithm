package com.beyond.linkedlist;

import com.beyond.linkedlist.practice.List;
import com.beyond.linkedlist.practice.SinglyLinkedList;

import java.sql.SQLOutput;

public class Application {

    public static void main(String[] args) {

        // 자바에서 제공하는 LinkedList 테스트
       // List<String> list = new LinkedList<>();

       /* System.out.println(list); // []

        System.out.println(list.size()); // 0

        // addFirst, addLast 자바 21 부터 지원 제공 0번부터 추가
        list.addFirst("사과");
        list.addFirst("딸기");

        System.out.println(list);

        list.addLast("포도");
        list.addLast("키위");


        System.out.println(list);
        System.out.println(list.size());


        //---- add 메소드 테스트

        *//*list.add(인덱스 번호, 데이터);*//*



        list.add(1, "수박");
        System.out.println(list);


        // list.get(), list.contains() 메서드 테스트
        System.out.println(list.get(0));
        System.out.println(list.contains("딸기"));
        System.out.println(list.contains("바나나"));
        // 매개 값으로 object를 넘겨서 해당 리스트에 존재하면 true, 존재하지 않으면 false
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
        System.out.println();

        System.out.println(list);
        System.out.println();
        list.removeLast();
        System.out.println(list);
        System.out.println();*/


        // -----------------------------------------------------------------------------


        // SinglyLinkedList 구현 및 테스트
        List<String> list = new SinglyLinkedList<>();

        // addFirst(), addLast(), add()메소드 구현

        list.addFirst("사과");
        list.addFirst("딸기");

        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        list.addLast("키위");
        list.addLast("포도");

        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        list.add(0, "수박");
        list.add(3, "바나나");

        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        list.add(2, "복숭아");
        //list.add(5, "복숭아");

        System.out.println(list);
        System.out.println(list.size());
        System.out.println();


        // get(), contains() 메소드 구현
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(3));
        //System.out.println(list.get(6));
        System.out.println();


        System.out.println(list.contains("딸기"));
        System.out.println(list.contains("두리안"));
        System.out.println(list.contains("바나나"));
        System.out.println(list.contains("참외"));


        // removeFirst(), removeLast(), remove() 메소드 구현

        list.removeFirst(); // 맨 앞의 요소를 지운다
        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        list.removeLast(); // 맨 뒤의 요소를 지운다
        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        //-------------------------------------------------



        list.remove(0);
        list.remove(3);

        System.out.println(list);
        System.out.println(list.size());
        System.out.println();


        list.remove("포도");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println();


    }
}
