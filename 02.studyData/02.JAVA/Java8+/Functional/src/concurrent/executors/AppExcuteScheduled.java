package concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppExcuteScheduled {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        //executorService.schedule(getRunnnable("Hello"),3, TimeUnit.SECONDS); //3초 있다가 종료
        executorService.scheduleAtFixedRate(getRunnnable("Hello"),1,3, TimeUnit.SECONDS); //반복적으로
    }

    private static Runnable getRunnnable(String message){
        return() -> System.out.println(message+ Thread.currentThread().getName());
    }
}
