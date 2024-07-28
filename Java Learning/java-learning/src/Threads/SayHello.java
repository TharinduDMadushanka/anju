package Threads;

public class SayHello extends Thread{

    //override run class
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
    }

}
