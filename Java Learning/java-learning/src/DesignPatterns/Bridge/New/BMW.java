package DesignPatterns.Bridge.New;

public class BMW extends Engine{
    @Override
    public void assemble() {
        System.out.println("BMW type "+type);
        System.out.println("BMW speed "+speed);
    }
}
