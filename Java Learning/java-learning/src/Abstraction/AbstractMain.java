package Abstraction;

public class AbstractMain {
    public static void main(String[] args) {

        // Bike bike = new Bike(); error
        /*We can't create an object using abstract class. Abstract class also have constructor,
        but we can't initialize object using that constructor */

        Bike bike = new MountainBike();
        /*We can hold mountainBike class using Abstract class bike(super) references */
    }
}
