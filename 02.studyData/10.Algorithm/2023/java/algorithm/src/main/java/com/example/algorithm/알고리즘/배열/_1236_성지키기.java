package com.example.algorithm.알고리즘.배열;

import java.util.Scanner;

//public class _1236_성지키기 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        char[][] castle= new char[50][50];
//        for(int i=0;i<N;i++){
//            String linePeople = sc.next();
//            for(int j=0;j<M;j++){
//                castle[i][j] = linePeople.charAt(j);
//            }
//        }
//
//        int yNum=0;
//        for(int i=0;i<N;i++){
//            int flag =0;
//            for(int j=0;j<M;j++){
//                if(castle[i][j]=='X'){
//                    flag=1;
//                    break;
//                }
//            }
//            if(flag==0){
//                yNum++;
//            }
//        }
//
//        int xNum=0;
//        for(int j=0;j<M;j++){
//            int flag=0;
//            for(int i=0;i<N;i++){
//                if(castle[i][j]=='X'){
//                    flag=1;
//                    break;
//                }
//            }
//            if(flag==0){
//                xNum++;
//            }
//        }
//
//        if(yNum<=xNum) System.out.println(xNum);
//        else System.out.println(yNum);
//    }
//}

public class _1236_성지키기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] castle= new char[N][M];

        for(int i=0;i<N;i++){
            castle[i]=sc.next().toCharArray();
        }

        boolean[] rowCheck = new boolean[N];
        boolean[] colCheck = new boolean[M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(castle[i][j]=='X'){
                    rowCheck[i]=true;
                    colCheck[j]=true;
                }
            }
        }

        int rowCount =0;
        int colCount =0;
        for(int i=0;i<N;i++){
            if(rowCheck[i]) rowCount++;
        }
        for(int j=0;j<M;j++){
            if(colCheck[j]) colCount++;
        }

        System.out.println(Math.max(N-rowCount,M-colCount));
    }
}
