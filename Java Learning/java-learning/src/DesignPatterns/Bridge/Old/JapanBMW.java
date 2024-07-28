package DesignPatterns.Bridge.Old;

public class JapanBMW extends Engine{
    @Override
    public void assemble() {
        System.out.println("Japan BMW type "+type);
        System.out.println("Japan BMW speed "+speed);
    }
}
