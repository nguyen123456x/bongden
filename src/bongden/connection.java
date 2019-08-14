package bongden;

/**
 *
 * @author DLC
 *
 */
import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class connection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public Connection dbConnect(){
     try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bongden?zeroDateTimeBehavior=convertToNull","root","");
            System.out.println("1");
            st=con.createStatement();
        } catch (Exception e) {
            System.out.println("error"+ e);
            
        }
     return con;
    }
    
    }

