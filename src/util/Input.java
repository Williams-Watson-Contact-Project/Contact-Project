package util;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    /**
     * Default constructor, initializes a new Scanner.
     */
    public Input() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Takes in a user input as a string.
     * @return
     */
    public String getString() {
        return scanner.nextLine();
    }

    /**
     * checks for a yes or no condition and returns
     * true if user enters yes or y ignoring case else it is
     * false.
     * @return
     */
    public boolean yesNo(){
        System.out.println("Enter Yes/Y or No/N");
        String yNStr = this.scanner.nextLine();
        return yNStr.equalsIgnoreCase("yes") || yNStr.equalsIgnoreCase("y");
    }

    /**
     * Ask user for an integer within a set range. If
     * integer is out of range, ask again. Check for
     * a proper integer input in getInput() method.
     * @param min
     * @param max
     * @return
     */
    public int getInt(int min, int max){
        int userInt = 0;
        do {
            System.out.printf("Enter a number between %d and %d\n", min, max);
            userInt = getInt();
        }while(userInt > max || userInt < min);

        return userInt;
    }

    /**
     * Checks for a proper integer input. If one is not,
     * throw a catch and try again.
     * @return
     */
    public int getInt(){
        int val = -1;
        String s = getString();
        try{
            val = Integer.valueOf(s);
        }catch(NumberFormatException e){
            System.err.println("Input is not a valid integer!\nTry Again!\n" + e);
            val = getInt();
        }
        return val;
    }
}
