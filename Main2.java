
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    //type declare
        int id;
        String name;
        double gpa;
        float cgpa;
        char section;

    //input output for id    

        System.out.print("enter id : ");
        id = scanner.nextInt();
        
    //input output for name

        System.out.print("enter name : ");
        scanner.nextLine();
        name = scanner.nextLine();

    //input output for gpa    

        System.out.print("enter gpa : ");
        gpa = scanner.nextFloat();

    //input output for section

        System.out.print("enter section : ");
        section = scanner.next().charAt(0);

    //outputs

        System.out.println("outputs::");
        System.out.println();
        System.out.println(id);
        System.out.println(name);
        System.out.println(gpa);
        System.out.println(section);


    }
}
