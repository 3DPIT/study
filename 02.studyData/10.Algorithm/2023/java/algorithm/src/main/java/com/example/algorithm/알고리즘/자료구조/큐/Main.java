package com.example.algorithm.알고리즘.자료구조.큐;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs = br.readLine().split(" ");

        int [] visit = new int[50];
        int [] number = new int[50];

        for(int i=0; i<inputs[0].length(); i++){
            number[i] = i+1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(Integer.parseInt(inputs[1]));

        while(!q.isEmpty()){
            int c = q.peek(); q.poll();
            bw.write(c+" ");

            int cnt=0;
            for(int dir=0;dir<Integer.parseInt(inputs[1]);dir++){
               int n = c+dir;
                if(visit[n]==0){
                    cnt++;
                }

            }


        }

        bw.flush();
    }
}
/**
 7 3
 < 3, 6, 2, 7, 5, 1, 4 >
 */
