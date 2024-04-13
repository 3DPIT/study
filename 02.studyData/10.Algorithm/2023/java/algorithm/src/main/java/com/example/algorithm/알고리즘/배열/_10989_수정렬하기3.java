package com.example.algorithm.알고리즘.배열;

import java.io.*;

public class _10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10004];
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        for(int i=1;i<=10000;i++){
            for(int j=0;j<arr[i];j++){
                bw.write(i+"\n");
            }
        }

        bw.flush();
    }
}
