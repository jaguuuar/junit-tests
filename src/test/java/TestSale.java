import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSale {

    @Test
    public void testEmptyProductNameThrowsException() {
        Sale product = new Sale();
        assertThrows(IllegalArgumentException.class, () -> product.setProductName(""));
    }

    @Test
    public void testNonEmptyProductName() {
        Sale product = new Sale();
        String expected = "name";
        product.setProductName(expected);
        assertEquals(expected, product.getProductName());
    }

    @Test
    public void testWrongNetValueThrowsException() {
        Sale product = new Sale();
        BigDecimal netValue = new BigDecimal("122.234");
        assertThrows(IllegalArgumentException.class, () -> product.setNetValue(netValue));
    }

    @Test
    public void testNegativeNetValueThrowsException() {
        Sale product = new Sale();
        BigDecimal netValue = new BigDecimal("-122.34");
        assertThrows(IllegalArgumentException.class, () -> product.setNetValue(netValue));
    }

    @Test
    public void testCorrectNetValueScale() {
        Sale product = new Sale();
        BigDecimal expected = new BigDecimal("123.45");
        product.setNetValue(expected);
        assertEquals(expected, product.getNetValue());
    }

    @Test
    public void testWrongTaxRateThrowsException() {
        Sale product = new Sale();
        int taxRate = 115;
        assertThrows(IllegalArgumentException.class, () -> product.setTaxRate(taxRate));
    }

    @Test
    public void testCorrectTaxRateValue() {
        Sale product = new Sale();
        int expected = 75;
        product.setTaxRate(expected);
        assertEquals(expected, product.getTaxRate());
    }

    @Test
    public void testCorrectGrossValue() {
        BigDecimal nettValue = new BigDecimal("100");
        Sale product = new Sale("juice", nettValue, 23);
        BigDecimal expected = new BigDecimal("123.00");
        assertEquals(expected, product.getGrossValue());
    }

}
