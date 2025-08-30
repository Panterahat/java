import java.util.Scanner;

public class reverse_an_array {

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
        System.out.println("reversing the array");
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
        System.out.println("the reversed array is ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
