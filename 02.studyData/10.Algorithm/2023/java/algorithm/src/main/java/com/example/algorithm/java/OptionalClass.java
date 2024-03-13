package com.example.algorithm.java;

import java.util.Optional;

public class OptionalClass {

    public static String getSomeString(){
        return null; //이 메서드는 항상 null을 반환
    }

    public static Optional<String> getSomStringOptional(){
        return Optional.empty();
    }

    public static Optional<String> getSomeStringOptionalWithValue(){
        return Optional.ofNullable("public static void");
    }
    public static void main(String[] args) {

        //일반적으로 우리가 구현하는 경우
        String isThisNull = getSomeString();

        if(null != isThisNull){
            System.out.println(isThisNull);
        }


        //비어있는 경우
        Optional<String> isThisNullOptional = getSomStringOptional();
        isThisNullOptional.ifPresent(str -> System.out.println(str.toUpperCase())); //ifPresent empty아니면 안에 있는것 실행하게함


        //값이 있는 경우
        Optional<String> isThisNullOptionalWithValue = getSomeStringOptionalWithValue();
        isThisNullOptionalWithValue.ifPresent(str -> System.out.println(str.toUpperCase()));

    }
}
