/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.IVATCalculator;

/**
 *
 * @author saifur
 */
public class MyVATCalculator implements IVATCalculator {

    @Override
    public int getVATAmount(double saleTotal) {
        return (int) Math.round(saleTotal * 0.05);
    }

}
