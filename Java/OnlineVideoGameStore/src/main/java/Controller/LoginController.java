/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Application.HibernateUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Model.Connect;
import Model.User;
import View.Login;
import View.MainView;
import View.MessageView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author albam
 */
public class LoginController implements ActionListener{
    
    private Session session = null;
    
    private Login vLogin;
    private Connect connection = null;
    private Connection con = null;
    private MessageView vMessage = null;
    private MainView mainW = null;
    //private RegisterView vRegister = null; //not implemented
    private boolean connectionOK = false;
    
    public LoginController() {
        vLogin = new Login();
        vMessage = new MessageView();
        mainW = new MainView();
        addListeners();

        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }
    
    public MainView getMainWindow() {
        return mainW;
    }
    
    private void addListeners() {
        vLogin.jButtonConnect.addActionListener(this);
        vLogin.jButtonExit.addActionListener(this);
        vLogin.jButtonRegister.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Connect":
                /*session = connect();
                if (session != null) {
                vMessage.Message("info", "Succesfull Conection with hibernate");
                vLogin.dispose();
                Controller Controller = new Controller(session);
                }
                else vMessage.Message("error", "Error in the connection with hibernate. "
                + "Check connection parameters");*/
                
                PreparedStatement pst;
                ResultSet rs;    

                String username = vLogin.jTextFieldEmail.getText();
                String password = vLogin.jPasswordField.getText();
                //connection = new Connect(username, password);
                if(username.equals("") || password.equals("")){
                    //JOptionPane.showMessageDialog(vLogin.rootPane,"Some fields are Empty","Error",1);
                    vMessage.Message("Error", "Some fields are Empty");
                }
                else{
                    try{
                        connection = new Connect();
                        con = connection.getConnection();
                        pst = con.prepareStatement("Select * from contact where EmailAdress=? and Password=?");
                        pst.setString(1, vLogin.jTextFieldEmail.getText());
                        pst.setString(2, vLogin.jPasswordField.getText());
                        rs = pst.executeQuery();
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, "Username and Password Matched");
                            
                            User user = new User(username,password);
                            pst = con.prepareStatement("Select FirstName from contact where EmailAdress=? and Password=?");
                            pst.setString(1, vLogin.jTextFieldEmail.getText());
                            pst.setString(2, vLogin.jPasswordField.getText());
                            String str = null;
                            rs = pst.executeQuery();
                            while(rs.next())
                                str = rs.getString(1);
                            user.setUser_name(str);
                            /*user.setUser_email(username);
                            user.setUser_password(password);*/
                            
                            //pst = con.prepareStatement("Select ContactID from contact where EmailAdress=? and Password=?");
                            /*String id = null;
                            while(rs.next())
                                id = rs.getString(ContactID);
                            user.setUser_id(id);*/
                            session = HibernateUtil.getSessionFactory().openSession();
                            
                            //pst = con.prepareStatement("Select ContactID from contact where EmailAdress=? and Password=?");
                            //user.setUser_name(pst);
                            //open new window (main) and close current one
                            vLogin.dispose();
                            Controller controller = new Controller(session,user);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Username and Password Do not Matched");
                            vLogin.jTextFieldEmail.setText("");
                            vLogin.jPasswordField.setText("");
                        }
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null,ex);
                    } 
                }
                break;
            case "Exit":
                vLogin.dispose();
                break;
            case "Register":
                JOptionPane.showMessageDialog(null, "This view has not been implemented");
                JOptionPane.showMessageDialog(null, "For Testing use:\n Email: test\n Password: 1234");
                break;
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }
        

    }
    
    /*private boolean connect() {

        boolean result = false;
        try {
            
            String Email = vLogin.jTextFieldEmail.getText();
            String Password = vLogin.jPasswordField.getText();
            connection = new Connect(Email, Password);
            result = true;
            vMessage.Message("info", "Conection Succesful");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vMessage.Message("error", "Check User or Password...\n" + e.getMessage());
        }
        return result;
    }*/
    
    public Session connect() {
        try {
            String Email = vLogin.jTextFieldEmail.getText();
            String Password = vLogin.jPasswordField.getText();
            connection = new Connect();
        if ("".equals(Email) && "".equals(Password))
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vMessage.Message("error", "Check User or Password...\n" + e.getMessage());
        }
        return(session);
    }
    
    public Connect getConnection(){
        return connection;
    }
}
