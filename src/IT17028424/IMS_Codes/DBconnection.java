
package IMS_Codes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author a
 */
public class DBconnection {
    
    public static Connection connect()
    {
        Connection conn = null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelsystem","root","");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        return conn;
    }
    
}
