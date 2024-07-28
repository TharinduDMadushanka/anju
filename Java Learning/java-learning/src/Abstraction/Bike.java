package Abstraction;

abstract public class Bike {
    abstract public void jump();
    //abstract public static void run();
    /*we can't use abstract key word with static methods*/
    public void handle(){
        System.out.println("Handling...!");
    }
}
