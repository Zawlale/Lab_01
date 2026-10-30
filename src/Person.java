
import java.util.Calendar;
import java.util.Objects;

public class Person {

    // Information about each person
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    /**
     * Makes a person with all their information.
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param ID the person's ID
     * @param title the person's title
     * @param YOB the year they were born
     */
    public Person(String firstName, String lastName, String ID,
                  String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        setYOB(YOB);
    }

    /**
     * Makes a person without a title.
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param ID the person's ID
     * @param YOB the year they were born
     */
    public Person(String firstName, String lastName, String ID, int YOB) {
        this(firstName, lastName, ID, "", YOB);
    }

    /**
     * Gets the first name.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Changes the first name.
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Changes the last name.
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the ID.
     * @return the person's ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the title.
     * @return the person's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Changes the title.
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the birth year.
     * @return the birth year
     */
    public int getYOB() {
        return YOB;
    }

    /**
     * Changes the birth year if it is allowed.
     * @param YOB the new birth year
     */
    public void setYOB(int YOB) {
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        } else {
            throw new IllegalArgumentException("Birth year must be between 1940 and 2010.");
        }
    }

    /**
     * Puts the first and last name together.
     * @return the full name
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Puts the title and full name together.
     * @return the formal name
     */
    public String formalName() {
        return title.isEmpty() ? fullName() : title + " " + fullName();
    }

    /**
     * Finds the person's age using this year.
     * @return the age as a String
     */
    public String getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return getAge(year);
    }

    /**
     * Finds the person's age for a certain year.
     * @param year the year we want to check
     * @return the age as a String
     */
    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    /**
     * Makes a line of CSV information.
     * @return the CSV record
     */
    public String toCSV() {
        return ID + ", " + firstName + ", " + lastName
                + ", " + title + ", " + YOB;
    }

    /**
     * Makes a JSON record.
     * @return the JSON information
     */
    public String toJSON() {
        return "{\"ID\":\"" + ID
                + "\",\"firstName\":\"" + firstName
                + "\",\"lastName\":\"" + lastName
                + "\",\"title\":\"" + title
                + "\",\"YOB\":" + YOB + "}";
    }

    /**
     * Makes an XML record.
     * @return the XML information
     */
    public String toXML() {
        return "<Person>"
                + "<ID>" + ID + "</ID>"
                + "<firstName>" + firstName + "</firstName>"
                + "<lastName>" + lastName + "</lastName>"
                + "<title>" + title + "</title>"
                + "<YOB>" + YOB + "</YOB>"
                + "</Person>";
    }

    /**
     * Shows the person's information.
     * @return a readable description
     */
    @Override
    public String toString() {
        return ID + " " + formalName() + " (" + YOB + ")";
    }

    /**
     * Checks whether two people have the same ID.
     * @param obj the other object
     * @return true if the IDs match
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;
        return Objects.equals(ID, other.ID);
    }

    /**
     * Makes a hash code using the ID.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
