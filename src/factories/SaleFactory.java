package factories;

import classes.ProductSpecification;
import java.util.LinkedList;

public class SaleFactory {

    private static LinkedList<ProductSpecification> psList = new LinkedList<ProductSpecification>();

    public static ProductSpecification getProductSpecification(int id) {
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

    public static void populate() {

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
}
