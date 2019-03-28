/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17029896;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shehan
 */
public class Guest 
{
    private String name;
    private String type;
    private String Number;
    private int roomNo;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    
    public int getID()
    {
         Connection connection = null;
         Statement statement = null;
         Statement statement2 = null;
         ResultSet resultSet = null;
         ResultSet resultSet2 = null;
         final String url = "jdbc:mysql://localhost:3306/hotelsystem";
         final String user = "root";
         final String password = "";
         final String driver = "com.mysql.jdbc.Driver";
         
         try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            
            String sql2 = "SELECT ID FROM guest WHERE type='"+type+"' AND number ='"+Number+"' ";
                resultSet = statement.executeQuery(sql2);
                while(resultSet.next())
                {
                    return resultSet.getInt("ID");
                }
            
            
        } catch (Exception ex)
        {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return 0;
    }
    
    
    
}
