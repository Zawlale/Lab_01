
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    // Check if we can make a person
    @Test
    public void testConstructor() {
        Person person = new Person("Cendrine", "Some", "000001", "Ms.", 2005);

        assertEquals("Cendrine", person.getFirstName());
        assertEquals("Some", person.getLastName());
        assertEquals("000001", person.getID());
        assertEquals("Ms.", person.getTitle());
        assertEquals(2005, person.getYOB());
    }

    // Check the other constructor
    @Test
    public void testSecondConstructor() {
        Person person = new Person("Frodo", "Baggins", "000002", 2000);

        assertEquals("Frodo Baggins", person.formalName());
    }

    // Check if we can change information
    @Test
    public void testSetters() {
        Person person = new Person("Jane", "Smith", "000003", "Ms.", 2001);

        person.setFirstName("Janet");
        person.setLastName("Johnson");
        person.setTitle("Dr.");
        person.setYOB(1999);

        assertEquals("Janet", person.getFirstName());
        assertEquals("Johnson", person.getLastName());
        assertEquals("Dr.", person.getTitle());
        assertEquals(1999, person.getYOB());
    }

    // Make sure the birth year is valid
    @Test
    public void testInvalidBirthYear() {
        Person person = new Person("Jane", "Smith", "000003", "Ms.", 2001);

        assertThrows(IllegalArgumentException.class, () -> person.setYOB(1800));
    }

    // Check the full name
    @Test
    public void testFullName() {
        Person person = new Person("Cendrine", "Some", "000001", "Ms.", 2005);

        assertEquals("Cendrine Some", person.fullName());
    }

    // Check the formal name
    @Test
    public void testFormalName() {
        Person person = new Person("Cendrine", "Some", "000001", "Ms.", 2005);

        assertEquals("Ms. Cendrine Some", person.formalName());
    }

    // Check the age for a specific year
    @Test
    public void testAge() {
        Person person = new Person("Cendrine", "Some", "000001", "Ms.", 2005);

        assertEquals("21", person.getAge(2026));
    }

    // Check the age using the current year
    @Test
    public void testCurrentAge() {
        Person person = new Person("Cendrine", "Some", "000001", "Ms.", 2005);

        int currentYear = java.util.Calendar.getInstance().get(
                java.util.Calendar.YEAR);

        assertEquals(String.valueOf(currentYear - 2005), person.getAge());
    }

    // Check the CSV format
    @Test
    public void testToCSV() {
        Person person = new Person("Jane", "Smith", "000003", "Ms.", 2001);

        assertEquals("000003, Jane, Smith, Ms., 2001", person.toCSV());
    }

    // Check the JSON format
    @Test
    public void testToJSON() {
        Person person = new Person("Jane", "Smith", "000003", "Ms.", 2001);

        assertEquals("{\"ID\":\"000003\",\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"title\":\"Ms.\",\"YOB\":2001}",
                person.toJSON());
    }

    // Check the XML format
    @Test
    public void testToXML() {
        Person person = new Person("Jane", "Smith", "000003", "Ms.", 2001);

        assertEquals("<Person><ID>000003</ID><firstName>Jane</firstName><lastName>Smith</lastName><title>Ms.</title><YOB>2001</YOB></Person>",
                person.toXML());
    }

    // Check the toString method
    @Test
    public void testToString() {
        Person person = new Person("Jane", "Smith", "000003", "Ms.", 2001);

        assertEquals("000003 Ms. Jane Smith (2001)", person.toString());
    }

    // Check if matching IDs count as the same person
    @Test
    public void testEquals() {
        Person person1 = new Person("Jane", "Smith", "000003", "Ms.", 2001);
        Person person2 = new Person("Janet", "Johnson", "000003", "Dr.", 1999);

        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
    }
}
