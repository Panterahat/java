import java.util.Scanner;
public class dividables_print {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("enter the number to divide with : ");
        int n = input.nextInt();
        System.out.print("enter the starting range : ");
        int start = input.nextInt();
        System.out.print("enter the ending range : ");
        int end = input.nextInt();
        System.out.println("the numbers between " + start + " and " + end + " that are divisible by " + n + " are : ");
        for(int i=start; i<=end;i++){

            if(i%n == 0){
                System.out.println(i   );
            }            
        }
    }
}
