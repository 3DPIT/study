package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;

public class _10448_유레카이론 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());

        int[]arr = new int[45];
        for(int i =1 ; i<46;i++){
            arr[i-1] = (i*(i+1))/2;
        }

        while(N-->0) {
            int K= Integer.parseInt(br.readLine());

            int flag = 0;
            for (int i = 0; i < 45; i++) {
                for (int j = 0; j < 45; j++) {
                    for (int k = 0; k < 45; k++) {
                        int sum = arr[i] + arr[j] + arr[k];
                        if (sum > K) continue;
                        if (sum == K) {
                            bw.write(1 + "\n");
                            flag = 1;
                        }
                        if (flag == 1) break;
                    }
                    if (flag == 1) break;
                }
                if (flag == 1) break;
            }
            if (flag == 0)
                bw.write(0 + "\n");
        }
        bw.flush();
    }
}