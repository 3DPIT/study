package com.example.algorithm.알고리즘.문자열.remain;

import java.util.Scanner;

public class _2625_문자열의반복 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0;t<T;t++){
            int repeatNumber = sc.nextInt();
            String words= sc.next();
            for(int i=0;i<words.length();i++){
                for(int j=0;j<repeatNumber;j++) {
                    System.out.print(words.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
