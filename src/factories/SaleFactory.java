package factories;

import classes.MyVATCalculator;
import classes.ProductSpecification;
import interfaces.IVATCalculator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleFactory {

    private static LinkedList<ProductSpecification> psList = new LinkedList<ProductSpecification>();
    private static SaleFactory instance;

    private IVATCalculator vatCalculator;

    public SaleFactory() {
        vatCalculator = new MyVATCalculator();
    }

    public ProductSpecification getProductSpecification(int id) {
        ProductSpecification ps = new ProductSpecification(); // temp
        //search in ps list then retrun
        int length = psList.size();
        while (length > 0) {
            length--;
            int idSearch = (int) psList.get(length).getId();
            if (idSearch == id) {
                ps = psList.get(length);
                break;
            }
        }

        return ps;
    }

    public void populate() {

        //later from db
        ProductSpecification ps = new ProductSpecification();

        String[] name = {"notebook", "marker", "pen", "eraser", "sharpner", "pencil", "chalk", "duster", "ruler"};
        String[] desc = {"desc of notebook", "desc of marker", "desc of pen", "desc of eraser", "desc of sharpner", "desc of pencil", "desc of chalk", "desc of duster", "desc of ruler"};
        double[] price = {90, 35, 15, 10, 15, 8, 2.5, 50, 75};

        for (int i = 0; i < name.length; i++) {
            ps = new ProductSpecification();
            ps.setId(i + 1);
            ps.setName(name[i]);
            ps.setDescription(desc[i]);
            ps.setPrice(price[i]);
            psList.add(ps);
        }
    }

    public static synchronized SaleFactory getInstance() {
        if (instance == null) {
            instance = new SaleFactory();
            instance.populate();
        }
        return instance;
    }

    public IVATCalculator getVATCalculator() {
        if (vatCalculator == null) {
            String className = System.getProperty(vatCalculator.getClass().getName());
            try {
                vatCalculator = (IVATCalculator) Class.forName(className).newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SaleFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(SaleFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(SaleFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vatCalculator;
    }

}
