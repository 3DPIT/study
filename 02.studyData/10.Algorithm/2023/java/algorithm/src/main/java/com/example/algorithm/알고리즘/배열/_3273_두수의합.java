package com.example.algorithm.알고리즘.배열;

import java.io.*;
import java.util.Arrays;

public class _3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] numbers = br.readLine().split(" ");
        for(int i=0;i<numbers.length;i++){
            arr[i]= Integer.parseInt(numbers[i]);
        }
        int x = Integer.parseInt(br.readLine());

        int s =0;
        int e = arr.length-1;
        int ret=0;
        Arrays.sort(arr);

        while(s!=e){
            int sum = arr[s]+arr[e];
            if(x <=sum) {
                if(sum == x){
                    ret++;
                }
                e--;
            }
            else s++;
        }

        bw.write(ret+"\n");


        bw.flush();
    }
}
