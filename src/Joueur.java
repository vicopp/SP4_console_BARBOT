
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victor
 */
public class Joueur {
    private String nom;
    private String couleur;
    private ArrayList <Jeton> reserveJetons = new ArrayList();
    private int nombreDesintegrateurs;
    
    
    public Joueur (String nom) {
        nom = nom;
        nombreDesintegrateurs = 0;
        
    }
    public void affecterCouleur(String couleur) {
        
        couleur = couleur;
        
    }
    
    
    public int nombreDeJetons() {
        return reserveJetons.size();
    
        
    }
    
    
    
}
    
    
    
        
       
