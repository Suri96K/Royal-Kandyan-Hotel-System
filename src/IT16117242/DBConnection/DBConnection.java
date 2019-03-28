/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT16117242.DBConnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Harish
 */
public class DBConnection {
    public static Connection connect()
    {
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelsystem","root","");
            System.out.println("Db connection built");
        }
        
        catch(Exception e)
        {
            System.out.println(e+"Db connection failed");
        }
        
        return conn;
    }
    
}
