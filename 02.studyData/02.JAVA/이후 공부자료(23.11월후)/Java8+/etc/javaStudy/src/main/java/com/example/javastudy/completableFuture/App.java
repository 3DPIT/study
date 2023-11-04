package com.example.javastudy.completableFuture;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Future<String> future = executorService.submit(() -> "hello");
//
//        //TODO
//        future.get();

        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("kmp");
        System.out.println(future.get());

        CompletableFuture<String> future1 = CompletableFuture.completedFuture("kmp1");
        System.out.println(future1.get());


        //리턴이 없는 작업
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());
        });
        future2.get();

        //리턴이 있는 작업
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());

            return "Hello3";
        });
        System.out.println( future3.get());

        //콜백 사용

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());

            return "Hello4";
        }).thenApply((s)->{
            System.out.println(Thread.currentThread().getName());

            return s.toUpperCase();
        });
        System.out.println( future4.get());

        //콜백 리턴이 없는 경우
        CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());

            return "Hello5";
        }).thenAccept((s)->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        future5.get();

        //리턴 필요없고 그냥하면됨
        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());

            return "Hello6";
        }).thenRun(()->{
            System.out.println(Thread.currentThread().getName());
        });
        future6.get();

        //ThreaPool 안하고 어떻게 함? ForkJoinPool을 사용 디큐 방식으로되어 있다고 함

    }
}
