import util.Input;

import java.io.IOException;

public class Main {

    private static final ContactReadWrite contactRW = new ContactReadWrite();
    private static final Input input= new Input();

    /**
     * Asking user to insert number 1-5.
     * If the inserted number is 5, app will exit.
     */
    private static void runApp(){

        int userInput=0;

        do{
            userMenu();
            userInput=input.getInt(1,5);
            if(userInput==1){
                displayAll();
            } else if(userInput==2){
                addContact();
            } else if (userInput==3){
                searchContact();
            } else if (userInput==4){
                deleteContact();
            }

        } while(userInput!=5);

    }


    /**
     * show the menu options.
     */
    private static void userMenu(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a new contact by name.");
        System.out.println("4. Delete existing contact.");
        System.out.println("5. Exit.");

    }

    /**
     * Using ContactRW to read all contacts from file
     * and display them to console. Display message
     * if an IOException occurs.
     */
    private static void displayAll(){
        try {
            contactRW.displayAllContacts();
        } catch (IOException e) {
            System.err.println("Contact unavailable");
        }
    }

    /**
     * Using Contact RW to add Contact from file and
     * if and IOException occurs an error message
     * is printed.
     */
    private static void addContact(){
        try {
            contactRW.writeNewContactInfo(createNewContact());
        } catch (IOException e) {
            System.err.println("Unable to add contact to file.");
        }
    }
    /**
     * Using Contact RW to search for Contact from file and
     * if and IOException occurs an error message
     * is printed.
     */
    private static void searchContact(){
        try {
            contactRW.displayContactByName(askFullName());
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

    }
    /**
     * Using Contact RW to search and delete for Contact
     * from file and if and IOException occurs
     * an error message
     * is printed.
     */
    private static void deleteContact(){
        try {
            contactRW.deleteContactByName(askFullName());
        } catch (IOException e) {
            System.err.println("Unable to delete. File error.");
        }
    }

    /**
     * asking for input of name
     * and returning the full name
     * @return
     */
    private static String askFullName(){
        System.out.println("Please enter contacts first name.");
        String fName= input.getString();
        System.out.println("Please enter contacts last name.");
        String lName= input.getString();
        return String.format("%s %s",fName,lName);
    }

    /**
     * asking for information for
     * creating a new contact.
     * @return
     */
    private static Contact createNewContact(){
        System.out.println("Please enter new contacts first name.");
        String fName= input.getString();
        System.out.println("Please enter new contacts last name.");
        String lName= input.getString();
        System.out.println("Please enter new contacts phone number. ( With or without area code.)");
        String pNumber= input.getString();
        return new Contact(fName,lName,pNumber);
    }



    public static void main(String[] args) {
        runApp();

    }
}
