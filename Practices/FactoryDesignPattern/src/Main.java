import Entities.BMW;
import Entities.Ford;
import Entities.ICar;

public class Main {

    public static void foo() throws Exception {
        ICar car=CarFactory.getCar("F");
        car.drive();
    }
    public static void bar() throws Exception {
        ICar car=CarFactory.getCar("H");
        car.drive();

    }
    public static void main(String[] args) throws Exception {
        ICar car=CarFactory.getCar("B");
        car.drive();

        foo();
        bar();


        System.out.println("Done.");
    }
}
