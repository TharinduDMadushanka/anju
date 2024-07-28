package DesignPatterns.Bridge.Old;

public class USAAudi extends Engine{
    @Override
    public void assemble() {
        System.out.println("USA Audi type "+type);
        System.out.println("USA Audi speed "+speed);
    }
}
