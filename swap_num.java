import java.util.Scanner;

public class swap_num {

    static void swap(int num1, int num2) {
        System.out.println( "first number before swap= "+num1);
        System.out.println("second number before swap= "+num2);
        int r=num1;
        num1=num2;
        num2=r;
        System.out.println( "first number after swap= "+num1);
        System.out.println("second number after swap= "+num2);
    }
   
    public static void main(String[] args)
 {Scanner input = new Scanner(System.in);
        int n1, n2;

        //take input
        System.out.print("enter number 1= ");
        n1 = input.nextInt();
        System.out.print("enter number 2= ");
        n2 = input.nextInt();

    swap(n1,n2);
        
    }
}

// this code swaps two numbers using a temporary variable and prints the values before and after the swap.