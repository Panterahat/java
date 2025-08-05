import java.util.Scanner;
public class even_odd {
  public static void main(String[] args) {
    System.out.println("Enter a number: ");
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    input.close();
    if (number % 2 == 0) {
      System.out.println("The number " + number + " is even.");
    } 
    else {
      System.out.println("The number " + number + " is odd.");
    }
  }  
}


// This program checks if a number is even or odd