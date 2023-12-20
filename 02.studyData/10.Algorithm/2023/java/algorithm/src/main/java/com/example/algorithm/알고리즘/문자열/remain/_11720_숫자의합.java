package com.example.algorithm.알고리즘.문자열.remain;

import java.util.Scanner;

public class _11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        int ret =0;
        for(int i=0;i<N;i++){
            ret +=  str.charAt(i)-'0';
        }

        System.out.println(ret);
    }
}
