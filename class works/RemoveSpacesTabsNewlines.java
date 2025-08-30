import java.util.Scanner;

public class RemoveSpacesTabsNewlines {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input string
        System.out.println("Enter a string (with spaces, tabs, and newlines):");
        String str = input.nextLine();

        // Remove spaces, tabs (\t), and newlines (\n, \r)
        String result = str.replaceAll("[ \t\n\r]", "");

        // Print result
        System.out.println("String after removing spaces, tabs, and newlines:");
        System.out.println(result);

        input.close();
    }
}
