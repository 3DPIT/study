package com.example.javastudy.callableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () ->{
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () ->{
            Thread.sleep(3000L);
            return "Jave";
        };

        Callable<String>  kmp = () ->{
            Thread.sleep(1000L);
            return "kmp";
        };

        //한번에 출력 - 기댜렸다가 출력하는 방법
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, kmp));

        for(Future<String> f: futures){
            System.out.println(f.get());
        }

        executorService.shutdown();
    }
}
