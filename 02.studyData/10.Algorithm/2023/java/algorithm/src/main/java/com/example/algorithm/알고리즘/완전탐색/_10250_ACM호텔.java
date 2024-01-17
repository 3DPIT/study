package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;

public class _10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(--T >=0) {
            var input = br.readLine().split(" ");
            int y = 1;
            int x = 1;
            int peopleNumber = Integer.parseInt(input[2]);
            int count=1;
            for(int i=1;i<=Integer.parseInt(input[1]);i++){
                for(int j=1;j<=Integer.parseInt(input[0]);j++){
                    if(count==peopleNumber){
                        y=i;
                        x=j;
                    }
                    count++;
                }
            }

            int ret = (x * 100) + y;
            bw.write(ret + "\n");
            bw.flush();
        }
    }
}
