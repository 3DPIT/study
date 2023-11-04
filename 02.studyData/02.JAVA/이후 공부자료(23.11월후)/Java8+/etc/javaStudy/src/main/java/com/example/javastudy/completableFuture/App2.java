package com.example.javastudy.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //서로 의존성이 있는 경우 아래와 같이 함
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        });

//
//        hello.get();
//        world.get();

        CompletableFuture<String> future = hello.thenCompose(App2::getWorld);
        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(message+ Thread.currentThread().getName());

            return message + "World";
        });
    }
}
