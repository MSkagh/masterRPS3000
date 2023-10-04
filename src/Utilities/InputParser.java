package Utilities;

import java.util.Scanner;

public abstract class InputParser {

    public static int getAnInt(Scanner scanner){
        for (;;) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Please provide a number");
                scanner.next();
            }
        }
    }

}
