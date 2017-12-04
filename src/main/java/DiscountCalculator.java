import java.math.BigDecimal;

public class DiscountCalculator {

    private Customer customer;

    public DiscountCalculator(Customer customer) {
        this.customer = customer;
    }

    public Double calculateDiscount() {

        Double discount = 0d;
        BigDecimal totalNetValue = new BigDecimal("0");
        BigDecimal limitNetValue = new BigDecimal("1000");
        for (Sale product: customer.getSales()) {
            totalNetValue = totalNetValue.add(product.getNetValue());
        }

        if(customer.getGender().equals("Female")) {
            discount += 0.05;
        } if (customer.getAge() > 60) {
            discount += 0.02;
        } if (customer.getSales().size() > 10) {
            discount += 0.01;
        } if (customer.getSales().size() > 20) {
            discount += 0.01;
        } if (limitNetValue.compareTo(totalNetValue) < 0 ) {
            discount += 0.015;
        }

        return discount;
    }
}
