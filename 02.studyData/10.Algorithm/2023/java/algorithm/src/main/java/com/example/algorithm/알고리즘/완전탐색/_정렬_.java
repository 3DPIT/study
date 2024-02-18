package com.example.algorithm.알고리즘.완전탐색;

import java.util.*;

public class _정렬_ {
    static int[] d =new int[10004];
    static boolean[] used=new boolean[10004]; // 원소 사용 여부를 체크할 배열
    static List<Integer>rets =new ArrayList<>(); // 원소 사용 여부를 체크할 배열

    public static void main(String[] args) {
//        int[] arr = {50, 98, 38, 11, 13, 90, 82, 83,70};
       // int[] arr={3,-2,8,5,3,9};
//        int[] arr={2,3,0,6,-1,7,-2,13};
        int[] arr={0};
        int[] ret = solutoin(arr);
        int[] check= new int[10004];

    System.out.println(Arrays.toString(ret));
    }
    public static int[] solutoin(int[] arr){
        arr = Arrays.stream(arr).distinct().toArray();
        Arrays.sort(arr);
        int[] answer=new int[arr.length];

        int oneMethod= arr.length%2==0? (arr.length/2)+1:(arr.length/2)+1;
        int twoMethod= arr.length%2==0? (arr.length/2):(arr.length/2)+1;
        dfs(0,0,arr,oneMethod,twoMethod);

        for(int i=0;i<rets.size();i++){
            answer[i]=rets.get(i);

        }
        return answer;
    }

    public static void dfs(int idx, int cnt, int[] arr,int oneMethod,int twoMethod) {
        if(rets.size()!=0) return;
        if (cnt == arr.length) { // 모든 원소를 선택했으면 출력

            int checkArr[]=new int[arr.length];
            checkArr[0]=d[0];
            int index=1;
            for(int i=1;i<arr.length;i+=2){
                checkArr[i]=d[index++];
            }
            for(int i=2;i<arr.length;i+=2){
                checkArr[i]=d[index++];
            }
//            int checkArr1[]={70,82,50,83,38,90,13,98,11};
//
            int checkNumber = checkArr[0];
            for(int i=1;i<arr.length;i+=2){
                if(checkNumber>checkArr[i]){
                    return;
                }
                checkNumber=checkArr[i];
            }
            checkNumber=checkArr[0];
            for(int i=2;i<arr.length;i+=2){
                if(checkNumber<checkArr[i]){
                    return;
                }
                checkNumber=checkArr[i];
            }
            for(int i=0;i<checkArr.length;i++){
                rets.add(checkArr[i]);
            }

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) { // 아직 선택되지 않은 원소라면
                used[i] = true; // 원소 사용 표시
                d[cnt] = arr[i]; // 순열 배열에 추가
                dfs(0, cnt + 1, arr,oneMethod,twoMethod); // 다음 원소 선택을 위해 재귀 호출
                used[i] = false; // 원소 사용 해제
            }
        }
    }
}