import java.util.Scanner;

public class binary_to_decimal_decimal_to_binary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.print("Enter a binary number: ");
            int binary = input.nextInt();
            int decimal = 0, base = 1, rem;
            while (binary > 0) {
                rem = binary % 10; // Get last digit
                decimal = decimal + rem * base;
                base = base * 2; // Move to next power of 2
                binary = binary / 10; // Remove last digit
            }
            System.out.println("Decimal equivalent: " + decimal);

        } else {// Decimal to Binary
            System.out.print("Enter a decimal number: ");
            int decimal = input.nextInt();
            int i = 0;
            int[] binary = new int[32];

            while (decimal > 0) {
                binary[i] = decimal % 2; // store remainder
                decimal = decimal / 2; // update decimal
                i++;
            }

            System.out.print("Binary equivalent: ");
            for (int j = i - 1; j >= 0; j--) { // print in reverse order
                System.out.print(binary[j]);
            }
        }
    }
}

// this one is hard.