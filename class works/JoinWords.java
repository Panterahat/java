import java.util.Scanner;

public class JoinWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of words
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline

        // StringBuilder for efficient concatenation
        StringBuilder sentence = new StringBuilder();

        // Taking words and joining them
        for (int i = 0; i < n; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            String word = sc.nextLine();

            // Add space between words (but not before the first word)
            if (i > 0) {
                sentence.append(" ");
            }
            sentence.append(word);
        }

        // Display the joined string
        System.out.println("Joined String: " + sentence.toString());

        sc.close();
    }
}
