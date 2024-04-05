/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Connect;
import Model.User;
import View.EditPersonalInformationView;
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
public class EditPersonalInformationController implements ActionListener{
    
    //variables
    Session session;
    User user;
    
    private MessageView vMessage = null;
    private MainView vMain = null;
    private EditPersonalInformationView vEditPersonalInformation = null;
    private PersonalInformationView vPersonalInformation = null;
    
    private Connect connection = null;
    private Connection con = null;
    
    PreparedStatement pst = null;
    ResultSet rs;  
    
    //constructor
    public EditPersonalInformationController(Session sess, User us) {
        user = us;
        try {
            session = sess;
        } catch (HibernateException e) {
            vMessage.Message("error", e.getMessage());
        }
        
        vEditPersonalInformation = new EditPersonalInformationView();
        vMessage = new MessageView();
        vMain = new MainView();
        
        addListeners();

        
        
        try{
            
            //set connection and prepare statement to get information from the user
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
            
            //set current values of the user in the text fields:
            
            //combobox
            //rs = pst.executeQuery();
            String str = null;
            /*while(rs.next())
                str = rs.getString(1);
            vEditPersonalInformation.jTextField1.setSelectedItem(str);*/
            
            //str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(2);
            vEditPersonalInformation.jTextField2.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(3);
            vEditPersonalInformation.jTextField3.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(4);
            vEditPersonalInformation.jTextField4.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(5);
            vEditPersonalInformation.jTextField5.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(6);
            vEditPersonalInformation.jTextField6.setText(str);
            
            //combobox
            /*str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(7);
            vEditPersonalInformation.jTextField7.setSelectedItem(str);*/
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(8);
            vEditPersonalInformation.jTextField8.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(9);
            vEditPersonalInformation.jTextField9.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(10);
            vEditPersonalInformation.jTextField10.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(11);
            vEditPersonalInformation.jTextField11.setText(str);
            
            str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(12);
            vEditPersonalInformation.jTextField12.setText(str);
            
            //Password not showed
            /*str = null;
            rs = pst.executeQuery();
            while(rs.next())
                str = rs.getString(13);
            vEditPersonalInformation.jTextField13.setText(str);*/
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }     
        vEditPersonalInformation.setLocationRelativeTo(null);
        vEditPersonalInformation.setVisible(true);
    }
    
    public MainView getMainWindow() {
        return vMain;
    }
    
