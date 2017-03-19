
package WebApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class DaoMet implements DAORemote {

    @EJB
    private Dao dao;
Statement stmt; 
ResultSet rs;
Connection con;
@Override
    public List<Client> getAll() throws SQLException {
        con = dao.openConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM t1"); 
        List<Client> list = new ArrayList<>();
        while (rs.next()) {
            Client cl = new Client();
            cl.setId (rs.getInt("id")); 
            cl.setFio( rs.getString("fio"));
            cl.setPhone(rs.getString("phone")); 
            cl.setAdress(rs.getString("adress")); 
            cl.setBdate(rs.getDate("bdate"));
            list.add(cl);
        }
        return list;
    }
    
    @Override
    public Client geClient(int id) throws SQLException {
        con = dao.openConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM t1 where id = "+id); 
            Client cl = new Client();
        while (rs.next()) {
            cl.setId (rs.getInt("id")); 
            cl.setFio( rs.getString("fio"));
            cl.setPhone(rs.getString("phone")); 
            cl.setAdress(rs.getString("adress")); 
            cl.setBdate(rs.getDate("bdate"));
        }
        return cl;
    }

    @Override
    public void create(Client cl) throws SQLException {
        con = dao.openConnection(); 
        stmt = con.createStatement();
        stmt.executeUpdate ("INSERT INTO s1.t1 (fio, Phone, Adress) values ('"+ cl.getFio() +"', '"+ cl.getPhone() +"', '"+ cl.getAdress() +"');");
    }

    @Override
    public void delete(int id) throws SQLException {
        con = dao.openConnection();
        stmt = con.createStatement();
        stmt.executeUpdate ( "DELETE FROM t1 WHERE id=" + id);
        
    }
    
    @Override
    public void change (Client cl) throws SQLException {
    con = dao.openConnection();
    stmt = con.createStatement();
    stmt.executeUpdate ("UPDATE s1.t1 SET fio = '" + cl.getFio() + "', phone =  '" +  cl.getPhone() +"', bdate = '"+ new java.sql.Date(cl.getBdate().getTime()) + "', adress =  '" +  cl.getAdress() + "' WHERE id= " + cl.getId());
}

  
}
