import java.util.Scanner;

public class sum_of_prime_numbers_in_array {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

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
            if (isPrime(arr[i])) {
                sum = sum + arr[i];
            }
        }
        System.out.println("the sum of prime numbers in array is " + sum);
    }

}
