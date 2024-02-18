package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;
import java.lang.reflect.Member;
import java.util.*;


public class _2817_ALPS식투표 {

    public static class Member{
        char PeopleName;
        double electCount;

        public Member(char peopleName, double electCount) {
            PeopleName = peopleName;
            this.electCount = electCount;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int electNumber = Integer.parseInt(br.readLine());
        int peopleNumber = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();
//
        Member[] resultMember = new Member[peopleNumber];
//        Member memberA = new Member('A',107382);
//        Member memberB= new Member('C',18059);
//        Member memberC= new Member('B',43265);
//
        Map<Character,Integer> map= new HashMap<>();

        for(int i=0; i<peopleNumber;i++){
            String[] inputs= br.readLine().split(" " );
            char peopleName = inputs[0].charAt(0);
            int electCount = Integer.parseInt(inputs[1]);
            double fivePercentNumber = (electCount%electNumber)*100;
            //5% 이상인 후보만 출력
            if(fivePercentNumber>=5){
                map.put(peopleName,0);
                //14개로 나누기
                for(int j=1;j<=14;j++){
                   double score = electCount/j;
                   members.add(new Member(peopleName,score));
                }
            }
        }

//        235217
//        3
//        A 107382
//        C 18059
//        B 43265


        Collections.sort(members, new Comparator<Member>(){
            @Override
            public int compare(Member m1, Member m2){
                return Double.compare(m2.electCount, m1.electCount);
            }
        });

        for( int i=0;i<14;i++){
                map.put(members.get(i).PeopleName,map.get(members.get(i).electCount)+1);
        }

        for(int i=0;i<peopleNumber;i++){
            if(map.get(resultMember[i].PeopleName)==0){
                bw.write(resultMember[i].PeopleName);
            }
        }
    }
}
