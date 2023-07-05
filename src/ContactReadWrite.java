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

    /**
     * Default constructor for Contact Read and Write Class
     */
    public ContactReadWrite(){
        this.directory = "data";
        this.filename = "contacts.txt";
        try {
            this.checkAndSetFileAndDirector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if File and its path exists.
     * If they do not exist, create them.
     * @throws IOException
     */
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

    /**
     * Grab all contacts inside the contacts.txt file
     * and display them to the console.
     * @throws IOException
     */
    public void displayAllContacts() throws IOException {
        Path contactsPath = Paths.get(directory, filename);
        List<String> contactList = Files.readAllLines(contactsPath);

        System.out.printf("%3s| %-15s | %12s |%n"," ", "Name", "Number");

        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
    }

    /**
     * Returns true or false, depending on if a set name is found inside
     * the contacts.txt file.
     * @param fullName
     * @return
     * @throws IOException
     */
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

    /**
     * Display a single contact if it is contained
     * inside the contacts.txt file
     * @param name
     * @throws IOException
     */
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

    /**
     * Removes a contact from the contacts.txt file if that contact name
     * exists. Does this by created a new contactList and only adding
     * the contacts that do not match the name specified by user.
     * @param name
     * @throws IOException
     */
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
            Files.write(contactsPath, newContactList);
        } else {
            System.out.println("Could not Delete contact information!");
        }
    }

    /**
     * Adds a new contact to the existing contacts.txt file, so long
     * as that contact name does not exist already.
     * @param newContact
     * @throws IOException
     */
    public void writeNewContactInfo(Contact newContact) throws IOException {
        if(!checkIfContactExists(newContact.getFullName())){
            Files.write(
                    Paths.get(directory, filename),
                    Arrays.asList(newContact.getContact()), // list with one item
                    StandardOpenOption.APPEND
            );
        } else {
            System.out.println("Contact already exists!");
        }
    }
}
