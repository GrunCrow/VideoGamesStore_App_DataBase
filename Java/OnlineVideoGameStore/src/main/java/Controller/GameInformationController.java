/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Connect;
import Model.Game;
import Model.User;
import View.GameInformationView;
import View.MainView;
import View.MessageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author albam
 */
    //constructor

public class GameInformationController implements ActionListener{
    
    //variables
    Session session;
    User user;
    Game game;
    
    private MessageView vMessage = null;
    private MainView vMain = null;
    private GameInformationView vGameInformation = null;
    
    private Connect connection = null;
    private Connection con = null;
    
    PreparedStatement pst = null;
    ResultSet rs;  
    
    //constructor
    public GameInformationController(Session sess, User us, Game ga) {
        user = us;
        game = ga;
        try {
            session = sess;
        } catch (HibernateException e) {
            vMessage.Message("error", e.getMessage());
        }
        
        //init possible windows from current one
        vGameInformation = new GameInformationView();
        vMessage = new MessageView();
        vMain = new MainView();
        
        try{
            //set connection and prepare statement to get information from the game
            connection = new Connect();
            con = connection.getConnection();
            
            //query         
            String gameid = null, gamename = null, gamedescription = null, stdcost = null, lprice = null, stg = null, stgum = null, plt = null;
            //String sql = "Select * from game where name LIKE ?;";
            pst = con.prepareStatement("Select * from game where name LIKE ?;");
            pst.setString(1, "%" + game.getGame_name() + "%");
            //String string = "%" + game.getGame_name() + "%";
            
            rs = pst.executeQuery();
            while(rs.next()){
                gameid = rs.getString("GameID");
                gamename = rs.getString("Name");
                gamedescription = rs.getString("Description");
                stdcost = rs.getString("StandardCost");
                lprice = rs.getString("ListPrice");
                stg = rs.getString("Storage");
                stgum = rs.getString("StorageUnitMeasureCode");
                plt = rs.getString("PlatformID");
                
                //string array for astore data intro the jtable
                String tbData[] = {gamename, gamedescription,stdcost,lprice,stg,stgum,plt};
                DefaultTableModel tblModel = (DefaultTableModel)vGameInformation.jTable.getModel();

                //add string array data into jtable
                tblModel.addRow(tbData);
            }
            
            
            

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }     
        
        
        addListeners();
        
        //frame visibility
        vGameInformation.jLabelEmail.setText(user.getUser_email());
        vGameInformation.jLabelUsername.setText(user.getUser_name());
        vGameInformation.setLocationRelativeTo(null);
        vGameInformation.setVisible(true);
    }
    
    public MainView getMainWindow() {
        return vMain;
    }
    
    private void addListeners() {
        vGameInformation.jButtonReturn.addActionListener(this);
        vGameInformation.jButtonExit.addActionListener(this);
        vGameInformation.jButtonAddToCart.addActionListener(this);
        vGameInformation.jButtonSeeReviews.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Exit":
                vGameInformation.dispose();
                break;
                
            case "Return":
                //close current window and open personalinformation (previous one)
                vGameInformation.dispose();
                Controller Maincontroller = new Controller(session,user);
                break;
                
            case "See Game Reviews":
                JOptionPane.showMessageDialog(null, "This view has not been implemented");
                break;
            case "Add to Cart":
                JOptionPane.showMessageDialog(null, "This view has not been implemented");
                break;
                
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }
        

    }
}