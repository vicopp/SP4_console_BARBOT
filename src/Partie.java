/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
import java.util.Scanner;      

/**
 *
 * @author victor
 */
public class Partie {
    
    private Joueur [] ListeJoueurs = new Joueur [2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau = new PlateauDeJeu ();
    
    
    public Partie (Joueur joueur1, Joueur joueur2) {
        
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        
        
    }
    
    
    public void attriberCouleursAuxJoueurs () {
        
        Random r = new Random();
        int n = r.nextInt(1);
        if (n == 0) {
            
            ListeJoueurs[0].affecterCouleur("jaune");
            ListeJoueurs[1].affecterCouleur("rouge");
            
        } else {
            ListeJoueurs[0].affecterCouleur("rouge");
            ListeJoueurs[1].affecterCouleur("jaune");
            
        }
        
        
        
        
        
        
    }
    
    
    
    
    
}
