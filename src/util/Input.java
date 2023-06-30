package util;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public boolean yesNo(){
        System.out.println("Enter Yes/Y or No/N");
        String yNStr = this.scanner.nextLine();
        return yNStr.equalsIgnoreCase("yes") || yNStr.equalsIgnoreCase("y");
    }

    public int getInt(int min, int max){
        int userInt = 0;
        do {
            System.out.printf("Enter a number between %d and %d\n", min, max);
            userInt = getInt();
        }while(userInt > max || userInt < min);

        return userInt;
    }

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
