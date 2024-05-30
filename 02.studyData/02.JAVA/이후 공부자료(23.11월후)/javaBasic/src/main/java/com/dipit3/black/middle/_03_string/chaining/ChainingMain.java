package com.dipit3.black.middle._03_string.chaining;

public class ChainingMain {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();

        adder.add(1).add(2);

        int result = adder.getValue();

        System.out.println(result);
    }
}
