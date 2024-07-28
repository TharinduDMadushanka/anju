package Threads;

public class Hi implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
        }
    }
}
