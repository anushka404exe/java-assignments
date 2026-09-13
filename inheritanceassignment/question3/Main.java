package inheritanceassignment.question3;


class Rectangle {

    int length;
    int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void printArea() {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    void printPerimeter() {
        System.out.println("Perimeter of Rectangle: " + (2 * (length + breadth)));
    }
}

class Square extends Rectangle {

    Square(int side) {
        super(side, side);
    }
}

public class Main {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(10, 5);

        System.out.println("Rectangle:");
        r.printArea();
        r.printPerimeter();

        Square s = new Square(5);

        System.out.println("\nSquare:");
        s.printArea();
        s.printPerimeter();
    }
}