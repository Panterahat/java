import java.util.Scanner;

public class charecter_identification_using_ascii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);

        if (ch >= 65 && ch <= 90) {
            System.out.println(ch + " is an uppercase letter.");
        } else if (ch >= 97 && ch <= 122) {
            System.out.println(ch + " is a lowercase letter.");
        } else if (ch >= 48 && ch <= 57) {
            System.out.println(ch + " is a digit.");
        } else {
            System.out.println(ch + " is a special character.");
        }

        scanner.close();
    }
}
