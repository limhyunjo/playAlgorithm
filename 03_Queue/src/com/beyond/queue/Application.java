package com.beyond.queue;


import com.beyond.queue.practice.ArrayQueue;
import com.beyond.queue.practice.LinkedQueue;
import com.beyond.queue.practice.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Application {

    public static void main(String[] args) {

        // 자바에서 제공하는 Queue 테스트

        // 큐는 콜렉션을 상속하는 인터페이스여서 linkedlist도 사용 가능하다

      /*  Queue<String> queue = new ConcurrentLinkedQueue<>(); // 타입 파라미터로 String을 준 Queue 생성

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();
*/
        // poll() : 데이터 꺼내오는 메서드


    /*    // add() 테스트
        queue.add("딸기");
        queue.add("사과");

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();

        
        // queue에서는 enqueue, dequeue 

        
        // poll() 테스트
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();
        
        // peek() 테스트
        
        queue.add("바나나");
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();


        // contains() 테스트

        System.out.println(queue.contains("딸기"));      
        System.out.println(queue.contains("사과"));
        System.out.println();
        */
        

        // ArrayQueue 구현 및 테스트
       // Queue<String> queue = new ArrayQueue<>(5);// 기본 생성자로 만들면 16

        // LinkedQueue 구현 및 테스트
        Queue<String> queue = new LinkedQueue<>(); // 배열이 아니라서 사이즈 정해줄 필요 없음
        // SinglyLinkedList로 Queue를 만듦

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();

        // enqueue() 테스트
        queue.enqueue("딸기");
        queue.enqueue("포도");
        queue.enqueue("사과");
        queue.enqueue("복숭아");
        queue.enqueue("오렌지");
        queue.enqueue("바나나");
       // ArrayQueue에서는 배열이라 크기를 5로 고정해서 큐가 가득 찼다고 runtime 예외 생김
        // linkedQueue에서는 오류 안남

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();
        // size 2

        //--------------------------------------

        // dequeu() 테스트

        // 첫번째 데이터를 꺼내서 반환
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();

        // enqueue(), dequeue(), toString() 동작 확인
        //queue.enqueue("바나나");
        // dequeue로 꺼내서 size가 4개가 되었는데 enqueue로 데이터를 삽입하면 큐가 다 찼다고 오류남
        // 실제로 비워지는게 아니라 front라는 애가 바뀌는 것임
        // 새로운 데이터는 꺼내진 0번 인덱스에 넣어야 함 , 배열의 크기가 5라서 배열 크기를 넘어서면 오류가 남

        // -> toString 시 에러남
   /*     System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();
*/

    /*    System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue()); // 바나나까지 꺼내려 하면 에러남 -> dequeue(수정)
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();

        System.out.println();
*/

        //--------------------------------------------------


        // peek() 메소드 테스트

        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println();
        
        

        // contains() 메소드 테스트
        System.out.println(queue.contains("딸기"));
        System.out.println(queue.contains("사과"));
        System.out.println(queue);
        System.out.println();




    }
}
