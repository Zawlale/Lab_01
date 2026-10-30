import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Pipeweed", "Long Bottom Leaf", "000001", 600.0);
    }

    @Test
    void testConstructor() {
        assertEquals("Pipeweed", product.getName());
        assertEquals("Long Bottom Leaf", product.getDescription());
        assertEquals("000001", product.getID());
        assertEquals(600.0, product.getCost(), 0.001);
    }

    @Test
    void testOverloadedConstructor() {
        Product other = new Product("Lembas", "000002", 200.0);

        assertEquals("Lembas", other.getName());
        assertEquals("", other.getDescription());
        assertEquals("000002", other.getID());
        assertEquals(200.0, other.getCost(), 0.001);
    }

    @Test
    void testSetName() {
        product.setName("Wine");
        assertEquals("Wine", product.getName());
    }

    @Test
    void testSetDescription() {
        product.setDescription("Woodland Elf Wine");
        assertEquals("Woodland Elf Wine", product.getDescription());
    }

    @Test
    void testSetCost() {
        product.setCost(400.0);
        assertEquals(400.0, product.getCost(), 0.001);
    }

    @Test
    void testZeroCost() {
        product.setCost(0.0);
        assertEquals(0.0, product.getCost(), 0.001);
    }

    @Test
    void testInvalidCost() {
        assertThrows(IllegalArgumentException.class,
                () -> product.setCost(-10.0));

        assertThrows(IllegalArgumentException.class,
                () -> product.setCost(Double.NaN));

        assertThrows(IllegalArgumentException.class,
                () -> product.setCost(Double.POSITIVE_INFINITY));

        assertEquals(600.0, product.getCost(), 0.001);
    }

    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("Wine", "Elf Wine", "000003", -5.0));
    }

    @Test
    void testToCSV() {
        String expected = "000001, Pipeweed, Long Bottom Leaf, 600.0";
        assertEquals(expected, product.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"ID\":\"000001\",\"name\":\"Pipeweed\","
                + "\"description\":\"Long Bottom Leaf\",\"cost\":600.0}";

        assertEquals(expected, product.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Product><ID>000001</ID>"
                + "<name>Pipeweed</name>"
                + "<description>Long Bottom Leaf</description>"
                + "<cost>600.0</cost></Product>";

        assertEquals(expected, product.toXML());
    }

    @Test
    void testToString() {
        String expected = "000001 Pipeweed (Long Bottom Leaf) - $"
                + String.format("%.2f", 600.0);

        assertEquals(expected, product.toString());
    }

    @Test
    void testEquals() {
        Product sameID = new Product("Lembas", "Elven Bread", "000001", 200.0);
        Product differentID = new Product("Pipeweed", "Long Bottom Leaf",
                "000002", 600.0);

        assertEquals(product, sameID);
        assertNotEquals(product, differentID);
        assertEquals(product, product);
        assertNotEquals(null, product);
        assertNotEquals("Pipeweed", product);
    }

    @Test
    void testHashCode() {
        Product sameID = new Product("Lembas", "Elven Bread", "000001", 200.0);

        assertEquals(product.hashCode(), sameID.hashCode());
    }
}