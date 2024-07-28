package DesignPatterns.Composite.correct;

public class Phone extends Product{

    public Phone(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculate() {
        return getPrice();
    }
}
