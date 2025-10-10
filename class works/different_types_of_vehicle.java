class vehicle {
    void speed_up() {
    };

}

class car extends vehicle {
    int currentSpeed;

    car(int a) {
        currentSpeed = a;
    }

    void speed_up() {
        System.out.println("car is speeding up 0 ,,," + currentSpeed + ",,," + 2 * currentSpeed + ",,,"
                + 3 * currentSpeed + ",,,");
    }
}

class bicycle extends vehicle {
    int currentSpeed;

    bicycle(int a) {
        currentSpeed = a;
    }

    void speed_up() {
        System.out.println("bicycle is speeding up 0 ,,," + currentSpeed + ",,," + 2 * currentSpeed + ",,,"
                + 3 * currentSpeed + ",,,");
    }
}

public class different_types_of_vehicle {
    public static void main(String[] arge) {
        vehicle v1 = new car(5);
        vehicle v2 = new bicycle(10);
        v1.speed_up();
        v2.speed_up();

    }
}
