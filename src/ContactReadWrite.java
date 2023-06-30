import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactReadWrite {
    private final String directory;
    private final String filename;

    public ContactReadWrite(){
        this.directory = "data";
        this.filename = "contacts.txt";
        try {
            this.checkAndSetFileAndDirector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkAndSetFileAndDirector() throws IOException {
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }
    }

    public void displayAllContacts() throws IOException {
        Path contactsPath = Paths.get(directory, filename);
        List<String> contactList = Files.readAllLines(contactsPath);

        System.out.printf("%3s| %-15s | %12s |%n"," ", "Name", "Number");

        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
    }

    public boolean checkIfContactExists(String fullName) throws IOException {
        boolean nameExits = false;
        Path contactsPath = Paths.get(directory, filename);
        List<String> contactList = Files.readAllLines(contactsPath);

        for(String listString : contactList){
            if(listString.contains(fullName)){
                nameExits = true;
                break;
            }
        }

        return nameExits;
    }

    public void displayContactByName(String name) throws IOException {
        if(name.contains(" ")){
            Path contactsPath = Paths.get(directory, filename);
            List<String> contactList = Files.readAllLines(contactsPath);

            for(String listString : contactList){
                if(listString.contains(name)){
                    System.out.println(listString);
                    break;
                }
            }
        }else {
            System.out.println("Could not find that contact information!");
        }
    }

    public void deleteContactByName(String name) throws IOException {
        if(name.contains(" ")){
            Path contactsPath = Paths.get(directory, filename);
            List<String> contactList = Files.readAllLines(contactsPath);
            List<String> newContactList = new ArrayList<>();

            for(String listString : contactList){
                if(!listString.contains(name)){
                    newContactList.add(listString);
                }
            }
            Files.write(Paths.get(directory, filename), newContactList);
        } else {
            System.out.println("Could not Delete contact information!");
        }
    }

    public void writeNewContactInfo(Person newPerson) throws IOException {
        if(!checkIfContactExists(newPerson.getFullName())){
            Files.write(
                    Paths.get(directory, filename),
                    Arrays.asList(newPerson.getContact()), // list with one item
                    StandardOpenOption.APPEND
            );
        } else {
            System.out.println("Contact already exists!");
        }
    }
}
