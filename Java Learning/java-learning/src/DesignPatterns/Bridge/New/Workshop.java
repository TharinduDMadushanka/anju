package DesignPatterns.Bridge.New;

abstract public class Workshop {

    protected Engine engine;

    abstract  void setType();
    abstract  void setSpeed();

    public Workshop(Engine engine) {
        this.engine = engine;
    }

    public void process(){
        setType();
        setSpeed();
        engine.assemble();
        System.out.println("Processing..!");
    }

}
