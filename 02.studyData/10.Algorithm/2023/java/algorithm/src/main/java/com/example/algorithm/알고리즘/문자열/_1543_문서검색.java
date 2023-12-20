package com.example.algorithm.알고리즘.문자열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//public class _1543_문서검색 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String doc = scanner.nextLine();
//        String word = scanner.nextLine();
//        String[] ret = new String[2504];
//
//        int max =-1;
//        for(int i=0;i<doc.length();i++){
//            String splitDoc = doc.substring(i,doc.length());
//            List<String> retS= new ArrayList<>();
//            int retCount=0;
//            for(int j=0;j<splitDoc.length();j++){
//
//                int cnt =0;
//                for(int k=0;k<word.length();k++){
//                    if(k+j<splitDoc.length()&&word.charAt(k)==splitDoc.charAt(k+j)){
//                        cnt++;
//                    }
//                }
//                if(cnt==word.length()){
//                    retCount++;
//                    j = j+word.length()-1;
//                }
//            }
//            if(max <retCount){
//                max = retCount;
//            }
//        }
//
//        System.out.println(max);
//    }
//}

public class _1543_문서검색 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String doc = scanner.nextLine();
        String word = scanner.nextLine();
        String[] ret = new String[2504];

        int max =-1;
        int startIndex =0;
        int count=0;
        while(true){
            int idx = doc.indexOf(word,startIndex);
            if(idx<0){
                break;
            }
            count++;
            startIndex = idx+word.length();
        }

        System.out.println(count);
    }
}
