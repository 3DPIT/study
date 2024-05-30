package com.dipit3.black.middle._03_string.ex1.pratice;

public class TestString2 {
    public static void main(String[] args) {
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        //코드 작성
        int wordSumLen =0;
        for(String word : arr){
            wordSumLen += word.length();
            System.out.println(word+": "+word.length());
        }

        System.out.println("sum = " + wordSumLen);
    }
}

/* 요구사항
length()를 이용해서 arr배열에 들어있는 모든 문자열의 합을 구해라.
*/

/* 실행결과
hello: 5
java: 4
spring: 6
jap:3
sum = 21
*/