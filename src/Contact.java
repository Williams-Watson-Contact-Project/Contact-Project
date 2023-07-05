public class Contact {

    private final String firstName;
    private final String lastName;

    private final Phone phone;

    /**
     * Constructor of a contact with a first and last name and number that passes it in
     */
    public Contact(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = new Phone(number);
    }

    /**
     * returns Contact's first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * returns Contact's last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * returns Contact's Phone number by calling
     * the Phone's getNumber() method.
     * @return
     */
    public String getPhone() {
        return phone.getNumber();
    }

    /**
     * returns the Contact's Full name as
     * first last.
     * @return
     */
    public String getFullName(){
        return firstName + " " + lastName;
    }

    /**
     * Returns the Full Contact information formated as
     * | full name | phone number |
     * @return
     */
    public String getContact(){
        return String.format("| %-15s | %12s |", getFullName() , getPhone());
    }

    /**
     * updates Contact's phone number so long as
     * the number being passed in is a valid number.
     * validation checks happen in Phone class.
     * @param phoneNumber
     */
    public void setNumber(String phoneNumber){
        this.phone.setNumber(phoneNumber);
    }
}
