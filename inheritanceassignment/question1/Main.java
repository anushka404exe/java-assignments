package inheritanceassignment.question1;



class Parent {

    void parentMethod() {
        System.out.println("This is parent class");
    }
}

class Child extends Parent {

    void childMethod() {
        System.out.println("This is child class");
    }
}

public class Main {
    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = new Child();

        // 1. Parent method by parent object
        p.parentMethod();

        // 2. Child method by child object
        c.childMethod();

        // 3. Parent method by child object
        c.parentMethod();
    }
}