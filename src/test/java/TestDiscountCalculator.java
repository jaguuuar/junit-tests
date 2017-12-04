import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiscountCalculator {

    Sale product1 = new Sale("prod1", new BigDecimal("357.00"), 23);
    Sale product2 = new Sale("prod2", new BigDecimal("257.00"), 23);
    Sale product3 = new Sale("prod3", new BigDecimal("100.00"), 20);
    Sale product4 = new Sale("prod4", new BigDecimal("457.00"), 8);
    Sale product5 = new Sale("prod5", new BigDecimal("20.00"), 23);


    @Test
    public void testWomenDayDiscount(){
        Customer customer = new Customer("Anna", "Kowalska", 1992, "Female");
        List<Sale> sales = new ArrayList<>();
        sales.add(product1);
        sales.add(product2);
        customer.setSales(sales);
        DiscountCalculator discountCalculator = new DiscountCalculator(customer);

        Double expected = 0.05d;
        assertEquals(expected, discountCalculator.calculateDiscount());
    }

    @Test
    public void testSeniorDiscount(){
        Customer customer = new Customer("Jan", "Kowalski", 1935, "Male");
        List<Sale> sales = new ArrayList<>();
        sales.add(product1);
        sales.add(product2);
        customer.setSales(sales);
        DiscountCalculator discountCalculator = new DiscountCalculator(customer);

        Double expected = 0.02d;
        assertEquals(expected, discountCalculator.calculateDiscount());
    }

    @Test
    public void testMoreThan10ProductsDiscount(){
        Customer customer = new Customer("Jan", "Kowalski", 1992, "Male");
        List<Sale> sales = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            sales.add(product5);
        }
        customer.setSales(sales);
        DiscountCalculator discountCalculator = new DiscountCalculator(customer);

        Double expected = 0.01d;
        assertEquals(expected, discountCalculator.calculateDiscount());
    }

    @Test
    public void testMoreThan20ProductsDiscount(){
        Customer customer = new Customer("Jan", "Kowalski", 1992, "Male");
        List<Sale> sales = new ArrayList<>();
        for(int i = 0; i < 21; i++) {
            sales.add(product5);
        }
        customer.setSales(sales);
        DiscountCalculator discountCalculator = new DiscountCalculator(customer);

        Double expected = 0.02d;
        assertEquals(expected, discountCalculator.calculateDiscount());
    }

    @Test
    public void testMoreThan1000NetValueDiscount(){
        Customer customer = new Customer("Jan", "Kowalski", 1992, "Male");
        List<Sale> sales = new ArrayList<>();
        sales.add(product4);
        sales.add(product4);
        sales.add(product1);

        customer.setSales(sales);
        DiscountCalculator discountCalculator = new DiscountCalculator(customer);

        Double expected = 0.015d;
        assertEquals(expected, discountCalculator.calculateDiscount());
    }

    @Test
    public void testSusanahDiscount(){
        Customer customer = new Customer("Susanah", "Susanah", 1952, "Female");
        List<Sale> sales = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            sales.add(product3);
        }
        customer.setSales(sales);
        DiscountCalculator discountCalculator = new DiscountCalculator(customer);

        Double expected = 0.105d;
        assertEquals(expected, discountCalculator.calculateDiscount());
    }

}