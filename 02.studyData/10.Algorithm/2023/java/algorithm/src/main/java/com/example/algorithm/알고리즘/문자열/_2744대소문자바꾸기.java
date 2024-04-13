package com.example.algorithm.알고리즘.문자열;

import java.util.Scanner;

public class _2744대소문자바꾸기 {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        char alphabets = scanner.next();
//
//       for(int i=0;i<alphabets.length();i++){
//        char alphabet = alphabets.charAt(i);
//        if(alphabet<'a') {// 대문자인 경우
//            System.out.print((char)('a'+alphabet-'A'));
//        }else{
//            System.out.print((char)('A'+alphabet-'a'));
//        }
//       }
//    }R
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabets = scanner.next().toCharArray();

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] < 'a') {// 대문자인 경우
                alphabets[i]=((char) ('a' + alphabets[i] - 'A'));
            } else {
                alphabets[i]=((char) ('A' + alphabets[i] - 'a'));
            }
        }
        System.out.println(alphabets);
    }
}
