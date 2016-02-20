package adapters;

import classes.BDVATCalculator;
import interfaces.IVATCalculator;

public class BDVATAdapter implements IVATCalculator {

    @Override
    public int getVATAmount(double saleTotal) {
        int vat=0;
        BDVATCalculator bdVATCalculator = new BDVATCalculator();
        vat = Math.round(bdVATCalculator.calculateVATAmount(saleTotal));
        return vat;
    }

}
