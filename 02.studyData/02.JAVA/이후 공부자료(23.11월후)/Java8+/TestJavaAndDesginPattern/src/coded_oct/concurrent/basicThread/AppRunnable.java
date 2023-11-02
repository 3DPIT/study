package coded_oct.concurrent.basicThread;

public class AppRunnable {
        public static void main(String[] args) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread: "+ Thread.currentThread().getName());
                }
            });

            Thread thread1 = new Thread(()->System.out.println("Thread: "+Thread.currentThread().getName()));

            Thread thread2 = new Thread(()->{
                System.out.println("Thread: "+Thread.currentThread().getName());
            });

            thread.start();

            System.out.println("Hello: "+Thread.currentThread().getName());
        }
}
