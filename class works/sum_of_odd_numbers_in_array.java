import java.util.Scanner;

public class sum_of_odd_numbers_in_array {
    public static void main(String[] args) {
        int[] arr;
        System.out.println("enter the size of array");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        arr = new int[size];
        System.out.println("enter the elements of array");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] % 2 != 0) {
                sum = sum + arr[i];
            }
        }
        System.out.println("the sum of odd numbers in array is " + sum);
    }
}
