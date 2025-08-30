import java.util.Scanner;

public class sum_of_two_arrays {

    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        System.out.println("enter the size of array");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        arr1 = new int[size];
        arr2 = new int[size];
        System.out.println("enter the elements of first array");
        for (int i = 0; i < size; i++) {
            arr1[i] = input.nextInt();
        }
        System.out.println("enter the elements of second array");
        for (int i = 0; i < size; i++) {
            arr2[i] = input.nextInt();
        }
        int[] sum = new int[size];
        for (int i = 0; i < size; i++) {
            sum[i] = arr1[i] + arr2[i];
        }
        System.out.println("the sum of two arrays is ");
        for (int i = 0; i < size; i++) {
            System.out.print(sum[i] + " ");
        }
    }
}
