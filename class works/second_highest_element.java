import java.util.Scanner;

public class second_highest_element {

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
        int second_highest = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > highest) {
                second_highest = highest;
                highest = arr[i];
            } else if (arr[i] > second_highest && arr[i] != highest) {
                second_highest = arr[i];
            }
        }
        if (second_highest == Integer.MIN_VALUE) {
            System.out.println("there is no second highest element in the array");
        } else {
            System.out.println("the second highest element in the array is " + second_highest);
        }
    }
}