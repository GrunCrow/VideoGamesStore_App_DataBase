/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author albam
 */
public class ConsoleView {
    void vistaConsolaLogin(String str){
        System.out.print(str);
    };
    
    void vistaConsolaLogin(String str, String error){
        System.out.print(str);
        System.out.print("\n");
        System.out.print(error);
    };
}
