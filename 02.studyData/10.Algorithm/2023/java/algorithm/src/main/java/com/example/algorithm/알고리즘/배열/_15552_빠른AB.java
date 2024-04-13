package com.example.algorithm.알고리즘.배열;

import java.io.*;

public class _15552_빠른AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while(N-- >0){
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);

            bw.write(a+b+"\n");
        }
        bw.flush();
    }
}
