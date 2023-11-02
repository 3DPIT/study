package coded_oct.concurrent.basicThread;
public class App {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello");
    }

    static  class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println("Thread: "+ Thread.currentThread().getName());
            super.run();
        }
    }
}

