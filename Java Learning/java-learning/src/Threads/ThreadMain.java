package Threads;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        SayHi hi = new SayHi();
        SayHello hello = new SayHello();

        //Calling start method to run threads. This method came from Java Thread class
        hi.start();
        hello.start();

        //Create objects from Hi and Hello class
        Hi hi1 = new Hi();
        Hello hello1 = new Hello();

        //Created two thread object to call start method
        Thread t1 = new Thread(hi1);
        Thread t2 = new Thread(hello1);

        t1.start();
        t2.start();

        //Create a new thread Using Anonymous Inner class
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Ano Hi");
                }
            }
        });
        t3.start();

        //Create a thread using Lambda Expression
        Thread t4 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda Hi");
            }
        });
        t4.start();

        /*You have to activated deadlock for threads which are needs to process
        all the threads via calling join method*/

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}
