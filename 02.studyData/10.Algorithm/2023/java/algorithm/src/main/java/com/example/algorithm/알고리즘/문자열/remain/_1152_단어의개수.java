package com.example.algorithm.알고리즘.문자열.remain;

import java.util.Scanner;

public class _1152_단어의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strings = sc.nextLine().trim(); //공백제거가 핵심

        String ret[] = strings.split(" ");
        if(strings.length()==0) System.out.println(0);
       // if(strings.isEmpty()) System.out.println(0);

        else System.out.println(ret.length);
    }
}
