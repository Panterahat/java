import java.util.Scanner;

public class ExtractSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Input starting and ending position
        System.out.print("Enter starting index (0-based): ");
        int start = sc.nextInt();

        System.out.print("Enter ending index: ");
        int end = sc.nextInt();

        // Validate indexes
        if (start >= 0 && end <= str.length() && start < end) {
            String subStr = str.substring(start, end);
            System.out.println("Extracted part: " + subStr);
        } else {
            System.out.println("Invalid indexes!");
        }

        sc.close();
    }
}
