import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testGetName() {
        Product product = new Product("Laptop", "High-performance laptop", "12345", 999.99);
        assertEquals("Laptop", product.getName());
    }

    @Test
    public void testGetDescription() {
        Product product = new Product("Tablet", "Portable tablet", "54321", 299.99);
        assertEquals("Portable tablet", product.getDescription());
    }

    @Test
    public void testGetID() {
        Product product = new Product("Smartphone", "Advanced smartphone", "67890", 699.99);
        assertEquals("67890", product.getID());
    }

    @Test
    public void testGetCost() {
        Product product = new Product("Headphones", "Noise-canceling headphones", "13579", 149.99);
        assertEquals(149.99, product.getCost(), 0.01); // Provide a delta for double comparison
    }

    @Test
    public void testToCSVDataRecord() {
        Product product = new Product("Monitor", "Large display monitor", "24680", 349.99);
        assertEquals("24680, Monitor, Large display monitor, 349.99", product.toCSVDataRecord());
    }
}