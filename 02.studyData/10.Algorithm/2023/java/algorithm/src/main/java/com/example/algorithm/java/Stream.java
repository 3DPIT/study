package com.example.algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List list = new ArrayList<String>();

        list.add("public");
        list.add("static");
        list.add("void");

        // for문 으로 List 순회
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }

        //제거
        list.remove(1);

        //인덱스 반환
        list.indexOf("public");

        list.stream().forEach(str -> System.out.println(str));
        list.stream().forEach(System.out::println);


        Integer[] integerArray = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> integerList = Arrays.asList(integerArray);

        List evenList = new ArrayList<Integer>();

        //for , if문을 이용한 필터링
        for(int i=0;i<list.size();i++){
            Integer number =integerList.get(i);
            if(number %2 ==0){
                evenList.add(number);
            }
        }

        //stream을 이용한 필터링
        List evenList2 = integerList.stream().filter(number -> number %2 ==0).collect(Collectors.toList());

        evenList2.forEach(System.out::println);


        //특정 로직 적용 후 리스트화
        String[] lowercaseArray = new String[]{"public","static","void"};
        List<String> lowercaseList = Arrays.asList(lowercaseArray);
        List<String> uppercaseList = lowercaseList.stream()
                .map(value -> value.toUpperCase()).toList();

        uppercaseList.stream().forEach(value->System.out.println(value));

    }
}
