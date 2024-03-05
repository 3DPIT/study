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

        int[] sumNumberArrays = new int[N+1];
        sumNumberArrays[0]= Integer.parseInt(InputNumbers[0]);
        for(int i=1 ;i<N;i++){
            sumNumberArrays[i] =sumNumberArrays[i-1]+ Integer.parseInt(InputNumbers[i]);
        }
        /*
        0 0+1 1+2 2+3
        5 4 3  2  1
        5 9 12 14 15
        1 2 3  4  5

        14 = 5 + 4 + 3 + 2
        9  = arr[4] - arr[2-1]
        = arr[j] - arr[i-1];

        // i 5 j 5
        arr[5] - arr[4] = 15-14;



        1 ~ 3 12
        2 ~ 4  9 =
        */

        for(int i=0;i<M;i++) {
            String[] inputIndexs = br.readLine().split(" ");
            int startIndex = Integer.parseInt(inputIndexs[0])-1;
            int endIndex = Integer.parseInt(inputIndexs[1])-1;
            int sum =0;
            if(startIndex-1<0){
                sum = sumNumberArrays[endIndex];
            }
            else{
                sum = sumNumberArrays[endIndex]-sumNumberArrays[startIndex-1];
            }
/*
            5 9 12 14 15

  */
            bw.write(sum+"\n");
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