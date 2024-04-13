package com.example.algorithm.알고리즘.문자열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

//공통 부분을 제외한 나머지가 애너그램을 만들기 위한 제거수
public class _1919_애너그램 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] str1 = scanner.next().toCharArray();
        char[] str2 = scanner.next().toCharArray();
        int[] alphabet_str1= new int[26];
        int[] alphabet_str2= new int[26];
        int ret=0;
//        for(int i=0;i<str1.length;i++){
//            alphabet_str1[str1[i]-'a']++;
//        }
//
//        for(int i=0;i< str2.length;i++){
//            alphabet_str2[str2[i]-'a']++;
//        }
        alphabet_str1= alphabetExtction(str1);
        alphabet_str2= alphabetExtction(str2);

        for(int i=0;i<26;i++){
            if(alphabet_str1[i]!=alphabet_str2[i]){
              ret +=  Math.abs(alphabet_str1[i]-alphabet_str2[i]);
            }
        }

        System.out.println(ret);
    }

    public static int[] alphabetExtction(char[] str){
        int []alphabet_str= new int[26];
        for(int i=0;i<str.length;i++){
            alphabet_str[str[i]-'a']++;
        }

        return alphabet_str;
    }

}
