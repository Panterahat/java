import java.util.Scanner;

public class fibonacci_series {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter desired series numbers: ");
        int number = input.nextInt();
        int first = 0, second = 1;
        System.out.print("Fibonacci Series: " + first + ", " + second);
        for (int i = 3; i <= number; i++) {
            int next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        System.out.println();
        input.close();

    }
}
