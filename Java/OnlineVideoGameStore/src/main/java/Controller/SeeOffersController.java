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
import View.SeeOffersView;
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
public class SeeOffersController implements ActionListener{
    
    //variables
    Session session;
    User user;
    Game game;
    
    private MessageView vMessage = null;
    private MainView vMain = null;
    private GameInformationView vGameInformation = null;
    private SeeOffersView vSeeOffers = null;
    
    private Connect connection = null;
    private Connection con = null;
    
    PreparedStatement pst = null;
    ResultSet rs;  
    
    //constructor
    public SeeOffersController(Session sess, User us) {
        user = us;
        try {
            session = sess;
        } catch (HibernateException e) {
            vMessage.Message("error", e.getMessage());
        }
        
        //init possible windows from current one
        vGameInformation = new GameInformationView();
        vMessage = new MessageView();
        vMain = new MainView();
        vSeeOffers = new SeeOffersView();
        
        try{
            //set connection and prepare statement to get information from the game
            connection = new Connect();
            con = connection.getConnection();
            
            String sql = "Select * from game;";
            String gameid = null, gamename = null, gamedescription = null, stdcost = null, lprice = null, stg = null, stgum = null, plt = null;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery("Select * from game;");
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
                DefaultTableModel tblModel = (DefaultTableModel)vSeeOffers.jTable.getModel();

                //add string array data into jtable
                tblModel.addRow(tbData);
            }
            
            
            

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }     
        
        
        addListeners();
        
        //frame visibility
        vSeeOffers.jLabelEmail.setText(user.getUser_email());
        vSeeOffers.jLabelUsername.setText(user.getUser_name());
        vSeeOffers.setLocationRelativeTo(null);
        vSeeOffers.setVisible(true);
    }
    
    public MainView getMainWindow() {
        return vMain;
    }
    
    private void addListeners() {
        vSeeOffers.jButtonReturn.addActionListener(this);
        vSeeOffers.jButtonExit.addActionListener(this);
        vSeeOffers.jButtonSearch.addActionListener(this);
        vSeeOffers.jButtonSearchFilteredOffers.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Exit":
                vSeeOffers.dispose();
                break;
            case "Return":
                //close current window and open personalinformation (previous one)
                vSeeOffers.dispose();
                Controller Maincontroller = new Controller(session,user);
                break;
            case "Search Filtered Offers":
                //JOptionPane.showMessageDialog(null, "This view has not been implemented");
                game = new Game(vSeeOffers.jTextGameName.getText());
                vSeeOffers.dispose();
                SeeFilteredController Fcontroller = new SeeFilteredController(session,user,game);
                break;
            case "Search":
                game = new Game(vSeeOffers.jTextGameName.getText());
                vSeeOffers.dispose();
                GameInformationController GIcontroller = new GameInformationController(session,user,game);
                //JOptionPane.showMessageDialog(null, "This view has not been implemented");
                break;
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }
        

    }
}