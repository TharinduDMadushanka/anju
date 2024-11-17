package thread;

public class Example {
    public static void main(String[] args) {

        SayHi hi = new SayHi();
        SayHello hello = new SayHello();

//        hi.run();
//        hello.run();

        hi.start(); // Start the first thread
        hello.start(); // Start the second thread
    }
}

class SayHi extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi..!");
        }
    }
}

class SayHello extends Thread {

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