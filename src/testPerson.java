public class testPerson {
    public static void main(String[] args) {

      Person person1 = new Person("barney","America", "723-435-2333");
        System.out.println("person1.getContact() = " + person1.getContact());
        person1.setNumber("324-544-2345");
        System.out.println("person1.getContact() = " + person1.getContact());
    }
}
