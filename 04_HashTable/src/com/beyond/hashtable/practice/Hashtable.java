package com.beyond.hashtable.practice;

import java.util.LinkedList;

public class Hashtable<K, V> {

    // shift + f6으로 바꾸면 파일명까지 같이 바뀜

    private int maxSize;
    private LinkedList<HashNode<K,V>>[] buckets;


   
    public Hashtable(){
        this( 16);
       /* this.buckets = new LinkedList[this.maxSize];
        
        for(int i = 0; i < this.maxSize; i++){
            this.buckets[i] = new LinkedList<>();
        }*/ // 기본 생성자에서 중복 코드 제거
    }

    @SuppressWarnings("unchecked") // 경고 지우기
    public Hashtable(int maxSize){
        this.maxSize = maxSize;
        this.buckets = new LinkedList[this.maxSize];

        for(int i = 0; i < this.maxSize; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

//------------------------------------------------------
    public void put(K key, V value) {

        int index = hash(key); // 인덱스 값을 만들어서 index에 넣음

       for (HashNode<K,V> node : buckets[index]) {
           if (node.key.equals(key)) {

               node.value = value;

               return;
           }
       }

        // 저장은 bucket에 해야함
        buckets[index].add(new HashNode<>(key, value));

    }

    public V get( K key){

        int index = hash(key);
        for(HashNode<K,V> node : buckets[index]){
            if(node.key.equals(key)){

                return node.value;
            }
        }


        return null;
    }


    public boolean contains(K key){
        boolean result = false;
        
        int index = hash(key);
        
        for(HashNode<K,V> node : buckets[index]){ // linkedlist의 index
            if(node.key.equals(key)){
                result = true;
                
                break; 
            }
        }
        
        return result; // 변수에 담아서 리턴
    }


    public V remove(K key) {

        V value = null;


        int index = hash(key);
        for(HashNode<K,V> node : buckets[index]){ // linkedlist를 가져옴

            if(node.key.equals(key)){
                value = node.value;

                // 실제 해쉬 노드를 제거하는 코드
                buckets[index].remove(node); // 자바에서 제공하는 remove

                break; // 전달하는 key에 대한 node가 없는 경우 반복문을 빠져나와 null을 return

            }


        }


        return value;
    }



    //------------------------------------------------

    public int size() {

        int size = 0;

        // 데이터는 linkedlist안에 저장되어 있음

        for(LinkedList<HashNode<K,V>> bucket : buckets){
            size += bucket.size();
        }

        return size;
    }

    public boolean isEmpty() {

        return (size() == 0);

    }


    // 내부에서만 쓸거라 private
    private int hash(K key) {
        // hash 메소드를 통해 인덱스 값을 뽑아서 저장된 인덱스 번호를 얻어옴
        return Math.abs(key.hashCode()% this.maxSize);
    }

    //-----------------------------------------------------



    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

      for(int i = 0; i < buckets.length; i++){
          LinkedList<HashNode<K,V>> bucket = buckets[i];

          sb.append(i).append(": ").append(bucket).append("\n");
      }

        return sb.toString();
    }




    private static class HashNode<K, V> {

        private K key;
        private V value;

        // linkedlist를 직접 만들지 않고 자바에서 제공하는 걸로 사용

        private HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{key =" + key + ", value =" + value + "}";
        }
    }



}
