class employee {
    int id;
    String name;

    int calculate_salary() {
        return 0;
    }

}

class worker extends employee {

    int base_salary;
    int bonus;

    int calculate_salary() {
        return base_salary + bonus;
    }
}

class supervisor extends employee {

    int base_salary;
    int bonus;

    int calculate_salary() {
        return base_salary + bonus + 5000;
    }
}

public class salary_of_different_employee {
    public static void main(String[] args) {

        // create object for worker
        worker emp1 = new worker();

        emp1.id = 101;
        emp1.name = "bruno";
        emp1.base_salary = 20000;
        emp1.bonus = 5000;

        int salary1 = emp1.calculate_salary();
        System.out.println("Salary of worker " + emp1.name + " :" + salary1);

        // create object for supervisor
        supervisor emp2 = new supervisor();
        emp2.id = 102;
        emp2.name = "karina";
        emp2.base_salary = 30000;
        emp2.bonus = 7000;

        int salary2 = emp2.calculate_salary();
        System.out.println("Salary of supervisor: " + emp2.name + " :" + salary2);

    }
}
