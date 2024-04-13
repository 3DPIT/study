package com.example.algorithm.알고리즘.문자열;

import java.util.HashMap;
import java.util.Scanner;

//public class _13223_소금폭탄 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String currentTime = scanner.next();
//        String nextTime = scanner.next();
//
//        int cHour = Integer.parseInt(currentTime.substring(0,2));
//        int cMinute = Integer.parseInt(currentTime.substring(3,5));
//        int cSecond = Integer.parseInt(currentTime.substring(6,8));
//
//        int nHour =  Integer.parseInt(nextTime.substring(0,2));
//        int nMinute = Integer.parseInt(nextTime.substring(3,5));
//        int nSecond = Integer.parseInt(nextTime.substring(6,8));
//
//        nHour = nHour-cHour;
//        nMinute = nMinute-cMinute;
//        nSecond = nSecond-cSecond;
//        if(nSecond<0) {
//            nSecond=60+nSecond;
//            nMinute--;
//        }
//        if(nMinute<0) {
//            nMinute=60+nMinute;
//            nHour--;
//        }
//        if(nHour<=0) {
//            nHour=24+nHour;
//        }
//
//        String resultTime = String.format("%02d:%02d:%02d",nHour,nMinute,nSecond);
//        System.out.println(resultTime);
//    }
//}

public class _13223_소금폭탄 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentTime = scanner.next();
        String nextTime = scanner.next();

        int cHour = Integer.parseInt(currentTime.substring(0,2))*3600;
        int cMinute = Integer.parseInt(currentTime.substring(3,5))*60;
        int cSecond = Integer.parseInt(currentTime.substring(6,8));

        int nHour =  Integer.parseInt(nextTime.substring(0,2))*3600;
        int nMinute = Integer.parseInt(nextTime.substring(3,5))*60;
        int nSecond = Integer.parseInt(nextTime.substring(6,8));


        int resultTime =(nHour+nMinute+nSecond)-(cHour+cMinute+cSecond);
        if(resultTime<=0){
            resultTime+=24*3600;
        }
        nHour = resultTime/3600;
        nMinute = (resultTime%3600)/60;
        resultTime= resultTime%60;
        nSecond = resultTime;

        String ret = String.format("%02d:%02d:%02d",nHour,nMinute,nSecond);
        System.out.println(ret);
    }
}