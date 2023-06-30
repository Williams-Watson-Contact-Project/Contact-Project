import util.Input;

public class testPhone {

    public static void main(String[] args) {

        Phone p1 = new Phone();
        Phone p2 = new Phone("5125125123");
        Phone p3 = new Phone("512-512-51");

        System.out.println(p1.getNumber());
        p1.setNumber("5125123");
        System.out.println(p1.getNumber());

        System.out.println(p2.getNumber());
        p2.setNumber("5123456789");
        System.out.println(p2.getNumber());

        System.out.println("p3.getNumber() = " + p3.getNumber());
    }
}
