package DesignPatterns.Composite.correct;

public class Bottle extends Product{

    public Bottle(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculate() {
        return getPrice();
    }
}
