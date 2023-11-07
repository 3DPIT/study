package com.example.javastudy.coded_oct.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExcutors {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread "+ Thread.currentThread().getName());
            }
        });

        executorService.shutdown();//Graceful Shutdown - 우아하게 명예롭게 죽는거
        //executorService.shutdownNow();
    }
}
