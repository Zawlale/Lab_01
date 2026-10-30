public class ObjInputTest {

    /**
     * Tries each method in SafeInputObj.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("Name: " + name);

        int number = input.getInt("Enter any whole number");
        System.out.println("Whole number: " + number);

        int rangedInt = input.getRangedInt(
                "Enter a whole number", 1, 10);
        System.out.println("Ranged whole number: " + rangedInt);

        double decimal = input.getDouble("Enter any decimal number");
        System.out.println("Decimal number: " + decimal);

        double rangedDouble = input.getRangedDouble(
                "Enter a decimal number", 1, 10);
        System.out.println("Ranged decimal number: " + rangedDouble);

        boolean answer = input.getYNConfirm("Do you like Java?");
        System.out.println("Your answer: " + answer);

        String zip = input.getRegExString(
                "Enter a five-digit ZIP code", "\\d{5}");
        System.out.println("ZIP code: " + zip);

        System.out.println("\nAll seven methods completed!");
    }
}