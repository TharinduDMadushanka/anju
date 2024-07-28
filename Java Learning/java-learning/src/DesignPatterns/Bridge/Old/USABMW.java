package DesignPatterns.Bridge.Old;

public class USABMW extends Engine{
    @Override
    public void assemble() {
        System.out.println("USA BMW Type "+type);
        System.out.println("USA BMW speed "+speed);
    }
}
