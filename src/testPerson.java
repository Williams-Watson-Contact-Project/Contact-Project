public class testPerson {
    public static void main(String[] args) {

      Contact contact1 = new Contact("barney","America", "723-435-2333");
        System.out.println("contact1.getContact() = " + contact1.getContact());
        contact1.setNumber("324-544-2345");
        System.out.println("contact1.getContact() = " + contact1.getContact());
    }
}
