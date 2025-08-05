import java.util.Scanner; 
public class product_billing {
    
    // display product details
    public static void show(String name, String id, double price, int quantity) {
        double totalPrice = price * quantity;

        System.out.println("\n--- Product Details ---");
        System.out.println("Product Name  : " + name);
        System.out.println("Product ID    : " + id);
        System.out.println("Unit Price    : " + price);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Total Price   : " + totalPrice);
    }

    public static void main(String[] args)
 {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();


        show(name, id, price, quantity);

        scanner.close();
    }
}
