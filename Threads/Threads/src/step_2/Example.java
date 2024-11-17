package step_2;

public class Example {
    public static void main(String[] args) {

        SayHi hi = new SayHi();
        SayHello hello = new SayHello();

        Thread t1 = new Thread(hi);
        Thread t2 = new Thread(hello);

        t1.start();
        t2.start();
    }
}

class SayHi extends Greeting implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi..!");
        }
    }
}

class SayHello extends Greeting implements Runnable {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello..!");
        }
    }
}

class Greeting{
    public void greetingType(){
        
    }
}