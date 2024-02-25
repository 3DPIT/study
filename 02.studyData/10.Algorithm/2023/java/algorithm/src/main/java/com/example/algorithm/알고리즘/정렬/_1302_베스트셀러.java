package com.example.algorithm.알고리즘.정렬;

import java.io.*;
import java.util.*;

public class _1302_베스트셀러 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> products = new HashMap<>();
        int N= Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String product = br.readLine();
            products.put(product,products.getOrDefault(product,0)+1);
        }

        List<String> keySet = new ArrayList<>(products.keySet());

//        keySet.sort(new Comparator<String>(){
//          @Override
//            public int compare(String o1, String o2){
//              return products.get(o1).compareTo(products.get(o2));
//          }
//        });
//
        keySet.sort((o1,o2)-> {
            if(products.get(o1).equals(products.get(o2))){
                return o1.compareTo(o2);
            }
            return products.get(o2).compareTo(products.get(o1));
        });

//        for(String key :keySet){
//            bw.write("key: " + key+"\n");
//            bw.write("value: " + products.get(key)+"\n");
//        }
        bw.write(keySet.get(0));

//        Arrays.sort(products, (o1, o2)->{
//
//            return o1.
//        });



        bw.flush();
    }
}
