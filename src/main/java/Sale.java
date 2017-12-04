import java.math.BigDecimal;

public class Sale {


    private String productName;
    private BigDecimal netValue;
    private int taxRate;

    public Sale(){}

    public Sale(String productName, BigDecimal netValue, int taxRate) {
        this.productName = productName;
        this.netValue = netValue;
        this.taxRate = taxRate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName.trim().equals("")) throw new IllegalArgumentException("Product name cannot be empty");
        this.productName = productName;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        if(netValue.compareTo(BigDecimal.ZERO) == -1) throw new IllegalArgumentException("NetValue should be a positive number");
        if(netValue.scale() > 2)  throw new IllegalArgumentException("NetValue should be number with only two decimal point places");
        this.netValue = netValue;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        if(taxRate < 0 || taxRate > 100) throw new IllegalArgumentException("Tax rate value from 0 to 100");
        this.taxRate = taxRate;
    }

    public BigDecimal getGrossValue() {
        BigDecimal taxAmount = netValue.multiply(new BigDecimal(taxRate / 100d));
        BigDecimal grossValue = netValue.add(taxAmount);
        grossValue = grossValue.setScale(2, BigDecimal.ROUND_DOWN);

        return grossValue;
    }

}
