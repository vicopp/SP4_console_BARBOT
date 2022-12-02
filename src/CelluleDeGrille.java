/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victor
 */
public class CelluleDeGrille {
    
    public Jeton jetonCourant;
    
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
            
            activerTrouNoir();
            
            
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
    
    public boolean placerTrouNoir () {
        
        if (avoirTrouNoir == false ) {
            
            avoirTrouNoir = true;
            
            System.out.println("Placement trou noir");
            
            return true;
        }
        return false;
    }
    
    public void supprimerTrouNoir () { 
        
        avoirTrouNoir = false;
    
    
    }
    
    public boolean presenceTrouNoir () {
        
        if (avoirTrouNoir == false) {
            
            return false;
            
        } else {
            
            return true;
        }
        
        
    }
    
    
    public Jeton recupererJeton() {
        
        Jeton StockJetonCourant;
        StockJetonCourant = jetonCourant;
        jetonCourant = null;
        
        return StockJetonCourant;
    }
    
    
    public void supprimerJeton() {
       
        jetonCourant = null;
        
    }
    
    public boolean presenceDesintegrateur() {
        
        return avoirDesintegrateur;
      
    }
    
    public void placerDesintegrateur() {
        
        avoirDesintegrateur = true;
        
    }
    
    public void supprimerDesintegrateur () {
        
        avoirDesintegrateur = false;
       
    }
    
    
    public boolean activerTrouNoir() {
        
        if (avoirTrouNoir == true) {
            
            jetonCourant = null;
            
            avoirTrouNoir = false;
            
            System.out.println("activation d'un trou noir");
            return true; 
            
            
        } else {
            System.out.println ("absence de trou noir");
            
            return false;
        }
        
        
    }
    
    
    @Override
    public String toString (){
        
        if (lireCouleurDuJeton() == "jaune") {
            return "J";
        }
        if (lireCouleurDuJeton() == "rouge") {
            return "R";
        }
        if (avoirDesintegrateur) {
            System.out.print ("D");
        } else if (avoirTrouNoir) {
            System.out.print("@");
        }
        
        return ".";
    }
    
    
    
}    
            
            
       