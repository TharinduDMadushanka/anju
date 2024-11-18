package step04;

public class Example {
    public static void main(String[] args) throws InterruptedException {

        Increment increment = new Increment();

//        for (int i = 0; i < 2000; i++) {
//            increment.incrementValue();
//        }

//        System.out.println(increment.i); //2000

        Thread t1 = new Thread(()-> {

                for (int i = 0; i < 1000; i++) {
                    increment.incrementValue();
                }

        });

        Thread t2 = new Thread(()-> {

                for (int i = 0; i < 1000; i++) {
                    increment.incrementValue();
                }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("I value "+ increment.i);
    }
}

class Increment{

    int i;

//    synchronized public void incrementValue(){
//        i++;
//    }

    public void incrementValue(){

        synchronized (this){
            i++;
        }
    }
}
