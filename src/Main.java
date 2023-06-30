import java.io.IOException;

public class Main {

    private static ContactReadWrite contactRW = new ContactReadWrite();

    public static void main(String[] args) {
        try {
            contactRW.displayAllContacts();
        } catch (IOException e) {
            System.out.println("Could not get contact information to be displayed.");
        }

        for(int i = 0; i < 5; i++){
            Person p = new Person("John" + i*5, "Doe", "512-512-5123");
            try {
                contactRW.writeNewContactInfo(p);
            } catch (IOException e) {
                System.out.printf("Could not write person %s to contact.txt", p.getFullName());
            }
        }

        try {
            contactRW.displayAllContacts();
        } catch (IOException e) {
            System.out.println("Could not get contact information to be displayed.");
        }

        try {
            contactRW.displayContactByName("John");
        } catch (IOException e) {
            System.out.println("Contact does not exist");
        }

        try {
            contactRW.displayContactByName("John15 Doe");
        } catch (IOException e) {
            System.out.println("Contact does not exist");
        }

        try {
            contactRW.deleteContactByName("John20 Doe");
        } catch (IOException e) {
            System.out.println("Could not delete contact");
        }

    }
}
