/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victor
 */
public class CelluleDeGrille {
    
    private Jeton jetonCourant;
    
    private boolean avoirTrouNoir;
    
    private boolean avoirDesintegrateur;
    
    
    public CelluleDeGrille() {
        
        avoirTrouNoir = false;
        
        avoirDesintegrateur = false;
        
        jetonCourant = null;
        
    }
    
    public boolean presenceJeton() {
        
        if (jetonCourant == null) {
            return false;
            
        } else {
            return true;
        }   
    }
    
    public boolean affecterJeton (Jeton jeton) {
        if (jetonCourant == null) {
            
            jetonCourant = jeton;
            
            
            
            return true;
            
        } else {
            System.out.println("La cellule est occupée");
            return false;
        }
    }
    
    
    public String lireCouleurDuJeton() {
        
        if (jetonCourant == null) {
            
            return "vide";
            
            
        } else  { 
            return jetonCourant.lireCouleur();
            
        }
        
    }
    
}
