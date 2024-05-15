package com.dipit3.black._06_accessModifier.ex1.study;

/**
 * Created by black on 2024-05-16
 */
public class MaxcountMain {
    public static void main(String[] args) {
        Maxcount counter = new Maxcount(3);
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        int count = counter.getCount();
        System.out.println(count);
    }
}
