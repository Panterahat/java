import java.util.Scanner;

public class find_largest_among_three {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter three numbers : ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        input.close();
        int largest;
        largest = num1;
        if(num2 > largest) {
            largest = num2;
        }
        if(num3 > largest) {
            largest = num3;
        }
        System.out.println("largest number is: " + largest);
    
}
}

// This code finds the largest among three numbers entered by the user.