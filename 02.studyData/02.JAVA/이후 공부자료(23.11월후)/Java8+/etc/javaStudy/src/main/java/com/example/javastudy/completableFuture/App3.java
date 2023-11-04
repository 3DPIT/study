package com.example.javastudy.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //연관이 없는거 연결해서 쓸때
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());

            return "Hello";
        });


        CompletableFuture<String> world = CompletableFuture.supplyAsync(()->{
            System.out.println("World" + Thread.currentThread().getName());

            return "World";
        });

        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future.get());

        CompletableFuture<Void> future1 = CompletableFuture.allOf(hello, world)
                .thenAccept(System.out::println);


        System.out.println(future1.get());

        //위에 Void타입 나오는데 제대로 하면
        //결과값 컬렉션 만들어서 가지기
        List<CompletableFuture> futures = Arrays.asList(hello, world);
        CompletableFuture<Void> future2 = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));

        System.out.println(future2);

        //추가 방식
        List<CompletableFuture<String>> futures1 = Arrays.asList(hello, world);

        CompletableFuture[] futureArray = futures1.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futureArray)
                        .thenApply(v->{
                            return futures1.stream()
//                                    .map(f -> f.join())
                                    .map(CompletableFuture::join)
                                    .collect(Collectors.toList());
                        });

        results.get().forEach(System.out::println);

        //아무거나 하나빨리 끝나는 거
        CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello, world).thenAccept((s) -> {
            System.out.println(s);
        });

        future3.get();
    }
}
