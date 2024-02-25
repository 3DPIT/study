package com.example.algorithm.알고리즘.정렬;


import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/2910
 */
public class _2910_빈도정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int numberCount = Integer.parseInt(st.nextToken());

        Set<Integer> inputSet = new HashSet<>();

        Map<Integer , Integer> m = new HashMap<>();

        String[] inputs = br.readLine().split(" ");
        List<Integer> inputList = new ArrayList<>(inputs.length);

        for(int i=0;i<N;i++){
            int input = Integer.parseInt(inputs[i]);
            inputSet.add(input);
            inputㅣㅣㅣㄴaa
        put(input,m.getOrㅋDefault(input, 0)+1);
        }


        // 정렬하고
        // 정렬된것 숫자의 빈도가 같으면 먼저 나온것을 먼저로 한다.
    }
}

/*
5 2
2 1 2 1 2

2 2 2 1 1
 */

/*
9 3
1 3 3 3 2 2 2 1 1

1 1 1 3 3 3 2 2 2
 */