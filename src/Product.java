import java.util.Objects;

public class Product {

    private String name;
    private String description;
    private String ID;
    private double cost;

    /**
     * Makes a product with all its information.
     * @param name the product name
     * @param description the product description
     * @param ID the product ID
     * @param cost the product cost
     */
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        setCost(cost);
    }

    /**
     * Makes a product without a description.
     * @param name the product name
     * @param ID the product ID
     * @param cost the product cost
     */
    public Product(String name, String ID, double cost) {
        this(name, "", ID, cost);
    }

    /**
     * Gets the name.
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     * @return the product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the ID.
     * @return the product ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the cost.
     * @return the product cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Changes the cost if it is not negative.
     * @param cost the new cost
     */
    public void setCost(double cost) {
        if (cost >= 0 && Double.isFinite(cost)) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost must be a valid nonnegative number.");
        }
    }

    /**
     * Makes a line of CSV information.
     * @return the CSV record
     */
    public String toCSV() {
        return ID + ", " + name + ", " + description + ", " + cost;
    }

    /**
     * Makes a JSON record.
     * @return the JSON information
     */
    public String toJSON() {
        return "{\"ID\":\"" + ID
                + "\",\"name\":\"" + name
                + "\",\"description\":\"" + description
                + "\",\"cost\":" + cost + "}";
    }

    /**
     * Makes an XML record.
     * @return the XML information
     */
    public String toXML() {
        return "<Product>"
                + "<ID>" + ID + "</ID>"
                + "<name>" + name + "</name>"
                + "<description>" + description + "</description>"
                + "<cost>" + cost + "</cost>"
                + "</Product>";
    }

    /**
     * Shows the product information.
     * @return a readable description
     */
    @Override
    public String toString() {
        return ID + " " + name + " (" + description + ") - $"
                + String.format("%.2f", cost);
    }

    /**
     * Checks whether two products have the same ID.
     * @param obj the other object
     * @return true if the IDs match
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Product)) {
            return false;
        }

        Product other = (Product) obj;
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