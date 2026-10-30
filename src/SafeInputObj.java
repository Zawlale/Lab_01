import java.util.Scanner;

public class SafeInputObj {

    private Scanner pipe;

    /**
     * Uses the keyboard for input.
     */
    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

    /**
     * Uses a Scanner provided to the object.
     * @param scanner the Scanner to use
     */
    public SafeInputObj(Scanner scanner) {
        pipe = scanner;
    }

    /**
     * Gets a String with at least one character.
     * @param prompt the message shown to the user
     * @return a String that is not empty
     */
    public String getNonZeroLenString(String prompt) {
        String retString = "";

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    /**
     * Gets an integer within a range.
     * @param prompt the message shown to the user
     * @param low the lowest allowed value
     * @param high the highest allowed value
     * @return an integer within the range
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");

            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range ["
                            + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets an integer with no range limit.
     * @param prompt the message shown to the user
     * @return the integer entered
     */
    public int getInt(String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a double within a range.
     * @param prompt the message shown to the user
     * @param low the lowest allowed value
     * @param high the highest allowed value
     * @return a double within the range
     */
    public double getRangedDouble(String prompt, int low, int high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");

            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range ["
                            + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a double with no range limit.
     * @param prompt the message shown to the user
     * @return the double entered
     */
    public double getDouble(String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a yes or no answer.
     * @param prompt the message shown to the user
     * @return true for yes and false for no
     */
    public boolean getYNConfirm(String prompt) {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must answer [Y/N]! " + response);
            }
        } while (!gotAVal);

        return retVal;
    }

    /**
     * Gets a String that matches a pattern.
     * @param prompt the message shown to the user
     * @param regExPattern the pattern the input must match
     * @return a String matching the pattern
     */
    public String getRegExString(String prompt, String regExPattern) {
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();

            if (response.matches(regExPattern)) {
                gotAVal = true;
            } else {
                System.out.println(response
                        + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }
        } while (!gotAVal);

        return response;
    }

    /**
     * Describes the input helper.
     * @return a readable description
     */
    @Override
    public String toString() {
        return "SafeInputObj console input helper";
    }
}