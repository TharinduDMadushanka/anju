public class Main {
    public static void main(String[] args) {

        long start= System.currentTimeMillis();

        MyClass c1 = new MyClass();
        c1.sayHi();
        c1.sayHello();

        long end= System.currentTimeMillis();
        System.out.println(end-start);

    }
}

class MyClass{

    public void sayHi(){
        for (int i = 0; i <5 ; i++) {
            System.out.println("Hi..!");
        }
    }

    public void sayHello(){
        for (int i = 0; i <5 ; i++) {
            System.out.println("Hello..!");
        }
    }

}