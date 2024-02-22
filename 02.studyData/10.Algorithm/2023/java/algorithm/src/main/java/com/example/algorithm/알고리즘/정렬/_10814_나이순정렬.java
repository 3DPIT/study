package com.example.algorithm.알고리즘.정렬;

import java.io.*;
import java.util.Arrays;

public class _10814_나이순정렬 {

    static class Member{
        int id;
        int age;
        String name;

        public Member(int id, int age, String name){
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
//        List<Member> Member = new ArrayList<>();
        Member[] members = new Member[N];
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members[i] = new Member(i,age,name);
        }

        Arrays.sort(members,(o1, o2)-> {
            //나이가 같으면 가입순
            //그게 아니면 나이순
            if (o1.age == o2.age) {
                return o1.id - o2.id;
            }
            return o1.age - o2.age;
        });

        for(Member member : members){
            bw.write(member.age+" "+member.name+"\n");
        }

        bw.flush();
    }
}

//나이가 같으면 가입한 순으로
/*
3
21 Junkyu
21 Dohyun
20 Sunyoung
*/

/*
20 Sunyoung
21 Junkyu
21 Dohyun
*/