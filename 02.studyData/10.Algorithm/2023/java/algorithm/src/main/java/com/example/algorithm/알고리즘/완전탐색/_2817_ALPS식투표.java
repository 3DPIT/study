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
            double fivePercentNumber = ((electCount*100/electNumber));
            //5% 이상인 후보만 출력
            if(fivePercentNumber>=5.0){
                map.put(peopleName,0);
                //14개로 나누기
                for(int j=1;j<=14;j++){
                   double score = electCount/j;
                   members.add(new Member(peopleName,score));
                }
            }
        }




        Collections.sort(members, new Comparator<Member>(){
            @Override
            public int compare(Member m1, Member m2){
                return Double.compare(m2.electCount, m1.electCount);
            }
        });

        for (int i = 0; i < 14; i++) {
            // Map에 해당 PeopleName 키가 존재하지 않는 경우, 해당 키와 값 1을 추가합니다.
            if (!map.containsKey(members.get(i).PeopleName)) {
                map.put(members.get(i).PeopleName, 1);
            } else {
                // Map에 이미 해당 PeopleName 키가 존재하는 경우, 기존 값을 가져와 1을 더한 후 다시 저장합니다.
                map.put(members.get(i).PeopleName, map.get(members.get(i).PeopleName) + 1);
            }
        }

        map.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
