package step03;

public class Example {
    public static void main(String[] args) {

        // anonymous inner class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Hi..!");
                }
            }
        });

        // lambda expressions
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello..!");
            }
        });

        t1.start();
        t2.start();

    }
}

