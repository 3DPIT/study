package com.example.javastudy.annotation;

import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘")
public class App {
    public static void main(String[] args) {
        //자바 8버전 이후 애노테이션 타입 선언부에서도 사용
        // 중복해서 사용 가능

        //배열로 가져오기
        Chicken[] chickens  = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c->{
            System.out.println(c.value());
        });

       // 컨테이너로 가져오기
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c ->{
            System.out.println(c.value());
        });
    }

//    static class FeelsLikeChicken<@Chicken T>{///TYPE_PARAMETER
//        public static <@Chicken C> void print(C c){ //TYPE_PARAMETER
//
//        }
//    }
}
