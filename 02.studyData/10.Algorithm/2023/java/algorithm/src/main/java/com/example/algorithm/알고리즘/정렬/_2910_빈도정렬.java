package com.example.algorithm.알고리즘.정렬;


import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/2910
 */
public class _2910_빈도정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int numberCount = Integer.parseInt(st.nextToken());
//
//        Set<Integer> inputSet = new LinkedHashSet<>();
//
//        Map<Integer , Integer> m = new HashMap<>();
//        Map<Integer , Integer> m2 = new HashMap<>();
//
//        String[] inputs = br.readLine().split(" ");
//        List<Integer> inputList = new ArrayList<>(inputs.length);
//
//        for(int i=0;i<N;i++){
//            int input = Integer.parseInt(inputs[i]);
//            inputSet.add(input);
////            inputList.add(input);
//            m.put(input, m.getOrDefault(input, 0)+1);
//        }
//
//        Iterator<Integer> it = inputSet.iterator();
//        for(int i=0;i<inputSet.size();i++){
//            m2.put(it.next(),i);
//        }
//
//        for(int i=0;i<N;i++){
//            inputList.add(m.get(i));
//        }
//
//        inputList.sort((o1,o2)->{
//            if(m.get(o1).equals(m.get(o2))){
//                return m2.get(m.get(o1)).compareTo(m2.get(m.get(o2)));
//            }
//
//            return m.get(o1).compareTo(m.get(o2));
//        });

        String[] inputs = br.readLine().split(" ");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<N;i++){
            int message = Integer.parseInt(inputs[i]);
            map.put(message, map.getOrDefault(message, 0)+1);
        }

        Integer[] frequenceNumber = map.keySet().toArray(new Integer[map.size()]);

        Arrays.sort(frequenceNumber, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return map.get(o2)-map.get(o1);
            }
        });

        for(int number: frequenceNumber){
            for(int i=0;i<map.get(number);i++) {
                bw.write(number + " ");
            }
        }

        bw.flush();


        //정렬된 좌표를 ㅈ
        // 정렬하고
        // 정렬된것 숫자의 빈도가 같으면 먼저 나온것을 먼저로 한다.

        //작은 순 정렬
        //
    }
}

/*
5 2
2 1 2 1 2

2 2 2 1 1
 */

/*
9 3
1 3 3 3 2 2 2 1 1

1 1 1 3 3 3 2 2 2
 */