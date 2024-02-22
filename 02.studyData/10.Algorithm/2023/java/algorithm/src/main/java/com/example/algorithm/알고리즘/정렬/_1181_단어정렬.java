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

//        StringBuilder sb = new StringBuilder();
//        for(String word : words){
//            if(sb.length()==0||sb.indexOf(word)==-1){
//                sb.append(word);
//                sb.append("\n");
//            }
//        }

        for(int i=0;i<words.length-1;i++){
            if(!words[i].equals(words[i+1])){
                bw.write(words[i]+"\n");
            }
        }
        bw.write(words[words.length-1]+"\n");

        bw.flush();
//        System.out.println(sb.toString());
    }
}

/*
14
but
i
wont
hesitate
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