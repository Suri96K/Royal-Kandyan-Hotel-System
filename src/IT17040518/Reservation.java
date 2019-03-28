/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17040518;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Harish
 */
public class Reservation {
    
    private String RId;
    private Time Time;
    private double NoOfGuest;
    private Date date;
    private String View;
    private String TableId;
    
    private String Reservation;
    
     public String getReservation() {
        return Reservation;
    }

    public void setReservation(String Reservation) {
        this.Reservation = Reservation;
    }
    
    public String getView() {
        return View;
    }

    public void setView(String View) {
        this.View = View;
    }


    
}
