package com.example.algorithm.알고리즘.정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class _7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String,Integer> hm  = new HashMap<>();
        for(int i=0 ;i <N;i++){
            String[] st = br.readLine().split(" ");
            if(st[1].equals("leave")){
                hm.remove(st[0]);
            }
               //제거
            else
                hm.put(st[0],1);
        }

        List<String> ret = new ArrayList<>();
        for(String hmName: hm.keySet()){
            ret.add(hmName);
        }

        for(int i=ret.size()-1;i>=0;i--){
            bw.write(ret.get(i)+"\n");
        }
        bw.flush();
        //map 써서 enter면 무조건 넣고
        //leave면 무조건 빼고
        //역순 정렬출력
    }
}


/*
4
Baha enter
Askar enter
Baha leave
Artem enter
*/

/* 역순 출력
Askar
Artem
*/
