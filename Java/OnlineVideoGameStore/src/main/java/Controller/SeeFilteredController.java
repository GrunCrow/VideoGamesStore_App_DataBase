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
import View.SeeFilteredView;
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
public class SeeFilteredController implements ActionListener{
    
    //variables
    Session session;
    User user;
    Game game;
    
    private MessageView vMessage = null;
    private MainView vMain = null;
    private GameInformationView vGameInformation = null;
    private SeeFilteredView vSeeFiltered = null;
    
    private Connect connection = null;
    private Connection con = null;
    
    PreparedStatement pst = null;
    ResultSet rs;  
    
    //constructor
    public SeeFilteredController(Session sess, User us, Game ga) {
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
        vSeeFiltered = new SeeFilteredView();
        
        try{
            //set connection and prepare statement to get information from the game
            connection = new Connect();
            con = connection.getConnection();
            
            //query         
            String gameid = null, gamename = null, gamedescription = null, stdcost = null, lprice = null, stg = null, stgum = null, plt = null;
            
            // 1 ? = game name
            // 2 ? = minprix
            // 3 ? = maxprix
            
            //check if user introduced max prix
            String Maxprix = game.getMaxPrix();
            if (game.getMaxPrix() == null || "".equals(game.getMaxPrix())){ //no max prix -> check just from min and name as default minprix = 0
                pst = con.prepareStatement("Select * from game where name LIKE ? and StandardCost>?;");
                // 1 ? = game name
                // 2 ? = minprix
            }else{ //there is a max prix
                pst = con.prepareStatement("Select * from game where name LIKE ? and StandardCost>? and StandardCost<?;");
                // 1 ? = game name
                // 2 ? = minprix
                // 3 ? = maxprix
                pst.setString(3,game.getMaxPrix());
            }
            
            //set game to look for and minprix (default will be 0)
            pst.setString(1, "%" + game.getGame_name() + "%");
            pst.setString(2,game.getMinPrix());

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
                DefaultTableModel tblModel = (DefaultTableModel)vSeeFiltered.jTable.getModel();

                //add string array data into jtable
                tblModel.addRow(tbData);
            }
            

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }     
        
        
        addListeners();
        
        //frame visibility
        vSeeFiltered.jLabelEmail.setText(user.getUser_email());
        vSeeFiltered.jLabelUsername.setText(user.getUser_name());
        vSeeFiltered.setLocationRelativeTo(null);
        vSeeFiltered.setVisible(true);
    }
    
    public MainView getMainWindow() {
        return vMain;
    }
    
    private void addListeners() {
        vSeeFiltered.jButtonReturn.addActionListener(this);
        vSeeFiltered.jButtonExit.addActionListener(this);
        vSeeFiltered.jButtonSearch.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Exit":
                vSeeFiltered.dispose();
                break;
            case "Return":
                //close current window and open personalinformation (previous one)
                vSeeFiltered.dispose();
                Controller Maincontroller = new Controller(session,user);
                break;
            case "Search":
                //get info that we want to filter and introduce it on game object
                String GameName = vSeeFiltered.jTextGameName.getText();
                game.setGame_name(GameName);
                game.setMinPrix(vSeeFiltered.jTextPriceMin.getText());
                game.setMaxPrix(vSeeFiltered.jTextPriceMax.getText());
                vSeeFiltered.dispose();
                
                //recall window with new information to filter
                SeeFilteredController Filteredcontroller = new SeeFilteredController(session,user,game);
                //JOptionPane.showMessageDialog(null, "This view has not been implemented");
                break;
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }
        

    }
}