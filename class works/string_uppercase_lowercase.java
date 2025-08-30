import java.util.Scanner;

public class string_uppercase_lowercase {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = input.nextLine();
        String upperStr = str.toUpperCase();
        String lowerStr = str.toLowerCase();
        System.out.println("Uppercase: " + upperStr);
        System.out.println("Lowercase: " + lowerStr);
    }

}
