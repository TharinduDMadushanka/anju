package Encapsulation;

import java.util.Scanner;

public class EncapsulateMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Your NIC Number :");
        String nic = input.nextLine();
        System.out.println("Please Enter Your Name :");
        String name = input.nextLine();
        System.out.println("Please Enter Your Address :");
        String address = input.nextLine();
        System.out.println("Please Enter Your Contact Number :");
        String contact_number = input.nextLine();
        System.out.println("Please Enter Your Salary :");
        double salary = 0.0;
        int age = 0;
        try {
            salary = input.nextDouble();
            System.out.println("Please Enter Your Age :");
            age = input.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input");
        }

        //Initialize user input via constructor
        Person person = new Person(nic,name,address,contact_number,salary,age);

        System.out.println("Your NIC Number Is :"+person.getId());
        System.out.println("Your Name Is :"+person.getName());
        System.out.println("Your Address Is :"+person.getAddress());
        System.out.println("Your Contact Number is "+person.getContact_number());
        System.out.println("Your Salary is :"+person.getSalary());
        System.out.println("Your Age is :"+person.getAge());

    }
}
