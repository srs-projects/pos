package classes;

import factories.SaleFactory;

public class SalesLineItem {

    private ProductSpecification ps = new ProductSpecification();
    private int quantity = 0;

    public SalesLineItem(int id, int quantity) {
        ps = SaleFactory.getInstance().getProductSpecification(id);
        this.quantity = quantity;
    }

    public double getSubTotal() {
       return this.quantity * ps.getPrice();
    }
}
