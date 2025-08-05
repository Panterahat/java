import java.util.Scanner;

public class multiplication_table {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter a number to show its multiplication table: ");
        int num = input.nextInt();
        System.out.print("ENTER NUMBER OF THE MULTIPLICATION LIMIT:");
        int limit = input.nextInt();
        for(int i=1;i<limit+1;i++){

            System.out.println(num + "*"+ i +"="+num*i);
        }
    }}