package classes;

public class SalesLineItem {

    private ProductSpecification ps;
    private int quantity;

    public SalesLineItem(int id, int quantity) {
        ps = new ProductSpecification(id);
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return this.quantity * ps.getPrice();
    }
}
