package com.example.javastudy.parallel;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int size= 1500;
        int[] numbers = new int[size];
        Random random = new Random();
        IntStream.range(0,size).forEach(i -> numbers[i] = random.nextInt());

        long start = System.nanoTime();
        Arrays.sort(numbers); //퀵소트 사용 스레드 싱글로 사용함
        System.out.println("serial sorting took "+ (System.nanoTime() - start));

        IntStream.range(0,size).forEach(i ->numbers[i]= random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers); //머지소트를 사용함, 여러 스레드를 사용함
        System.out.println("parallel sorting took "+ (System.nanoTime()- start));
    }
}
