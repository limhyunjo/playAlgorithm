package com.beyond.graph;

import com.beyond.graph.practice.LinkedListGraph;
import com.beyond.graph.practice.MatrixGraph;
import org.w3c.dom.ls.LSOutput;

public class Application {

    public static void main(String[] args) {


        // 인접행렬로 그래프 구현
        MatrixGraph matrixGraph = new MatrixGraph(4);
        // 값을 전달하지 않으면 객체를 생성할 수 없음(꼭짓점 개수로 배열이 생성됨)
        // 그래프로 전달할 꼭짓점 갯수도 같이 전달해야함(2차원 배열로 생성)
// 메모리를 효율적으로 쓸수 없다는 단점이 있다

        // addEdge() 메소드
        matrixGraph.addEdge(0,1,30); // 가중치가 있는 그래프
        matrixGraph.addEdge(0,2,20);
        matrixGraph.addEdge(1,2,50);
        matrixGraph.addEdge(2,3,70);
         // 0 ~ 2번 꼭짓점으로 가중치는 20 가중치가 있는 그래프

        System.out.println(matrixGraph);

        // removeEdge()메소드

        matrixGraph.removeEdge(0,1);  //간선의 가중치 값을 0으로 바꾸면 연결 끊어짐

        System.out.println(matrixGraph);
        System.out.println();
        
        
        
        // 인접 리스트 테스트
        LinkedListGraph listGraph = new LinkedListGraph(4);// 꼭지점의 개수 전달

        // addEdge() 메소드
        listGraph.addEdge(0,1,30);
        listGraph.addEdge(0,2,20);

        System.out.println(listGraph); // toString을 안 만든 상태에서는 객체의 주소값만 보인다
        System.out.println();


        // removeEdge() 메서드
        listGraph.removeEdge(1,2); // 연결 정보만 주면 됨
        System.out.println(listGraph);
        System.out.println();


        // 그래프 탐색
        listGraph.addEdge(0,1, 30);
        listGraph.addEdge(0,2, 40);
        listGraph.addEdge(1,2, 50);
        listGraph.addEdge(2,0, 60);
        listGraph.addEdge(2,3, 70);
        listGraph.addEdge(3,3, 80);



        // 깊이 우선 탐색(시작 꼭짓점은 2)
        listGraph.depthFirstSearch(2); // 시작 꼭짓점을 전해줌
        // 2 0 1 3 순서로 탐색
        System.out.println();


        // 너비 우선 탐색( 시작 꼭짓점은 2)
        listGraph.breadthFirstSearch(2);
        System.out.println();



    }



}
