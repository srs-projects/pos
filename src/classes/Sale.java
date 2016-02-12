package classes;

import java.util.LinkedList;

public class Sale {

    private LinkedList<SalesLineItem> sli;

    public Sale() {
        sli = new LinkedList<SalesLineItem>();
    }

    public void addSaleLineItem(int id, int quantity) {
        sli.add(new SalesLineItem(id, quantity));
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < sli.size(); i++) {
            total += sli.get(i).getSubTotal();
        }
        return total;
    }

    public boolean resetSale() {
        return sli.removeAll(sli);
    }
}
