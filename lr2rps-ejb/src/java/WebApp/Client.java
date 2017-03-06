
package WebApp; 

import java.util.Date;

public class Client implements java.io.Serializable {
private int id; 
private String fio;
private String phone;
private String adress;
private Date bdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the DateBirth
     */
    public Date getBdate() {
        return bdate;
    }

    /**
     * @param bdate the DateBirth to set
     */
    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

}