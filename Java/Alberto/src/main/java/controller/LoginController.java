/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.ConnectionDB;
import view.LoginView;
import view.MainWindow;
import view.MessageView;

/**
 *
 * @author usuario
 */
public class LoginController implements ActionListener {

    
    private LoginView vLogin;
    private ConnectionDB connection = null;
    private MessageView vMessage = null;
    private MainWindow mainW = null;
    private boolean connectionOK = false;

    public LoginController() {
        //connection = c;
        vLogin = new LoginView();
        vMessage = new MessageView();
        mainW = new MainWindow();
        addListener();

        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }
    
    
    public MainWindow getMainWindow() {
        return mainW;
    }

    private void addListener() {
        vLogin.Connect.addActionListener(this);
        vLogin.Exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Connect":
                connectionOK = connect();
                if (connectionOK) {
                    vLogin.dispose();
                    mainW.setLocationRelativeTo(null);
                    mainW.setVisible(true);
                    

                }
                break;
            case "Exit":
                vLogin.dispose();
                break;
            default:
                vMessage.Message("error", "Unknown button (You shouldn't see that)");
        }

    }

    private boolean connect() {

        boolean result = false;
        try {
            String Server = (String) vLogin.Server.getSelectedItem();
            String IP = vLogin.IP.getText();
            String Service = vLogin.DB.getText();
            String User = vLogin.User.getText();
            String Pass = new String(vLogin.Pass.getPassword());
            Pass = "ISDD_003"; 
            connection = new ConnectionDB(Server, IP, Service, User, Pass);
            result = true;
            vMessage.Message("info", "Conection Succesful");
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            vMessage.Message("error", "Check User or Password...\n" + e.getMessage());

        }

        return result;
    }
    
    public ConnectionDB getConnection(){
        return connection;
    }

}
