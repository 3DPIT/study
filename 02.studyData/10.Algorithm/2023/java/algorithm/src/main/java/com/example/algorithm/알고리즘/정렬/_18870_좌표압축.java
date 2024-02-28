package com.example.algorithm.알고리즘.정렬;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class _18870_좌표압축 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> inputSet = new TreeSet<>();
        String[] inputs = br.readLine().split(" ");

        for(int i=0;i<N;i++){
            inputSet.add(Integer.parseInt(inputs[i]));
        }

        Map<Integer,Integer>map = new HashMap<>();
        int idx=0;
        for(int input : inputSet){
            map.put(input, idx++);
        }

        for(int i=0;i<N;i++){
            bw.write(map.get(Integer.parseInt(inputs[i]))+" ");
        }
bw.flush();
        //
//
//
//        Set<Integer> inputSet = new TreeSet<>();
//        String[] inputs = br.readLine().split(" ");
//        int xs[] = new int[N];
//
//        for(int i=0;i<N;i++){
//            inputSet.add(Integer.parseInt(inputs[i]));
//        }
//
//        Map<Integer, Integer> hm = new HashMap<>();
//        int idx=0;
//
//        for(int input: inputSet){
//            hm.put(input, idx++);
//        }
//
//        for(int i=0;i<N;i++){
//            bw.write(hm.get(Integer.parseInt(inputs[i]))+" ");
//        }
//

        bw.flush();
    }
}