    private void addListeners() {
        vEditPersonalInformation.jButtonReturn.addActionListener(this);
        vEditPersonalInformation.jButtonExit.addActionListener(this);
        vEditPersonalInformation.jButtonSave.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Save":
                //change all data of the user and recharge personal information view
                try{
                    //query to update in the database:
                    
                    //first = check if there is a new address which is not in the database:
                    PreparedStatement pstaddress;
                    String straddress = null;

                    pstaddress = con.prepareStatement("SELECT a.AddressLine1, a.AddressLine2,a.City,sp.name,a.PostalCode \n" +
"                            FROM address as a INNER JOIN \n" +
"                            stateprovince as sp on a.StateProvinceID = sp.StateProvinceID\n" +
"                            WHERE a.AddressLine1=? and a.AddressLine2=? and a.City=? and sp.name=? and a.PostalCode=?;");
                    
                    String str1 = vEditPersonalInformation.jTextField2.getText(); //ad line 1
                    String str2 = vEditPersonalInformation.jTextField3.getText(); //ad line 2
                    String str3 = vEditPersonalInformation.jTextField4.getText(); //city
                    String strStateProvinceName = vEditPersonalInformation.jTextField5.getText(); //sp name
                    String str5 = vEditPersonalInformation.jTextField6.getText(); //postalcode
                    
                    pstaddress.setString(1, vEditPersonalInformation.jTextField2.getText());
                    pstaddress.setString(2, vEditPersonalInformation.jTextField3.getText());
                    pstaddress.setString(3, vEditPersonalInformation.jTextField4.getText());
                    pstaddress.setString(4, strStateProvinceName);
                    pstaddress.setString(5, vEditPersonalInformation.jTextField6.getText());
                                            
                    rs = pstaddress.executeQuery();
                    while(rs.next())
                        straddress = rs.getString(1);
                    
                    PreparedStatement pstsp;
                    String strsp = null;
                    
                    //pstsp = con.prepareStatement("SELECT StateProvinceID, Name FROM stateprovince WHERE Name = ?;");
                    pstsp = con.prepareStatement("SELECT StateProvinceID, Name FROM stateprovince WHERE Name = ?;");
                    pstsp.setString(1, strStateProvinceName);
                    
                    rs = pstsp.executeQuery();
                    while(rs.next())
                        strsp = rs.getString(1); // = sp id
                    
                    //if straddress = null -> there was no output from the query = new address
                    if(straddress == null){
                        /*pstaddress = con.prepareStatement("INSERT INTO address (AddressTypeID, AddressLine1, AddressLine2,City,StateProvinceID,PostalCode)\n" +
                                                            "VALUES(\n" +
                                                            "2" + //addresstype id def 2
                                                            "?,\n" +
                                                            "?,\n" +
                                                            "?,\n" +
                                                            "?,\n" +
                                                            "?\n" +
                                                            ");");*/
                        pstaddress = con.prepareStatement("INSERT INTO address (AddressTypeID, AddressLine1, AddressLine2,City,StateProvinceID,PostalCode) VALUES(\n" +
"                                                            2,\n" +
"                                                            ?,\n" +
"                                                            ?,\n" +
"                                                            ?,\n" +
"                                                            ?,\n" +
"                                                            ?);");
                        pstaddress.setString(1, vEditPersonalInformation.jTextField2.getText());
                        pstaddress.setString(2, vEditPersonalInformation.jTextField3.getText());
                        pstaddress.setString(3, vEditPersonalInformation.jTextField4.getText());
                        pstaddress.setString(4, strsp);
                        pstaddress.setString(5, vEditPersonalInformation.jTextField6.getText());
                        
                        //pstaddress.executeQuery();
                        pstaddress.executeUpdate();
                    }
                    //take addressid to insert into the contact
                    /*pstaddress = con.prepareStatement("SELECT a.AddressID, sp.name"
                            + "FROM address as a INNER JOIN "
                            + "stateprovince as sp on a.StateProvinceID = sp.StateProvinceID "
                            + "WHERE a.AddressLine1=? and a.AddressLine2=? and a.City=? and sp.name=? and a.PostalCode=?;");*/
                    pstaddress = con.prepareStatement("SELECT a.AddressID, sp.name \n" +
                                                        "FROM address as a INNER JOIN stateprovince as sp on a.StateProvinceID = sp.StateProvinceID \n" +
                                                        "WHERE a.AddressLine1=? and a.AddressLine2=? and a.City=? and sp.name=? and a.PostalCode=?;");
                    pstaddress.setString(1, vEditPersonalInformation.jTextField2.getText());
                    pstaddress.setString(2, vEditPersonalInformation.jTextField3.getText());
                    pstaddress.setString(3, vEditPersonalInformation.jTextField4.getText());
                    pstaddress.setString(4, vEditPersonalInformation.jTextField5.getText());
                    pstaddress.setString(5, vEditPersonalInformation.jTextField6.getText());
                    
                    straddress = null;
                    rs = pstaddress.executeQuery();
                    while(rs.next())
                        straddress = rs.getString(1); // = addressid
                    
                    //vEditPersonalInformation.jTextField4.setText(str);
                    //update contact:
                    /*pst = con.prepareStatement("UPDATE contact\n" +
                        "SET ModifiedDate = current_timestamp(),\n" +
                        "    FirstName = ?,\n" +
                        "    MiddleName = ?,\n" +
                        "    LastName = ?,\n" +
                        "    EmailAdress = ?,\n" +
                        "    Phone = ?,\n" +
                        "    AdditionalContactInfo = 'Additional Info updated'\n" +
                        "    AddressID = ?'\n" +
                        "where EmailAdress =? and Password =?;");*/
                    pst = con.prepareStatement ("UPDATE contact \n" +
                                                "	SET ModifiedDate = current_timestamp(),\n" +
                                                "	FirstName = ?,\n" +
                                                "	MiddleName = ?,\n" +
                                                "	LastName = ?,\n" +
                                                "	EmailAdress = ?,\n" +
                                                "	Phone = ?,\n" +
                                                "	AdditionalContactInfo = 'Additional Info updated', \n" +
                                                "	AddressID = ? where EmailAdress =? and Password =?;");
                    pst.setString(1, vEditPersonalInformation.jTextField8.getText()); //First Name
                    pst.setString(2, vEditPersonalInformation.jTextField9.getText()); //Middle Name
                    pst.setString(3, vEditPersonalInformation.jTextField10.getText()); //Last Name
                    pst.setString(4, vEditPersonalInformation.jTextField11.getText()); //Email
                    pst.setString(5, vEditPersonalInformation.jTextField12.getText()); //Phone
                    //pst.setString(6, vEditPersonalInformation.jTextField6.getText());
                    pst.setString(6, straddress); //addressid
                    pst.setString(7, user.getUser_email());
                    pst.setString(8, user.getUser_password());

                    //pst.executeQuery();
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "User Data changed");
                    
                    user.setUser_email(vEditPersonalInformation.jTextField11.getText());
                    user.setUser_name(vEditPersonalInformation.jTextField8.getText());
                   
                    //charge personal information view with new data:
                    vEditPersonalInformation.dispose();
                    PersonalInformationController PI_controller = new PersonalInformationController(session,user);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
                
                
                break;
            case "Exit":
                vEditPersonalInformation.dispose();
                break;
            case "Return":
                //close current window and open personalinformation (previous one)
                vMessage.Message("info", "Changes not saved. Returning to Personal Information");
                vEditPersonalInformation.dispose();
                PersonalInformationController PIcontroller = new PersonalInformationController(session,user);
                break;
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }
        

    }
}