package classassignments.question2;


class Triangle {
    int side1;
    int side2;
    int side3;

    Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    void display() {
        int perimeter = side1 + side2 + side3;

        double s = perimeter / 2.0;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        System.out.println("Area = " + area);
        System.out.println("Perimeter = " + perimeter);
    }
}

public class Main {
    public static void main(String[] args) {

        Triangle t = new Triangle(3, 4, 5);

        t.display();
    }
}