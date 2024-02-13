package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;

public class _2840_행운의바퀴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int T = Integer.parseInt(inputs[1]);

        Character[] wheel = new Character[N];
        int idx = 0;
        for(int i=0;i<T;i++){
            String[] rotationCountAndAlphabet = br.readLine().split(" ");
            int rotationCount = Integer.parseInt(rotationCountAndAlphabet[0]);
            char alphabet = rotationCountAndAlphabet[1].charAt(0);

            while(rotationCount-- > 0){
                idx = (idx+1)%N;
            }

            if(wheel[idx]==null){
                wheel[idx]=alphabet;
            }
            else if(wheel[idx]!=alphabet){
                bw.write("!");
                bw.flush();
                return;
            }
        }

        int[] checkedAlphabet = new int[26];
        for(int i=0;i<N;i++){
            if(wheel[i]==null) continue;
            checkedAlphabet[wheel[i]-'A']++;
            if(checkedAlphabet[wheel[i]-'A']>1){
                bw.write("!");
                bw.flush();
                return;
            }
        }

        for(int i=0;i<N;i++){
            if(wheel[idx]==null) bw.write("?");
            else
                bw.write(wheel[idx]);
            idx = ((idx-1)+N)%N;
        }

        bw.flush();
    }
}
//public class _2840_행운의바퀴 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int T = Integer.parseInt(input[1]);
//
//        String arr[] = new String[N];
//        int ci = 0;
//        for(int t=0;t<T;t++){
//            String[] input2 = br.readLine().split(" ");
//            int rotationNumber = Integer.parseInt(input2[0]);
//            char alpabet =input2[1].charAt(0);
//            for(int i=0; i<rotationNumber;i++){
//                ci++;
//                if(ci==N){
//                    ci=0;
//                }
//            }
//            if(arr[ci]==null|| arr[ci].equals(Character.toString(alpabet))){
//                arr[ci]=Character.toString(alpabet);
//            }else {
//                bw.write("!");
//                bw.flush();
//                return ;
//            }
//        }
//
//        T = N;
//        int idx =ci;
//        while(T-- >0){
//            if(arr[idx]==null) System.out.print("?");
//            else
//              System.out.print(arr[idx]);
//            idx--;
//            if(idx<0) idx=N-1;
//        }
//        bw.flush();
//    }
//}