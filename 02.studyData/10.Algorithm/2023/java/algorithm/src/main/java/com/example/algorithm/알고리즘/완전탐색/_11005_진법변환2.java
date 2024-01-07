package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _11005_진법변환2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
        
        List<Character> s = new ArrayList<>();
        while(number >0){
            int ret1 = number/N;
            int ret2 = number%N;
            if(ret1>=10) s.add((char) (ret2-10+'A'));
            number = number /=N;
        }

        for(int i=s.size()-1;i>=0;i--){
            bw.write(s.get(i));
        }

        bw.flush();
    }
}
