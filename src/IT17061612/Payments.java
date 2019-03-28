/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17061612;

import java.util.Objects;

/**
 *
 * @author Chanuka Balagalla
 */
public class Payments {
    
    private int Number;
    private String Type;
    private double Price;
    private double Discount;
    
    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
//this.Discount = Objects.requireNonNull(Discount);
    }
    
    
}
