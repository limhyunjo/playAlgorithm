package com.beyond.sort.practice;

import java.util.Arrays;

public class ArraySort {


    // 삽입 정렬
    // 정적 메소드
    public static void insertionSort(int[] array) {
        // int[] array = { 3, 1, 5, 4, 9, 2};
        // 선택할 키(정렬되지 않은 영역을 키로 잡아서 정렬된 영역과 비교)
        // 1회전에 11번
        for(int i = 1; i < array.length; i++){ // 0부터가 아니라 뒤의 정렬되지 않은 인덱스부터
            int key = array[i];
            // 비교하는 반복분 생성
            int j = i -1; // 초기식을 바깥에 써줌
            for( ; j>=0 && key < array[j]; j--){
                // 조건이 안 맞으면 빠져나옴
                array[j+1] = array[j];
            }
            array[j+1] = key; // array[i]의 위치 +1

        }
    }


    // 버블 정렬
    public static void bubbleSort(int[] array){

        // 앞부터 비교하여 뒤부터 정렬됨
        // 1회전에 6번 (가장 큰 값이 맨 오른쪽에 위치하게 된다)
        for(int i =0; i< array.length-1; i++){
            for( int j = 0; j < array.length-i-1; j++){ // i도 추가로 빼서 인접한 값과 비교를 줄임
                if(array[j] > array[j+1]){ // 3 > 1
                    int temp= array[j]; // 3
                    // 두 값 비교해서 위치 바꾸기
                    array[j] = array[j+1]; // 1
                    array[j+1] = temp; // 3
                    
                    // 3과 1의 위치가 바뀜
                }
            }
        }
    }


    /*
    * 재귀 메소드
    * - 작업 중에 자기 자신을 호출하는 것을 재귀 호출이라 하고
    * - 재귀 호출을 하는 메소드를 재귀 메소드라고 한다.
    *
    * */

    // 병합 정렬
    public static void mergeSort(int[] array, int left, int right){
        // 배열의 왼쪽 시작 인덱스(left), 오른쪽 끝 인덱스(right) -> 가운데 계산해서 분할 하는데 필요
        //left보다 right가 커야 가운데로 쪼갤 수 있음
        // 값이 같으면 더이상 분할할 값이 없다는 뜻

        // 분할할 부분이 남아 있는 경우
        if( left < right){
            // 가운데는 mid 변수로 저장
            int mid =( left + right )/2; // 배열을 분할할 인덱스 번호 계산

            // left가 right보다 작을 때까지 자기 자신을 계속 호출

            // 왼쪽 부분 분할 후 배열 정렬
            mergeSort(array, left, mid); // mergeSort() : 재귀 메소드, 메소드 자기 자신으로 자기 자신을 호출한다

            // 오른쪽 부분 분할 후 배열 정렬
            mergeSort(array, mid + 1, right);


            // 정렬된 두 부분의 배열을 합치기
            // 두 부분의 배열을 정렬하여 합치는 메서드
            merge(array, left, mid, right); // merge 메서드 구현




        }

    }


    // 내부에서만 쓸 merge 메서드
    private static void merge(int[] array, int left, int mid, int right){
        // 임시 배열 생성
        int[] temp  = new int[right - left + 1];

        // 왼쪽 부분 배열의 시작;'
        int i = left;

        // 오른쪽 부분 배열의 시작;'
        int j = mid + 1;

        // 임시 배열의 인덱스 (두 부분 배열의 값을 비교하여 임시 배열에 작성
        int k = 0;

        while(i <= mid && j <= right){

            if(array[i] <= array[j]){
                temp[k++] = array[i++];

            }else{

                temp[k++] = array[j++];
            }
        }


    }







}
