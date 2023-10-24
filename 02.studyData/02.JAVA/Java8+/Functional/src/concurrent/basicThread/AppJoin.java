package concurrent.basicThread;

public class AppJoin {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e);
            }
        });
        thread.start();

        System.out.println("Hello: "+ Thread.currentThread().getName());
        thread.join();
        System.out.println(thread+ " is finished");

    }
}
