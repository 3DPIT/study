package com.example.algorithm.알고리즘.test;

import java.util.Arrays;
import java.util.Comparator;

public class _주식_ {

    public static void main(String[] args) {
//        int ret =  solution(new int[]{100, 50,150}, new int[]{120,200,160}, 2);
//        int ret =  solution(new int[]{10,10,10}, new int[]{5,5,5}, 6);
//        int ret =  solution(new int[]{5,5,5,5}, new int[]{10,10,10,10}, 6);
        int ret =  solution(new int[]{8,10,9}, new int[]{7,4,9}, 4);
        System.out.println(ret);
    }
    public  static int solution(int[] bid, int[] ask, int n){
        int answer =0;

        Arrays.sort(ask);

       Integer[] bid2 = Arrays.stream(bid).boxed().toArray(Integer[]::new);
       Arrays.sort(bid2, Comparator.reverseOrder());

        for(int i=0,j=0;j<n;i++,j+=2){
            int sum = bid2[i]-ask[i];
            if(sum<0) return 0;
            answer+=sum;

        }
        return answer;
    }
}
