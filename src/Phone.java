import java.util.regex.Pattern;

public class Phone {

    // variables
    private String number;
    private final String defaultNumber = "000-000-0000";

    public Phone(){
        this.number = defaultNumber;
    }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if(checkNumberFormat(number)){
            this.number = number;
        }else {
            System.out.println("Invalid number");
        }
    }

    public boolean checkNumberFormat(String number){
        boolean correctFormat = false;

        String temp1 = "1234567";
        String temp2 = "123-4567";
        String temp3 = "8901234567";
        String temp4 = "890-123-4567";

        if(number.contains("-")){
            if(Pattern.matches("^[2-9]\\d{2}-\\d{3}-\\d{4}$|\\d{3}-\\d{4}$", number)){
                correctFormat = true;
            }
        } else {
            if(Pattern.matches("^[2-9]\\d{9}$|\\d{7}$", number)){
                correctFormat = true;
            }
        }

        return correctFormat;
    }
}
