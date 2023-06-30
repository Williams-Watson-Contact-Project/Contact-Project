import util.Input;

public class testPhone {

    public static void main(String[] args) {

        Input i = new Input();
        Phone p1 = new Phone();
        Phone p2 = new Phone("512-512-5123");

        System.out.println(p1.getNumber());
        p1.setNumber("512-512-5123");
        System.out.println(p1.getNumber());

        System.out.println(p2.getNumber());
        p2.setNumber("5123456789");
        System.out.println(p2.getNumber());

    }
}
