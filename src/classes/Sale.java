package classes;

import java.util.LinkedList;

public class Sale {

    private LinkedList<SalesLineItem> sli;

    public void addSaleLineItem(int id, int quantity) {
        sli.add(new SalesLineItem(id, quantity));
    }

    public double getTotal() {
        double total = 0.0;

        for (SalesLineItem item : sli) {
            total += item.getSubTotal();
        }

        return total;
    }

    public boolean resetSale() {
        return sli.removeAll(sli);
    }
}
