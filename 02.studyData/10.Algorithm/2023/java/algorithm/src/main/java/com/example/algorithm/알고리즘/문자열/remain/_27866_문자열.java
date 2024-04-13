package com.example.algorithm.알고리즘.문자열.remain;

import java.util.Scanner;

public class _27866_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strings = sc.next();
        int index = Integer.parseInt(sc.next());
        System.out.println(strings.charAt(index-1));
    }
}
