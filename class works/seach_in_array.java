import java.util.Scanner;

public class seach_in_array {

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
        System.out.println("enter the element to be searched");
        int target = input.nextInt();
        boolean found = false;
        int i = 0;
        for (; i < size; i++) {
            if (arr[i] == target) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("element found in array at index " + i);
        } else {
            System.out.println("element not found in array");
        }
    }
}
