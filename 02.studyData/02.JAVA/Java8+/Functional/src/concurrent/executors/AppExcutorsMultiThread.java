package concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExcutorsMultiThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnnable("Hello"));
        executorService.submit(getRunnnable("3dpit"));
        executorService.submit(getRunnnable("The"));
        executorService.submit(getRunnnable("Java"));
        executorService.submit(getRunnnable("Thread"));

        executorService.shutdown();
    }

    private static Runnable getRunnnable(String message){
        return() -> System.out.println(message+ Thread.currentThread().getName());
    }
}