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
        // 코드 흐름 상 왼쪽부터 분할

        // 분할할 부분이 남아 있는 경우
        if( left < right){ // 조건에 맞지 않으면 if 바깥으로 나감
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
            
            // 더이상 분할 가능한 부분이 없으면 다시 호출됨
            // 이전에 왼쪽 부분 정렬에서 호출되었으면 실행 끝나고 메소드 호출 부분으로 다시 돌아옴 -> 오른쪽으로 감

        }

    }


    // 내부에서만 쓸 merge 메서드
    private static void merge(int[] array, int left, int mid, int right){
        // 임시 배열 생성
        int[] temp  = new int[right - left + 1];

        // 왼쪽 부분 배열의 시작;
        int i = left;

        // 오른쪽 부분 배열의 시작;
        int j = mid + 1;

        // 임시 배열의 인덱스 ( 두 부분 배열의 값을 비교하여 임시 배열에 작성 )
        int k = 0;

        // 두 부분 배열의 요소들을 비교하여 임시 배열에 정렬하여 저장
        while(i <= mid && j <= right){
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }

        // 왼쪽 부분에 남아 있는 요소가 있으면 임시 배열에 저장
        while(i<=mid){
            temp[k++] = array[i++];
        }

        // 오른쪽 부분에 남아 있는 요소가 있으면 임시 배열에 저장

        while(j<=right){ // right에 도달하지 못하면 요소가 남아있다는 뜻
            temp[k++] = array[j++];
        }

        // 임시 배열의 요소들을 원래 배열에 저장
        for( k = 0; k< temp.length ; k++){
            array[left + k] = temp[k];

        }

    }


    // quick 정렬
    public static void quickSort(int[] array, int left, int right){

        if(left < right ){
            // pivot을 정해서 오른쪽과 왼쪽으로 값을 나눔
            // partition이라는 메소드 생성
            
            int pivotIndex = partition(array,left, right); // 분할 
            
            // pivot 보다 작으면 왼쪽 크면 오른쪽
            // pivot을 기준으로 배열을 분할하고 pivot의 위치를 반환
            
            // pivot을 기준으로 왼쪽 부분 배열 정렬
            quickSort(array, left, pivotIndex-1); // 재귀 
            // pivot을 기준으로 오른쪽 부분 배열 정렬
            quickSort(array, pivotIndex + 1, right); // 재귀 
            
            
        }

    }


    private static int partition(int[] array, int left, int right){

        int pivot = array[right]; // 배열의 마지막 요소(right 인덱스의 값)를 pivot으로 정함

        // 작은 요소들의 인덱스
        int i = left -1;
        int temp = 0;
        // ( 전달 받은 전체 배열을 탐색하면서 pivot을 보다 작은 값들을 왼쪽으로 이동시킴)
        for(int j = left; j<right; j++){
            if(array[j]<pivot){
                i++;

                // 작은 요소와 array[j]를 교환
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // pivot을 옳바른 위치로 이동시킴
        temp = array[i+1];
        array[i +1] = array[right];
        array[right] = temp;


        // pivot의 위치를 반환
        return i+1;

    }




}
