package Inheritance;

public class A {
    int a = 10;
    static int b = 20;

    A() {
        //  this(a); // error
        /*You can't use instance variable with this keyword
         * because at this time this object is not initialized*/
        this(b);
        /*You can use static variables with "this" keyword */
    }

    A(int i) {
        System.out.println("A(int i)");
    }

}
