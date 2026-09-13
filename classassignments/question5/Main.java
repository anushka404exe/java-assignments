package classassignments.question5;


class Employee {
    String name;
    int yearOfJoining;
    double salary;
    String address;

    Employee(String name, int yearOfJoining, double salary, String address) {
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.address = address;
    }

    void display() {
        System.out.printf("%-15s %-15d %-15.2f %-25s%n",
                name, yearOfJoining, salary, address);
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Robert", 1994, 50000, "64C- WallStreet");
        Employee e2 = new Employee("Sam", 2000, 60000, "68D- WallStreet");
        Employee e3 = new Employee("John", 1999, 55000, "26B- WallStreet");

        System.out.printf("%-15s %-15s %-15s %-25s%n",
                "Name", "Year of Joining", "Salary", "Address");

        e1.display();
        e2.display();
        e3.display();
    }
}
