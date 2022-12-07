/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_barbot;

import java.util.Scanner;

/**
 *
 * @author victor
 */
public class SP4_console_BARBOT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           
        Joueur J1 = new Joueur  ("Line");
        Joueur J2 = new Joueur  ("Vico");
     
        Partie partie = new Partie (J1,J2);
        partie.initialiserPartie();
        partie.lancerPartie();
     
        
        
        
        
                
    }
    
}
