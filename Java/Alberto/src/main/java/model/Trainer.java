package model;

/**
 *
 * @author usuario
 */
public class Trainer {
    private String t_cod;
    private String t_name;
    private String t_surname1;
    private String t_surname2;
    private String t_idnumber;
    private String t_phonenumber;
    private String t_email;
    private String t_date;
    private String t_nick;

    public Trainer(String t_cod, String t_name, String t_surname1, String t_surname2, String t_idnumber, String t_phonenumber, String t_email, String t_date, String t_nick) {
        this.t_cod = t_cod;
        this.t_name = t_name;
        this.t_surname1 = t_surname1;
        this.t_surname2 = t_surname2;
        this.t_idnumber = t_idnumber;
        this.t_phonenumber = t_phonenumber;
        this.t_email = t_email;
        this.t_date = t_date;
        this.t_nick = t_nick;
    }

    public String getT_cod() {
        return t_cod;
    }

    public String getT_name() {
        return t_name;
    }

    public String getT_surname1() {
        return t_surname1;
    }

    public String getT_surname2() {
        return t_surname2;
    }

    public String getT_idnumber() {
        return t_idnumber;
    }

    public String getT_phonenumber() {
        return t_phonenumber;
    }

    public String getT_email() {
        return t_email;
    }

    public String getT_date() {
        return t_date;
    }

    public String getT_nick() {
        return t_nick;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public void setT_surname1(String t_surname1) {
        this.t_surname1 = t_surname1;
    }

    public void setT_surname2(String t_surname2) {
        this.t_surname2 = t_surname2;
    }

    public void setT_idnumber(String t_idnumber) {
        this.t_idnumber = t_idnumber;
    }

    public void setT_phonenumber(String t_phonenumber) {
        this.t_phonenumber = t_phonenumber;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }

    public void setT_date(String t_date) {
        this.t_date = t_date;
    }

    public void setT_nick(String t_nick) {
        this.t_nick = t_nick;
    }

    public void setT_cod(String t_cod) {
        this.t_cod = t_cod;
    }
    
    
}
