package Controller;

import Model.*;

import View.*;

import Controller.*;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;



public class ControllerLogin implements ActionListener{
    static Connect co;
    
    public ControllerLogin() throws SQLException{
        try {
            co = new Connect();
            System.out.println("Succesful Connection\n");
            
            vLogin = new Login();
            vMessage = new MessageView();
            
            addListeners();
            
            vLogin.setLocationRelativeTo(null); //center
            vLogin.setVisible(true); //show window

            co.Disconnect();
        } catch (SQLException e) {
            System.out.println("Error al operar con la BD: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el programa principal: " + e.getMessage());
        }
    }
    
    
    private void addListeners(){
        Login.jButtonExit.addActionListener(this);
        Login.jButtonConnect.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Connect":
                co = connect();
                if(co !=NULL){
                    vMessage.Message("info","Succesful Connection)");
                    vLogin.dispose();
                }
                break;
            case: "Exit":
                vLogin.dispose();
                System.exit(0);
                break;
        }
    }
}