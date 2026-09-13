package question2;
1


import java.io.*;
import java.util.*;

abstract class Employee implements Serializable {
    protected int id;
    protected String name;
    protected double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public abstract void display();
}

class Manager extends Employee {
    private String department;

    public Manager(int id, String name, double salary, String department) {
        super(id, name, salary);
        this.department = department;
    }

    @Override
    public void display() {
        System.out.println("Manager | ID: " + id +
                " | Name: " + name +
                " | Salary: " + salary +
                " | Department: " + department);
    }
}

class Engineer extends Employee {
    private String technology;

    public Engineer(int id, String name, double salary, String technology) {
        super(id, name, salary);
        this.technology = technology;
    }

    @Override
    public void display() {
        System.out.println("Engineer | ID: " + id +
                " | Name: " + name +
                " | Salary: " + salary +
                " | Technology: " + technology);
    }
}

class SalesPerson extends Employee {
    private double salesTarget;

    public SalesPerson(int id, String name, double salary, double salesTarget) {
        super(id, name, salary);
        this.salesTarget = salesTarget;
    }

    @Override
    public void display() {
        System.out.println("Sales Person | ID: " + id +
                " | Name: " + name +
                " | Salary: " + salary +
                " | Sales Target: " + salesTarget);
    }
}

class EmployeeNode {
    Employee data;
    EmployeeNode prev;
    EmployeeNode next;

    public EmployeeNode(Employee data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class EmployeeList implements Serializable {

    private EmployeeNode head;
    private EmployeeNode tail;
    private EmployeeNode current;

    public void add(Employee employee) {

        EmployeeNode newNode = new EmployeeNode(employee);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void displayAll() {

        if (head == null) {
            System.out.println("No employees available.");
            return;
        }

        EmployeeNode temp = head;

        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }

    public void displayFirst() {

        if (head == null) {
            System.out.println("No employees available.");
            return;
        }

        current = head;
        current.data.display();
    }

    public void displayNext() {

        if (current == null) {
            System.out.println("No employees available.");
            return;
        }

        if (current.next == null) {
            System.out.println("Already at the last employee.");
            return;
        }

        current = current.next;
        current.data.display();
    }

    public void displayPrevious() {

        if (current == null) {
            System.out.println("No employees available.");
            return;
        }

        if (current.prev == null) {
            System.out.println("Already at the first employee.");
            return;
        }

        current = current.prev;
        current.data.display();
    }

    public void displayLast() {

        if (tail == null) {
            System.out.println("No employees available.");
            return;
        }

        current = tail;
        current.data.display();
    }

    public void sortManagers() {

        ArrayList<Employee> list = getEmployeesOfType(Manager.class);

        if (list.isEmpty()) {
            System.out.println("No Managers found.");
            return;
        }

        for (Employee e : list) {
            e.display();
        }
    }

    public void sortEngineers() {

        ArrayList<Employee> list = getEmployeesOfType(Engineer.class);

        if (list.isEmpty()) {
            System.out.println("No Engineers found.");
            return;
        }

        for (Employee e : list) {
            e.display();
        }
    }

    public void sortSalesPersons() {

        ArrayList<Employee> list = getEmployeesOfType(SalesPerson.class);

        if (list.isEmpty()) {
            System.out.println("No Sales Persons found.");
            return;
        }

        for (Employee e : list) {
            e.display();
        }
    }

    private ArrayList<Employee> getEmployeesOfType(Class<?> type) {

        ArrayList<Employee> result = new ArrayList<>();

        EmployeeNode temp = head;

        while (temp != null) {

            if (type.isInstance(temp.data)) {
                result.add(temp.data);
            }

            temp = temp.next;
        }

        return result;
    }

    public void sortAscending() {

        ArrayList<Employee> list = getAllEmployees();

        list.sort(Comparator.comparing(Employee::getName));

        for (Employee e : list) {
            e.display();
        }
    }

    public void sortDescending() {

        ArrayList<Employee> list = getAllEmployees();

        list.sort(Comparator.comparing(Employee::getName).reversed());

        for (Employee e : list) {
            e.display();
        }
    }

    private ArrayList<Employee> getAllEmployees() {

        ArrayList<Employee> list = new ArrayList<>();

        EmployeeNode temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        return list;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    static void addEmployeeMenu(EmployeeList employees) {

        int choice;

        do {

            System.out.println("\n----- ADD EMPLOYEE -----");
            System.out.println("1. Manager");
            System.out.println("2. Engineer");
            System.out.println("3. Sales Person");
            System.out.println("4. Exit to Main Menu");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String mname = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double msalary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    employees.add(
                            new Manager(mid, mname, msalary, department)
                    );

                    System.out.println("Manager added successfully.");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String ename = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double esalary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Technology: ");
                    String technology = sc.nextLine();

                    employees.add(
                            new Engineer(eid, ename, esalary, technology)
                    );

                    System.out.println("Engineer added successfully.");
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double ssalary = sc.nextDouble();

                    System.out.print("Enter Sales Target: ");
                    double target = sc.nextDouble();
                    sc.nextLine();

                    employees.add(
                            new SalesPerson(sid, sname, ssalary, target)
                    );

                    System.out.println("Sales Person added successfully.");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    static void displayMenu(EmployeeList employees) {

        int choice;

        do {

            System.out.println("\n----- DISPLAY -----");
            System.out.println("1. All Employees");
            System.out.println("2. First Employee");
            System.out.println("3. Next Employee");
            System.out.println("4. Previous Employee");
            System.out.println("5. Last Employee");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    employees.displayAll();
                    break;

                case 2:
                    employees.displayFirst();
                    break;

                case 3:
                    employees.displayNext();
                    break;

                case 4:
                    employees.displayPrevious();
                    break;

                case 5:
                    employees.displayLast();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    static void sortMenu(EmployeeList employees) {

        int choice;

        do {

            System.out.println("\n----- SORT -----");
            System.out.println("1. All Managers");
            System.out.println("2. All Engineers");
            System.out.println("3. All Sales Person");
            System.out.println("4. All Employees Alphabetic Ascending");
            System.out.println("5. All Employees Alphabetic Descending");
            System.out.println("6. Exit to Main Menu");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    employees.sortManagers();
                    break;

                case 2:
                    employees.sortEngineers();
                    break;

                case 3:
                    employees.sortSalesPersons();
                    break;

                case 4:
                    employees.sortAscending();
                    break;

                case 5:
                    employees.sortDescending();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    static void saveToFile(EmployeeList employees) {

        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("employees.dat")
                    );

            out.writeObject(employees);
            out.close();

            System.out.println("Employees saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving file.");
        }
    }

    static EmployeeList loadFromFile() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("employees.dat")
                    );

            EmployeeList employees =
                    (EmployeeList) in.readObject();

            in.close();

            System.out.println("Employees loaded successfully.");

            return employees;

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("No saved employee data found.");
            return new EmployeeList();
        }
    }

    public static void main(String[] args) {

        EmployeeList employees = new EmployeeList();

        int choice;

        do {

            System.out.println("\n========== EMPLOYEE MANAGEMENT ==========");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display");
            System.out.println("3. Sort");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployeeMenu(employees);
                    break;

                case 2:
                    displayMenu(employees);
                    break;

                case 3:
                    sortMenu(employees);
                    break;

                case 4:
                    saveToFile(employees);
                    break;

                case 5:
                    employees = loadFromFile();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
