package Threads;

public class SayHi extends Thread{

    //Override run class
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
        }
    }
}
