/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

/**
 *
 * @author albam
 */
public interface ActionListener {
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
