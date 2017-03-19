package WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
@Stateless
public class Dao {
    Connection con;
    private static final String url = "jdbc:mysql://localhost/s1";
private static final String user = "root";
private static final String password = "root";
    
    public Dao() {
    }
    
   
     public Connection openConnection() throws SQLException {
        try {            
            con = DriverManager.getConnection(url, user, password);;         
        } catch (SQLException ex) {
            throw new RuntimeException("Can't open connection", ex);
        }
        return con;
    }
}
