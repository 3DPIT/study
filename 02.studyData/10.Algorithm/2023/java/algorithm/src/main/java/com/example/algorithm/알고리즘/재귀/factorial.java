package com.example.algorithm.알고리즘.재귀;

import java.io.*;

public class factorial {

    private static int fac(int num){ //for(int i=0;i<n;i++)
        if(num ==1){ //탈출 조건 무조건 필요
            return 1;
        }

        return num *fac(num-1); // 동작하는거 for -> facNumber = facNumber*(n-1);
    }

//    5 * 4
//        4 * 3
//            3 * 2
//                2 * 1
//                    1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());

        int facNumber = n;
       int ret = fac(n);
        bw.write(ret+"\n");

        for(int i=0;i<n;i++){
            facNumber = facNumber*(n-1);
            n= n-1;
        }

        bw.write(facNumber+"\n");

        bw.flush();
    }
}
