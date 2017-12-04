import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCustomer {

    @Test
    public void testEmptyNameThrowsException() {
        Customer customer = new Customer();
        assertThrows(IllegalArgumentException.class, () -> customer.setName(""));
    }

    @Test
    public void testEmptySurnameThrowsException() {
        Customer customer = new Customer();
        assertThrows(IllegalArgumentException.class, () -> customer.setSurname(""));
    }

    @Test
    public void testNonEmptyName() {
        Customer customer = new Customer();
        String expected = "name";
        customer.setName(expected);
        assertEquals(expected, customer.getName());
    }

    @Test
    public void testNonEmptySurname() {
        Customer customer = new Customer();
        String expected = "surname";
        customer.setSurname(expected);
        assertEquals(expected, customer.getSurname());
    }

    @Test
    public void testWrongBirthYearThrowsException() {
        Customer customer = new Customer();
        int birthYear = 2020;
        assertThrows(IllegalArgumentException.class, () -> customer.setBirthyear(birthYear));
    }

    @Test
    public void testCorrectBirthYearValue() {
        Customer customer = new Customer();
        int expected = 1992;
        customer.setBirthyear(expected);
        assertEquals(expected, customer.getBirthyear());
    }

    @Test
    public void testWrongGenderThrowsException() {
        Customer customer = new Customer();
        String gender = "MaleFe";
        assertThrows(IllegalArgumentException.class, () -> customer.setGender(gender));
    }

    @Test
    public void testCorrectGenderValue() {
        Customer customer = new Customer();
        String expected = "Female";
        customer.setGender(expected);
        assertEquals(expected, customer.getGender());
    }

    @Test
    public void testCorrectAgeValue() {
        Customer customer = new Customer("Jan", "Kowalski", 1992, "Male");
        int expected = 25;
        assertEquals(expected, customer.getAge());
    }

}