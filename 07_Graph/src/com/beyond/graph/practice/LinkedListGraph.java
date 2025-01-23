package com.beyond.graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListGraph {

    private int numOfVertices;

    // list 안의 list에 edge라는 내부 클래스 만듦
    List<List<Edge>> vertices;
    public LinkedListGraph(int numOfVertices) {

        this.numOfVertices = numOfVertices;
        this.vertices = new LinkedList<>();

        for(int i = 0; i < this.numOfVertices; i++){
            this.vertices.add(new LinkedList<>()); // 배열이 아니라서 필요한 순간에 꼭지점 정보를 만들면 됨 / 배열은 공간도 미리 줘야 함...


        }
    }

    public void addEdge(int src, int dest, int weight) {
        
        // 꼭지점을 가져와서 새 간성 정보를 준다 ( 단방향 )
        vertices.get(src).add(new Edge(dest, weight)); 
       
        // 양방향
       // vertices.get(src).add(new Edge(dest, weight)); 
       //  vertices.get(dest).add(new Edge(src, weight)); 
    }

    public void removeEdge(int src, int dest) {
        // 시작과 끝에 해당하는 꼭지점 정보 전달

        List<Edge> vertex = vertices.get(src);

        for(Edge edge : vertex){
            if(edge.vertex == dest){
                vertex.remove(edge);

                break;

            }
        }


    }

    //---------------------------------------------------------------------------


    public void depthFirstSearch(int vertex) {


        boolean[] visited = new boolean[numOfVertices];

        depthFirstSearch(vertex, visited);
    }


    private void depthFirstSearch(int vertex, boolean[] visited) {
        System.out.print(vertex+" "); // 이게 실행되면 해당하는 꼭짓점에 방문했다는 뜻

        visited[vertex] = true; // 방문 사실 true

        for(Edge edge : vertices.get(vertex)){
            if(!visited[edge.vertex]){ // edge.vertex에 방문을 했는지 확인하는 코드

                //방문한적이 없으면 방문하도록 만들기 -> 자기자신을 다시 호출
                depthFirstSearch(edge.vertex, visited); // 재귀 호출
            }
        }
    }



    // 큐 활용
    public void breadthFirstSearch(int vertex) {

    boolean[] visited = new boolean[numOfVertices];
    Queue<Integer> queue = new LinkedList<>(); // LinkedList는 Queue 인테페이스를 상속 중이라 queue처럼 사용 가능

        queue.add(vertex);
        // 시작 꼭짓점을 추가

        // 방문할 꼭짓점들을 순서대로 queue에 쌓음
        while(!queue.isEmpty()){
           vertex =  queue.poll();

           // queue안에서 방문해야할 꼭짓점을 하나 꺼내서 방문했다고 하기

            System.out.print(vertex+ " ");

            visited[vertex] = true;

            for(Edge edge : vertices.get(vertex)){ // 꺼낸 꼭짓점의 인접 꼭짓점들 모두 방문
                // 간선 연결된 꼭짓점들을 우선으로 가져와
                // 방문 안 했으면 queue에 추가
                // 방문 했으면 queue에 추가하지 않음
                if(!visited[edge.vertex]){

                    queue.add(edge.vertex);
                }

            }

        }

    }

    //-------------------------------------------------------------------------------------------------

    @Override
    public String
    toString() {
        StringBuilder sb = new StringBuilder();

        // 간선정보 얻어와서 반복으로 출력

        for(int i = 0; i < vertices.size(); i++){

            for( Edge edge : vertices.get(i)){
                sb.append(String.format("Vertex %d -> Vertex %d (weight: %d)\n", i , edge.vertex, edge.weight));
            }
        }


        return sb.toString();
    }



    // 내부 클래스를 record 클래스로 전환?
    
    // record : 데이터를 정의할 수 있는 불변의 클래스 / 자바 14부터 사용 가능
    // final 클래스로 바뀌어서 상속할 수 없다
    // 만들어지는 키워드들은 전부 private와 final이 동시에 붙는다
   // private record Edge(int vertex, int weight){}
        // 괄호 안에 들어있는게 필드
    // dto 만들 때 record 타입으로 만들면 더 쉽다



    // 간선 정보용 클래스 ( 꼭지점과 간선 정보를 묶어서 관리)
    private static class Edge{
        private final int vertex;

        private final int weight;


        public Edge(int veretex, int weight) {
            this.vertex = veretex;
            this.weight = weight;
        }
    }
}
