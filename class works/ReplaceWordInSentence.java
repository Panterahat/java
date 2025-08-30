import java.util.Scanner;

public class ReplaceWordInSentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the sentence
        System.out.println("Enter a sentence:");
        String sentence = input.nextLine();

        // Word to be replaced
        System.out.println("Enter the word to replace:");
        String oldWord = input.next();

        // New word
        System.out.println("Enter the new word:");
        String newWord = input.next();

        // Replace word
        String updatedSentence = sentence.replaceAll("\\b" + oldWord + "\\b", newWord);

        // Print result
        System.out.println("Updated sentence: " + updatedSentence);

        input.close();
    }
}
