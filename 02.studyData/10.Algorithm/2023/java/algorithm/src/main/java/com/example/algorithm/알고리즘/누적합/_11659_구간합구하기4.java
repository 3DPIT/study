package com.example.algorithm.알고리즘.누적합;

import java.io.*;

public class _11659_구간합구하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs =  br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String[] InputNumbers = br.readLine().split(" ");

        int[] numbers = new int[N];
        for(int i=0 ;i<N;i++){
            numbers[i]= Integer.parseInt(InputNumbers[i]);
        }

        for(int i=0;i<M;i++){
            String[] inputIndexs = br.readLine().split(" ");
            int sum =0;
            for(int j=Integer.parseInt(inputIndexs[0])-1;j<Integer.parseInt(inputIndexs[1]);j++){
                sum += numbers[j];
            }

            bw.write(sum +"\n");
            bw.flush();
        }
    }
}


/*
https://www.acmicpc.net/problem/11659

5 3
5 4 3 2 1
1 3
2 4
5 5


12
9
1
 */