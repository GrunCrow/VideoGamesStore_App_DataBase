/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.SQLException;

/**
 *
 * @author albam
 */
public class Check {
    public Check() throws SQLException{
        Connect con = new Connect();
        
        if(con.getConnection() != null){
            System.out.println("Succesful Connection");
        }
        else{
            System.out.println("Failed Connection");
        }
        
    }
}
