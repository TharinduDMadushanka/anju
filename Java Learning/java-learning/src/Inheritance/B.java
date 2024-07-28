package Inheritance;

public class B extends A{

    int x=100;
    static int y=200;
    B(int i){
        //super(a) error
        //super(b); ok
        //super(x) error
        super(y);
    }

}
