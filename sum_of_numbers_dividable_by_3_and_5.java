import java.util.Scanner;

public class sum_of_numbers_dividable_by_3_and_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter starting point: ");
        int start = input.nextInt();
        int sum = 0;
        System.out.print("Enter ending point: ");
        int end = input.nextInt();
        for (int i = start; i <= end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sum += i; // Add to sum if divisible by 3 or 5
            }

        }
        System.out.println("Sum of numbers divisible by 3 or 5 between " + start + " and " + end + " is: " + sum);
    }
}
