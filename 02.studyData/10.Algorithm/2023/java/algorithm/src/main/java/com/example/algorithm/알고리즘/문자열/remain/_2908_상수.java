package com.example.algorithm.알고리즘.문자열.remain;

import java.util.Scanner;

public class _2908_상수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstNumber= sc .next();
        String secondNumber= sc.next();

        StringBuilder sb1= new StringBuilder(firstNumber).reverse();
        StringBuilder sb2= new StringBuilder(secondNumber).reverse();

        if(Integer.parseInt(sb1.toString())<=Integer.parseInt(sb2.toString())){
            System.out.println(sb2);
        }else{
            System.out.println(sb1);
        }
    }
}
