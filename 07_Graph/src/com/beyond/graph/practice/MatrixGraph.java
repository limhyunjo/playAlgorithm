package com.beyond.graph.practice;

public class MatrixGraph {

    // 꼭짓점의 개수
    private int numOfVertex;

    // 인접 행렬로 사용될 2차원 배열
    private int[][] matrix;

    public MatrixGraph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        this.matrix = new int[this.numOfVertex][this.numOfVertex];

        // 간선 안에 가중치가 존재하면 노드에 가중치 값을 준다

        /*     0  1  2  3
         *  0
         *  1   20
         *  2
         *  3
         * */
    }

    //
    public void addEdge(int src, int dest, int weight) {
   
        // 행이 시작 꼭짓점
        // 열이 도착 꼭짓점
        // 가중치를 배열에 저장
        
         this.matrix[src][dest] = weight;

        // 양방향인 경우
       // this.matrix[src][dest] = weight;
       // this.matrix[dest][src] = weight;

        for(int i =0; i< this.matrix.length; i++){
            for(int j =0; j< this.matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public void removeEdge(int src, int dest) {

        // 연결이 안된 꼭지점들은 0으로 표현
        this.matrix[src][dest] = 0; // 가중치가 0이 되고 간선이 지워짐

        // 그래프가 방향이 없는 경우
        //this.matrix[dest][src] = 0;
    }

    @Override
    public String
    toString() {

        StringBuilder sb =  new StringBuilder();

        for(int i =0; i< this.matrix.length; i++){
            for(int j =0; j< this.matrix[i].length; j++){

                // 값이 0이거나 0보다 작으면 간선 연결 안되어있음
                if(matrix[i][j] == 0){
                    continue; // 다시 조건식으로 보내버림
                }

                sb.append(String.format("Vertex %d -> Vertex %d (weight: %d)\n", i, j, matrix[i][j]));
            }
        }

        return sb.toString();
    }


}
