package com.example.algorithm.알고리즘.정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
√ */
public class _1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            map.put(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        List<Integer> keyValue = new ArrayList<>(map.values());

        keySet.sort((o1,o2)->{
            if(o1.equals(o2)){
                return map.get(o2).compareTo(map.get(o1));
            }
            return o1.compareTo(o2);
        });

        keyValue.sort((o1,o2)->{
            if(o1.equals(o2)){
                return map.get(o1).compareTo(map.get(o2));
            }
            return o1.compareTo(o2);
        });


        for(int i=0;i<keySet.size();i++){
            bw.write("key"+" "+ map.get(keySet.get(i)) +"\n");

        }
        for(int i=0;i<keyValue.size();i++){
            bw.write("value"+" "+ map.get(keyValue.get(i)) +"\n");

        }
        bw.flush();
        // 시작시간 기준으로 오름차순, 끝시간 기준으로 오름차순
        // 0번 부터 n까지 검사 시작
        // 선택된것의 종료시간 이후에서 가장 처음꺼를 기준으로 계산 하여 count 계산
        
        // 최댓값 출력 끝

    }
}


/*
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

4

hint
(1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다.
 */