/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import WebApp.Client;
import WebApp.DaoMet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Настя
 */
@Named(value = "request")
@RequestScoped
public class Request {

    @EJB
    private DaoMet dao;

    Session session = new Session();
    private List<Client> cl;
    
    public void allClient() {
        try {
            setCl(dao.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Request() {
    }

    /**
     * @return the cl
     */
    public List<Client> getCl() {
        allClient();
        return cl;
    }

    /**
     * @param cl the cl to set
     */
    public void setCl(List<Client> cl) {
        this.cl = cl;
    }

}
