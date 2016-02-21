package classes;

import factories.SaleFactory;
import interfaces.IVATCalculator;
import java.util.Iterator;
import java.util.LinkedList;

public class Sale {

    private LinkedList<SalesLineItem> sli;
    private IVATCalculator ivac;

    public Sale() {
        this.sli = new LinkedList<SalesLineItem>();
    }

    public void addSaleLineItem(int id, int quantity) {
        sli.add(new SalesLineItem(id, quantity));
    }

    public LinkedList<SalesLineItem> getList() {
        return this.sli;
    }

    public int getListLength() {
        return this.sli.size();
    }

    public int getTotal() {
        double total = 0.0;
        for (Iterator<SalesLineItem> it = sli.iterator(); it.hasNext();) {
            SalesLineItem sli1 = it.next();
            total += sli1.getSubTotal();
        }
        return (int) Math.round(total);
    }

    public int getGrandTotal() {
        return this.getTotal() + this.getVATAmount();
    }

    public int getVATAmount() {
        ivac = SaleFactory.getInstance().getVATCalculator();
        return ivac.getVATAmount(this.getTotal());
    }

    public boolean resetSale() {
        return sli.removeAll(sli);
    }
}
