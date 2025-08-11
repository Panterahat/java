import java.util.Scanner;

public class triangle_check {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three integers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("The integers can form a triangle.");
        } else {
            System.out.println("The integers cannot form a triangle.");
        }

    }
}
