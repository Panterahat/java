import java.util.Scanner;

public class swap_num {
   
    public static void main(String[] args)
 {Scanner input = new Scanner(System.in);
        int n1, n2;

        //take input
        System.out.print("enter number 1= ");
        n1 = input.nextInt();
        System.out.print("enter number 2= ");
        n2 = input.nextInt();
        int r=n1;
        n1=n2;
        n2=r;
        System.out.println( "first number after swap= "+n1);
        System.out.println("second number after swap= "+n2);
    }
}

// this code swaps two numbers using a temporary variable and prints the values before and after the swap.