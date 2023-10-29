package coded_oct.CallableFuture0;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000L);
                return "Hello";
            }
        };

        Future<String> submit = executorService.submit(hello);
       System.out.println( submit.isDone());//상태확인
        System.out.println("Started");

        submit.cancel(false);//true 인터럽트 하면서 기다림, false 기다림(이때 get하면 에러 )
        submit.get();//계속 기다림

        System.out.println( submit.isDone());
        System.out.println("End");
        executorService.shutdown();

    }
}
