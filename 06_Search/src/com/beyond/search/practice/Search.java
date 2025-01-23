package com.beyond.search.practice;

import java.util.Arrays;

public class Search {

    // 정수형 배열에서 특정 숫자의 인덱스를 찾는 정적(static) 메소드
    
    public static int linearSearch(int[] numbers, int target) {
        
        // 배열 전체의 요소들을 하나씩 접근
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == target ){
                return i; // 인덱스 값 반환
            }
        }
        
        
        
        return -1;
    }

        // 문자열에서 특정 문자의 인덱스를 찾는 메소드
    public static int linearSearch(String str, char target) {

        for(int i = 0; i<str.length(); i++){
             if(str.charAt(i)== target){ //charAt() 인덱스 값을 받아서 해당 문자열의 문자를 하나 가져옴
                 // indexOf() // 인덱스 번호
                 return i;
             }
        }

        return -1;
    }


    // 정수형 요소의 배열에서 가장 작은 값을 찾는 메소드
    public static int minValue(int[] numbers) {

       // return Arrays.stream(numbers).min().orElse(0);

        int min = numbers[0]; //첫 번째 원소를 초기화해서 i는 1부터
        for(int i =1 ; i< numbers.length; i++){
            if(numbers[i]<min){
                min = numbers[i];
            }

        }

        return min;
    }

    // 정수형 배열에서 특정 숫자의 인덱스를 찾는 메소드(이진 탐색, 반복문)
    public static int binarySearch(int[] numbers, int target) {
        // 배열을 반씩 쪼개서 비교

        int left = 0;
        int right = numbers.length-1;

        while(left <=right ){
            int mid = (left + right)/2;


            if(numbers[mid] == target){
                return mid; // 중간의 값과 찾는 값이 같으면 mid 반환
            }else if(numbers[mid] <target){
                left = mid +1;  // 중간으로 나눈 이후 left 번호를 조정해서 오른족부터 나눠서 찾음
            }else{
                right= mid -1; // 왼쪽 찾는 코드
            }
        }

        return -1; // 내가 찾으려는 값이 없는 경우
    }

    public static int binarySearch(int[] numbers, int target, int left, int right) {

        // 내부에서 재귀로 다시 binarySearch 호출

        if(left <=right){

            int mid = (left + right)/2;

            // 중간값이 target과 같은지 확인하고 같으면 mid 돌려줌
            if(numbers[mid] == target){
                return mid;
            }else if(numbers[mid] < target){
                return binarySearch(numbers, target, mid+1, right);
                // left와 right를 조정해서 다시 binarySearch 호출
            }else{
                return binarySearch(numbers, target, left, mid-1);

            }

        }



        return -1;
    }
}
