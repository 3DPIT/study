package com.example.algorithm.알고리즘.test.main2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[][] fees = {{16, 2000}, {6, 1000}, {21, 3000}, {16,2000}, {26, 3000}};
//        int t = 27;
        int[][] fees = {{3, 40000}, {5, 60000}};
        int t = 2;

        solution(fees, t);
    }

    public static long[] solution(int[][] fees, int t) {
        long[] answer = {};

        int IndexStart = 1000000004;
        int IndexEnd = -1;
        int IndexStart1 = 1000000004;
        int IndexEnd1 = -1;
        for(int[] fee: fees){
            if(IndexStart>fee[0])IndexStart=fee[0];
            if(IndexEnd<fee[0])IndexEnd=fee[0];
            if(IndexStart1>fee[1])IndexStart1=fee[1];
            if(IndexEnd1<fee[1])IndexEnd1=fee[1];
        }

        Map<Integer,Integer> map= new HashMap<Integer, Integer>();
        for (int a = 1; a <=IndexEnd1; a++) {
            for (int b = 1; b <=IndexEnd1; b++) {
                int count=0;
                for (int[] fee : fees) {
                    int T = 0;
                    List<Integer> tList=new ArrayList<>();

                    int minute = fee[0];
                    int cost = fee[1];

                    //확인 로직
                    while (true) {
                        T += a;
                        tList.add(T);
                        if (T > minute) {
                            tList.remove(tList.size()-1);
                            T -= a;
                            break;
                        }

                    }
                    int sumFee = (tList.size()+1)*b;
                    if(sumFee==cost){
                        count++;
                    }
                }
                if(count==fees.length){
                    map.put(a,b);
                }
            }
        }
        return answer;
    }
}
