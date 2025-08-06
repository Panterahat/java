import java.util.Scanner;

public class arithmetic_operations {
    // funtion to add two numbers
    static int add(int num1, int num2) {
        int r = num1 + num2;
        return r;
    }

    // function to subtract two numbers
    static int subtraction(int num1, int num2) {
        int r = num1 - num2;
        return r;
    }

    // funtion to multiply two numbers
    static int multiplication(int num1, int num2) {
        int r = num1 * num2;
        return r;
    }

    // function to devide two numbers
    static int devide(int num1, int num2) {
        int r = num1 / num2;
        return r;
    }

    // main function
    public static void main(String[] args) {
        // create two integers
        Scanner input = new Scanner(System.in);
        int n1, n2;

        // take input
        System.out.print("enter number 1= ");
        n1 = input.nextInt();
        System.out.print("enter number 2= ");
        n2 = input.nextInt();
        input.close();

        // show output
        System.out.println("addition = " + add(n1, n2));
        System.out.println("subtraction = " + subtraction(n1, n2));
        System.out.println("multiplication = " + multiplication(n1, n2));
        System.out.println("devide = " + devide(n1, n2));
    }
}
