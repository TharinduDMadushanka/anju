package Abstraction;

public class MountainBike extends Bike{
    @Override
    public void jump() {
        System.out.println("jumping...!");
    }
    /*when you extend from abstract class we must override abstract method in mountainBike
    * class. Otherwise, you have to make abstract mountain bike class as well*/
}
