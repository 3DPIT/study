package com.dipit3.black.basic._06_accessModifier.ex1.study;

public class Maxcount {
    private int count;
    private final int max;

    public Maxcount(int max){
        this.max = max;
    }

    public void increment(){
        if(count >=max){
            System.out.println("최대값을 초과 할 수 없습니다.");
            return;
        }
        count++;
    }

    public int getCount(){
        return count;
    }
}
