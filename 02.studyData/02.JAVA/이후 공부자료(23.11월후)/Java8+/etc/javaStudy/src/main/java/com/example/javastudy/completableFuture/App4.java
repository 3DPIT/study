package com.example.javastudy.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        boolean throwError = false;//에러 x
//        boolean throwError = true;//에러 o


        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            if(throwError){
                throw new IllegalArgumentException();
            }

            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex->{
            return "Error!";
        });

        System.out.println(hello.get());

        //handle사용
        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(()->{
            if(throwError){
                throw new IllegalArgumentException();
            }

            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).handle((result,ex)->{
            if(ex!=null){
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });

        System.out.println(hello.get());
    }
}
