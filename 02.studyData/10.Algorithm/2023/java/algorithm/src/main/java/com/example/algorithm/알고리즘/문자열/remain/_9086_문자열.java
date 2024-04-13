package com.example.algorithm.알고리즘.문자열.remain;

import java.util.Scanner;

public class _9086_문자열 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = Integer.parseInt(sc.next());
        while(true){
            if(T<=0) {
                break;
            }
            String strings= sc.next();
            int startIdx=0;
            int endIdx=strings.length()-1;
            System.out.printf("%c%c\n",strings.charAt(startIdx),strings.charAt(endIdx));
            T--;
        }
    }
}
