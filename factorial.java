import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i; // Multiply to get factorial
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
        input.close();

    }
}
