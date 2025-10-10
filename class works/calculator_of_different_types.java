class calculator {
    int add2(int a, int b) {
        return a + b;
    }

    int add3(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class calculator_of_different_types {
    public static void main(String[] args) {

        calculator calc = new calculator();
        int sum = calc.add2(2, 3);
        int sum2 = calc.add3(2, 3, 4);
        double sum3 = calc.add(3.4, 5.7);

        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3);

    }

}