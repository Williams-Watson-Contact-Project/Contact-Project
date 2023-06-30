import java.util.regex.Pattern;

public class Phone {

    // variables
    private String number;
    private final String defaultNumber = "000-000-0000";

    /**
     * default constructor
     * set this.number to as default number.
     */
    public Phone(){
        this.number = defaultNumber;
    }

    /**
     * Constructor, sets number to the number passed in
     * so long as it is of a proper format. if not set
     * number to the default number.
     * @param number
     */
    public Phone(String number) {
        if(checkNumberFormat(number)){
            if(number.contains("-")){
                this.number = number;
            }else{
                this.number = formatNumber(number);
            }
        } else {
            this.number = defaultNumber;
        }
    }

    /**
     * return this.number
     * @return
     */
    public String getNumber() {
        return number;
    }

    /**
     * So long as the number passed in is of the correct format
     * set this.number to the number passed in, in the format of
     * xxx-xxxx or xxx-xxx-xxxx.
     * @param number
     */
    public void setNumber(String number) {
        if(checkNumberFormat(number)){
            if(number.contains("-")){
                this.number = number;
            }else{
                this.number = formatNumber(number);
            }
        }else {
            System.out.println("Invalid number");
        }
    }

    /**
     * Check to see if the number passed in is of a valid format.
     * Valid numbers ar xxxxxxx | xxxxxxxxxx | xxx-xxxx | xxx-xxx-xxxx
     * @param number
     * @return
     */
    private boolean checkNumberFormat(String number){
        boolean correctFormat = false;

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

    /**
     * Takes in a phone number as a string and converts it into the correct
     * format of xxx-xxx-xxxx or xxx-xxxx;
     * @param number
     * @return
     */
    private String formatNumber(String number){
        StringBuilder sb = new StringBuilder(number);
        switch (number.length()){
            case 10:
                sb.insert(6, '-');
            case 7:
                sb.insert(3,'-');
        }
        return sb.toString();
    }
}
