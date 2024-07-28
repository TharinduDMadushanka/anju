package DesignPatterns.Composite.correct;

public class Service {

    private Box box;

    public Service() {

    }

    public void totalOrder(Box ...boxes){
        this.box= new CompositeBox(boxes);
    }

    public double calculateTotalOrderCost(){
        return box.calculate();
    }

}
