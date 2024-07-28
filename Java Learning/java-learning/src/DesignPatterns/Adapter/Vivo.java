package DesignPatterns.Adapter;

public class Vivo implements Charger {
    @Override
    public void chargingPort(Vivo vivo) {
        System.out.println("Vivo phone is charging");
    }
}
