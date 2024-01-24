package com.example.algorithm.알고리즘.완전탐색;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {
//        String[] approved = {"123-4567", "451-2314", "015-1643"};
//        String[] spams = {"111-1111"};
//        String[] calls = {"123-4567", "000-0022", "015-1643", "000-0022", "111-1111", "000-0022", "111-1111", "111-1111"};
        String[] approved = {"123-1000"};
        String[] spams = {"456-2000"};
        String[] calls = {"456-2000", "456-2000", "123-1000", "123-1000", "789-3000", "7895-3000","789-3000","789-3000", "789-3000"};

       int[] answer = solution(approved, spams, calls, 2);

       for(int i=0;i<answer.length;i++){
           System.out.print(answer[i]);
       }
    }

    public static int[] solution(String[] approved, String[] spams, String[] calls, int k) {
        int[] answer = new int[calls.length];
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        int idx = 0;
        for (var call : calls) {
            Integer count = map.get(call);
            if (count == null) {
                count = 0;
            }

            boolean isApproved = false;
            boolean isSpam = false;

            for (var approve : approved) {
                if (approve.equals(call)) {
                    isApproved = true;
                }
            }
            for (var spam : spams) {
                if (spam.equals(call)) {
                    isSpam = true;
                }
            }
            if (isSpam) {
                answer[idx++]=1;
            }
            if (isApproved) {
                answer[idx++]=0;
            } else if(!isApproved && !isSpam) {
                map.put(call, count + 1);
                if (map.get(call) > k) {
                    answer[idx++]=0;
                } else {
                    answer[idx++]=1;
                }
            }
        }
        return answer;
    }
}
