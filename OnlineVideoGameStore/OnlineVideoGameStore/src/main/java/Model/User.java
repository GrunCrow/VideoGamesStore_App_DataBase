/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author albam
 */
public class User {
    private String user_id;
    private String user_name;
    private String user_email;
    private String user_password;

    public User(){
        user_id = null;
        user_name = null;
        user_email = null;
        user_password = null;
    }
    
    public User(String Email, String Password){
        user_id = null;
        user_name = null;
        user_email = Email;
        user_password = Password;
    }
    
    public User(String ID, String Email, String Password){
        user_id = ID;
        user_name = null;
        user_email = Email;
        user_password = Password;
    }
    
    public User(String ID, String Name, String Email, String Password){
        user_id = ID;
        user_name = Name;
        user_email = Email;
        user_password = Password;
    }
    
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    
    
}
