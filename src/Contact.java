public class Contact {

    private String firstName;
    private String lastName;

    private Phone phone;

    //Constructor of a person with a name and last number with a number that passes it in
    public Contact(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = new Phone(number);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone.getNumber();
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }



    public String getContact(){
        return String.format("| %-15s | %12s |", getFullName() , getPhone());
    }

    public void setNumber(String phoneNumber){
        this.phone.setNumber(phoneNumber);
    }
}
