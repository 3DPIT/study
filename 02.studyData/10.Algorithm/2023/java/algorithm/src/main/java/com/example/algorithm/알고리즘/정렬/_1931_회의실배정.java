package com.example.algorithm.알고리즘.정렬;

import java.io.*;
import java.util.*;

/*
√ */
public class _1931_회의실배정 {
    public static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new TreeMap<>();
        Meeting[] meetings = new Meeting[N];
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            meetings[i]=new Meeting(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }

        Arrays.sort(meetings, (o1, o2)->{
            if(o1.end == o2.end){
                return o1.start-o2.start;
            }
            return o1.end-o2.end;
        });

        int ret=0;
        int end=0;
        for(int i=0;i<N;i++){
            if(end<=meetings[i].start){
                ret++;
                end=meetings[i].end;
            }
        }

        bw.write(ret+"\n");

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