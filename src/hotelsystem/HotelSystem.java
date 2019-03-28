/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelsystem;

import IT17029896.Reservation1;
import javax.swing.JFrame;

/**
 *
 * @author Shehan
 */
public class HotelSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
          Login L = new Login();
          L.setVisible(true);
          L.setLocationRelativeTo(null);
          L.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
       
        
    }
    
}
