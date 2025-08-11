import java.util.Scanner;

public class digit_number_of_an_integer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        int count = 0;
        for (int i = number; i != 0; i = i / 10) {
            count++;
        }
        System.out.println("The number of digits in " + number + " is: " + count);
        input.close();
    }
}