import java.util.Scanner;

class Date {
    private int day;
    private int month;
    private int year;

    Date() {
        day = 1;
        month = 1;
        year = 2000;
    }

    boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;

            default:
                return 0;
        }
    }

    boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12)
            return false;

        return day >= 1 && day <= daysInMonth(month, year);
    }

    void setDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
            System.out.println("Date set successfully.");
        } else {
            System.out.println("Invalid date.");
        }
    }

    void addDays(int days) {
        if (days < 0) {
            System.out.println("Days cannot be negative.");
            return;
        }

        while (days > 0) {
            int remainingDays = daysInMonth(month, year) - day;

            if (days <= remainingDays) {
                day += days;
                days = 0;
            } else {
                days -= (remainingDays + 1);
                day = 1;

                if (month == 12) {
                    month = 1;
                    year++;
                } else {
                    month++;
                }
            }
        }
    }

    void addMonths(int months) {
        if (months < 0) {
            System.out.println("Months cannot be negative.");
            return;
        }

        for (int i = 0; i < months; i++) {
            month++;

            if (month > 12) {
                month = 1;
                year++;
            }

            int maxDays = daysInMonth(month, year);

            if (day > maxDays) {
                day = maxDays;
            }
        }
    }

    void addYears(int years) {
        if (years < 0) {
            System.out.println("Years cannot be negative.");
            return;
        }

        year += years;

        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
    }

    void display() {
        System.out.printf("%02d/%02d/%04d%n", day, month, year);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Date date = new Date();

        int choice;

        do {
            System.out.println("\n----- DATE MENU -----");
            System.out.println("1. Set Date");
            System.out.println("2. Add Days");
            System.out.println("3. Add Months");
            System.out.println("4. Add Years");
            System.out.println("5. Display");
            System.out.println("6. Compare Dates");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter day: ");
                    int day = sc.nextInt();

                    System.out.print("Enter month: ");
                    int month = sc.nextInt();

                    System.out.print("Enter year: ");
                    int year = sc.nextInt();

                    date.setDate(day, month, year);
                    break;

                case 2:
                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();

                    date.addDays(days);
                    break;

                case 3:
                    System.out.print("Enter number of months: ");
                    int months = sc.nextInt();

                    date.addMonths(months);
                    break;

                case 4:
                    System.out.print("Enter number of years: ");
                    int years = sc.nextInt();

                    date.addYears(years);
                    break;

                case 5:
                    date.display();
                    break;

                case 6:
                    System.out.println("Compare dates - Not implemented yet.");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}