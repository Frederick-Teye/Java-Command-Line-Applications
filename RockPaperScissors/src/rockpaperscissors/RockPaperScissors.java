package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors Game");

    }


    private static boolean isNumeric(String arg) {
        if (arg == null) {
            return false;
        }

        try {
            Double.parseDouble(arg);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


}
