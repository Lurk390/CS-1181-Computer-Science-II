package Inheritance;

class Driver {

    public static void main(String[] args) {

        ClassA x1 = new ClassA();
        ClassA x2 = new ClassB();
        ClassB x3 = new ClassB();
        //ClassB x4 = new ClassA();

        // all these will work
        x1.methodA();
        x2.methodA();
        x3.methodA();

        x1.methodB(); // ClassA methodB
        x2.methodB(); // ClassB methodB
        x3.methodB(); // ClassB methodB

        //x1.methodC();
        //x2.methodC();
        x3.methodC();

        //String s = x1.toString();
        
    }
}
