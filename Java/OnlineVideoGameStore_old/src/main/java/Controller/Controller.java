
package Controller;

import Model.*;
import View.*;

public class Controller implements ActionListener{
    private Connect connect = null;
    private Login vLogin = null;
    private MainView vMain = null;
    
    public Controller(Connect connect){
        this.connect = connect;
        vLogin = new Login();
        vMain = new MainView();
        
        addListeners();
        
        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }
    
    private void addListeners(){
        vLogin.jButtonExit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "CloseMainWindow":
                vLogin.dispose();
                System.exit(0);
                break;
        }
    }
}
