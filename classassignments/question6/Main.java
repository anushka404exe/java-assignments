package classassignments.question6;


import java.util.Scanner;

class Employee {
    double salary;
    int hours;

    void getInfo(double salary, int hours) {
        this.salary = salary;
        this.hours = hours;
    }

    void addSal() {
        if (salary < 500) {
            salary += 10;
        }
    }

    void addWork() {
        if (hours > 6) {
            salary += 5;
        }
    }

    void displaySalary() {
        System.out.println("Final Salary: $" + salary);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter number of hours of work per day: ");
        int hours = sc.nextInt();

        Employee e = new Employee();

        e.getInfo(salary, hours);
        e.addSal();
        e.addWork();
        e.displaySalary();

        sc.close();
    }
}