import java.util.Scanner;

public class charecter_identification {
    public static void main(String[] args) {
        char ch;
        System.out.print("Enter a character: ");
        Scanner scanner = new Scanner(System.in);
        ch = scanner.next().charAt(0);
        if (Character.isLetter(ch)) {
            if (Character.isUpperCase(ch)) {
                System.out.println(ch + " is an uppercase letter.");
            } else {
                System.out.println(ch + " is a lowercase letter.");
            }
        } else if (Character.isDigit(ch)) {
            System.out.println(ch + " is a digit.");
        } else {
            System.out.println(ch + " is a special character.");
        }

    }

}
