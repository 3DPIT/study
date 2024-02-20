package com.example.algorithm.알고리즘.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        for(int i=0;i<N;i++){
            words[i] = br.readLine();
        }

        Arrays.sort(words, (o1, o2)->{
            if(o1.length()==o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        });

        for(String word : words){
    System.out.println(word);
        }
    }
}

/*
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
 */