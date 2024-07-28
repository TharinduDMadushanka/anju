package DesignPatterns.Composite.correct;

public class Bike extends Product{

    public Bike(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculate() {
        return getPrice();
    }
}
