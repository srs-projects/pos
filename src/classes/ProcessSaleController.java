package classes;

import factories.SaleFactory;

public class ProcessSaleController {

    private Sale sale;

    public ProcessSaleController() {
        sale = new Sale();
    }

    public void makeNewSale() {
        sale.resetSale();
    }

    public void addItem(int id, int quantity) {
        sale.addSaleLineItem(id, quantity);
    }

    public Sale getSale() {
        return this.sale;
    }

    public ProductSpecification getProductSpecification(int id) {
        return SaleFactory.getProductSpecification(id);
    }

}
