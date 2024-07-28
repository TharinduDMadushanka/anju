package DesignPatterns.Bridge.New;

public class Initializer {
    public static void main(String[] args) {

        USAWorkshop usaWorkshop= new USAWorkshop(new BMW());
        usaWorkshop.process();

        System.out.println("===================================");

        JapanWorkshop japanWorkshop = new JapanWorkshop(new Audi());
        japanWorkshop.process();

    }
}
