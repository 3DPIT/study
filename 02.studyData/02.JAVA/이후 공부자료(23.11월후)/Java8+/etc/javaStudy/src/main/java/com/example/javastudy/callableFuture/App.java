package com.example.javastudy.callableFuture;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println(submit.isDone()); //끝났으면 true, 안끝났으면 false
        System.out.println("started!");
        submit.get();
        //submit.cancel(true);//true인 경우 현재 진행중인 작업을 리턴하면서 인터럽트하면서 종료
        //false의 경우 기다리는것 ,일단 cancel하면 get 못씀
        System.out.println(submit.isDone()); //끝났으면 true, 안끝났으면 false
        System.out.println("End!!");
        executorService.shutdown();
    }
}
