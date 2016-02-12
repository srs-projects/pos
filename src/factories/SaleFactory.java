package factories;

import classes.ProductSpecification;
import java.util.LinkedList;

public class SaleFactory {

    private static LinkedList<ProductSpecification> psList;

    public SaleFactory() {

        //later from db
        ProductSpecification ps = new ProductSpecification();
        
        ps.setId(1);
        ps.setName("Book");
        ps.setDescription("knowledge house");
        ps.setPrice(24.99);
        psList.add(ps);
        
        ps.setId(2);
        ps.setName("Note");
        ps.setDescription("take notes form boos");
        ps.setPrice(9.99);
        psList.add(ps);
    }

    public static ProductSpecification getProductSpecification(int id) {
        ProductSpecification ps =new ProductSpecification(); // temp
        //search in ps list then retrun
        int length = psList.size();
        while(length>0){
            if(psList.get(length-1).getId()==id)
            {
                ps = psList.get(length-1);
                break;
            }
            length--;
        }
        
        return ps;
    }
}
