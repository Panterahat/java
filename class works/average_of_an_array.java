import java.util.Scanner;

public class average_of_an_array {

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
        int highest = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > highest) {
                highest = arr[i];
            }
        }
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] < lowest) {
                lowest = arr[i];
            }
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + arr[i];
        }
        sum = sum - highest - lowest;
        size = size - 2;
        double average = (double) sum / size;
        System.out.println("the average of the array is " + average);
    }
}
