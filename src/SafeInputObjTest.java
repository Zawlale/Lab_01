import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SafeInputObjTest {

    @Test
    void testDefaultConstructor() {
        SafeInputObj input = new SafeInputObj();
        assertNotNull(input);
    }

    @Test
    void testScannerConstructor() {
        Scanner scanner = new Scanner("Cendrine\n");
        SafeInputObj input = new SafeInputObj(scanner);

        assertEquals("Cendrine", input.getNonZeroLenString("Name"));
        assertFalse(scanner.hasNextLine());
    }

    @Test
    void testGetNonZeroLenString() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("\nCendrine\n"));

        assertEquals("Cendrine", input.getNonZeroLenString("Name"));
    }

    @Test
    void testGetInt() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("hello\n20\n"));

        assertEquals(20, input.getInt("Number"));
    }

    @Test
    void testGetRangedInt() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("hello\n0\n11\n5\n"));

        assertEquals(5, input.getRangedInt("Number", 1, 10));
    }

    @Test
    void testRangedIntBoundaries() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("1\n10\n"));

        assertEquals(1, input.getRangedInt("Number", 1, 10));
        assertEquals(10, input.getRangedInt("Number", 1, 10));
    }

    @Test
    void testGetDouble() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("hello\n12.5\n"));

        assertEquals(12.5, input.getDouble("Decimal"), 0.001);
    }

    @Test
    void testGetRangedDouble() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("hello\n0.5\n10.5\n5.5\n"));

        assertEquals(5.5,
                input.getRangedDouble("Decimal", 1, 10), 0.001);
    }

    @Test
    void testRangedDoubleBoundaries() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("1.0\n10.0\n"));

        assertEquals(1.0,
                input.getRangedDouble("Decimal", 1, 10), 0.001);
        assertEquals(10.0,
                input.getRangedDouble("Decimal", 1, 10), 0.001);
    }

    @Test
    void testGetYNConfirmYes() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("maybe\ny\n"));

        assertTrue(input.getYNConfirm("Continue?"));
    }

    @Test
    void testGetYNConfirmNo() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("maybe\nn\n"));

        assertFalse(input.getYNConfirm("Continue?"));
    }

    @Test
    void testGetRegExString() {
        SafeInputObj input = new SafeInputObj(
                new Scanner("abc\n1234\n45040\n"));

        assertEquals("45040",
                input.getRegExString("ZIP code", "\\d{5}"));
    }

    @Test
    void testToString() {
        SafeInputObj input = new SafeInputObj();

        assertEquals("SafeInputObj console input helper",
                input.toString());
    }
}