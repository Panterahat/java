class shape {
    int area_square(int side) {
        return side * side;
    }

    int area_rectangle(int length, int width) {
        return length * width;
    }

    double area_circle(double radius) {
        return 3.14 * radius * radius;
    }

}

public class shape_of_different_types {
    public static void main(String[] args) {
        shape square = new shape();
        int square_area = square.area_square(4);
        shape rectangle = new shape();
        int rectangle_area = rectangle.area_rectangle(4, 5);
        shape circle = new shape();
        double circle_area = circle.area_circle(7.5);
        System.out.println("Area of square: " + square_area);
        System.out.println("Area of rectangle: " + rectangle_area);
        System.out.println("Area of circle: " + circle_area);
    }

}