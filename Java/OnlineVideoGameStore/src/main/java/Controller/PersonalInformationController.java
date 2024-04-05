/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Connect;
import Model.User;
import View.MainView;
import View.MessageView;
import View.PersonalInformationView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author albam
 */
public class PersonalInformationController implements ActionListener{
    Session session;
    User user;

    private MessageView vMessage = null;
    private MainView mainW = null;
    private PersonalInformationView vPersonalInformation = null;
    
    private Connect connection = null;
    private Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs;  
    
    public PersonalInformationController(Session sess, User us) {
        user = us;
        try {
            session = sess;
        } catch (HibernateException e) {
            vMessage.Message("error", e.getMessage());
        }
        
        vPersonalInformation = new PersonalInformationView();
        vMessage = new MessageView();
        mainW = new MainView();
        addListeners();

        
        
        try{
            connection = new Connect();
            con = connection.getConnection();
            
            pst = con.prepareStatement("Select at.Name, a.AddressLine1, a.AddressLine2, a.City,sp.name, a.PostalCode, t.Name, c.FirstName, c.MiddleName, c.LastName, c.EmailAdress, c.Phone, c.Password\n" +
                                        "from contact as c INNER JOIN\n" +
                                        "address as a on c.AddressID = a.AddressID INNER JOIN\n" +
                                        "addresstype as at on a.AddressTypeID = at.AddressTypeID INNER JOIN\n" +
                                        "stateprovince as sp on a.StateProvinceID = sp.StateProvinceID INNER JOIN\n" +
                                        "title as t on c.TitleID=t.TitleID\n" +
                                        "where c.EmailAdress=? and c.Password=?;");
            pst.setString(1, user.getUser_email());
            pst.setString(2, user.getUser_password());
            rs = pst.executeQuery();
            String str = null;
            while(rs.next())
                str = rs.getString(1);
            vPersonalInformation.jLabelAddressType.setText(str);
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(2);
            vPersonalInformation.jLabelAddressLine1.setText(str);
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(3);
            vPersonalInformation.jLabelAddressLine2.setText(str);
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(4);
            vPersonalInformation.jLabelCity.setText(str);
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(5);
            vPersonalInformation.jLabelStateProvince.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(6);
            vPersonalInformation.jLabelPostalCode.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(7);
            vPersonalInformation.jLabelTitle.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(8);
            vPersonalInformation.jLabelFirstName.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(9);
            vPersonalInformation.jLabelMiddleName.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(10);
            vPersonalInformation.jLabelLastName.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(11);
            vPersonalInformation.jLabelEmail.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(12);
            vPersonalInformation.jLabelPhoneNumber.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(13);
            vPersonalInformation.jLabelPassword.setText(str);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }     
        vPersonalInformation.setLocationRelativeTo(null);
           vPersonalInformation.setVisible(true);
    }
    
    public MainView getMainWindow() {
        return mainW;
    }
    
    private void addListeners() {
        vPersonalInformation.jButtonReturn.addActionListener(this);
        vPersonalInformation.jButtonExit.addActionListener(this);
        vPersonalInformation.jButtonEdit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Edit":
                //calls editpersonalinformation and closes the window
                EditPersonalInformationController EditPIcontroller = new EditPersonalInformationController(session,user);
                vPersonalInformation.dispose();
                break;
            case "Exit":
                vPersonalInformation.dispose();
                break;
            case "Return":
                //close current window and open main (previous one)
                Controller Maincontroller = new Controller(session,user);
                vPersonalInformation.dispose();
                break;
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }
        

    }
}