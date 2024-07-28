package Recursion;

import java.util.Scanner;

public class RecursionMain {

    public static int sum(int number){
        if(number>0){
            return number+sum(number-1);
        }else {
            return 0;
        }
    }

    public static long getFactorial(long number){
        if(number<=1){
            return 1;
        }else {
            return number*getFactorial(number-1);
        }
    }

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        System.out.println("Please Enter the number : ");
        int number = input.nextInt();

        System.out.println("Factorial value is : "+getFactorial(number));

        /*int total= sum(10);
        System.out.println("Results is :"+total);*/


    }
}
