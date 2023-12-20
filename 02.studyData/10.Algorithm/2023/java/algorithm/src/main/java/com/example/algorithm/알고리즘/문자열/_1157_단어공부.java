package com.example.algorithm.알고리즘.문자열;

import java.util.Scanner;

public class _1157_단어공부 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String UpperStr = scanner.next().toUpperCase();

        int[] alphabetCounters = new int[26];

        for (int i = 0; i < UpperStr.length(); i++) {
            alphabetCounters[UpperStr.charAt(i) - 'A']++;
        }

        int max =-99999;
        int alphabetIdx=0;
        for (int i = 0; i < alphabetCounters.length; i++) {
            if(max<alphabetCounters[i]){
                max=alphabetCounters[i];
                alphabetIdx = i;
            }
        }

        int MaxCount=0;
        for (int i = 0; i < alphabetCounters.length; i++) {
            if(max == alphabetCounters[i]){
                MaxCount++;
            }
        }

        if(MaxCount>=2){
            System.out.println("?");
        }else {
            System.out.println((char) (alphabetIdx + 'A'));
        }
    }
}