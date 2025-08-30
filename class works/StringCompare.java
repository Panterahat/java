import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        // Method 1: Using equals() -> checks content
        if (str1.equals(str2)) {
            System.out.println("Both strings are exactly the same.");
        } else {
            System.out.println("Strings are not the same.");
        }

        // Method 2: Using equalsIgnoreCase() -> ignores case
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("Both strings are the same (ignoring case).");
        } else {
            System.out.println("Strings are different (ignoring case).");
        }

        // Method 3: Using compareTo() -> returns 0 if equal
        int result = str1.compareTo(str2);
        if (result == 0) {
            System.out.println("Both strings are equal (using compareTo).");
        } else if (result < 0) {
            System.out.println("First string comes before second string.");
        } else {
            System.out.println("First string comes after second string.");
        }

        sc.close();
    }
}
