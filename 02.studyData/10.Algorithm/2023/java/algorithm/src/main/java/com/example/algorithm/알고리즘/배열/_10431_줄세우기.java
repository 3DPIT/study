package com.example.algorithm.알고리즘.배열;

import java.util.Scanner;

//public class _10431_줄세우기 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        for(int i=1;i<=N;i++){
//            int number = sc.nextInt();
//            int[]arr = new int[20];
//            for(int j=0;j<20;j++){
//                arr[j]=sc.nextInt();
//            }
//            int P=0;
//            int ret=0;
//            while(true) {
//                if (P==19) {
//                    break;
//                }
//                for (int j = 0; j < 19; j++) {
//                    if (arr[j] > arr[j + 1]) {
//                        int copyNum = arr[j];
//                        arr[j]= arr[j+1];
//                        arr[j+1]= copyNum;
//                        P=0;
//                        ret++;
//                        break;
//                    } else {
//                        P++;
//                    }
//                }
//            }
//
//            System.out.println(number+" "+ret);
//        }
//    }
//}
public class _10431_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1;i<=N;i++){
            int number = sc.nextInt();
            int[]arr = new int[20];
            for(int j=0;j<20;j++){
                arr[j]=sc.nextInt();
            }

            int ret=0;
            for(int j=0;j<20;j++){
                for(int k=0;k<j;k++){
                    if(arr[j]<arr[k]) ret++;
                }
            }
            System.out.println(number+" "+ret);
        }
    }
}
