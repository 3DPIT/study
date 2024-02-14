package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;
import java.lang.reflect.Member;
import java.util.*;


public class _2817_ALPS식투표 {

    public static class Member{
        char PeopleName;
        int electCount;

        public Member(char peopleName, int electCount) {
            PeopleName = peopleName;
            this.electCount = electCount;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int electNumber = Integer.parseInt(br.readLine());
        int people = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();
        Member memberA = new Member('A',107382);
        Member memberB= new Member('C',18059);
        Member memberC= new Member('B',43265);


        members.add(memberA);
        members.add(memberB);
        members.add(memberC);

        Collections.sort(members, new Comparator<Member>(){
            @Override
            public int compare(Member m1, Member m2){
                return Integer.compare(m2.electCount, m1.electCount);
            }
        });

        for( Member member : members){
            System.out.println(member.PeopleName + " "+ member.electCount);
        }

    }
}
