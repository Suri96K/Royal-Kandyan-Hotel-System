/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17040518;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harish
 */
public class Meal {

    static void setModel(DefaultTableModel defaultTableModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String mealType;
    private String FoodName;
    private int PortionSize;
    
    private String Meal;
    
     public String getMeal() {
        return Meal;
    }

    public void setMeal(String Meal) {
        this.Meal = Meal;
    }

}
