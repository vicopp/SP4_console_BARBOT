package sp4_console_barbot;


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
    public String nom;
    public String couleur;
    private ArrayList <Jeton> reserveJetons = new ArrayList<>();
    private int nombreDesintegrateurs;
    
    
    public Joueur (String nom) {
        nom = nom;
        nombreDesintegrateurs = 0;
        
    }
    public void affecterCouleur(String Couleur) {
        
        couleur = Couleur;
        
    }
    
    public int getnombreDesintegrateur(){
        return nombreDesintegrateurs;
    }
    
    
    public int nombreDeJetons() {
        return reserveJetons.size();
    
        
    }
    
    public void ajouterJeton(Jeton nouvJeton) {
        
        reserveJetons.add(nouvJeton);
        
    }
    
    public Jeton jouerJeton() {
        Jeton temp = reserveJetons.get(0);
        reserveJetons.remove(0);
        
        return temp;        
    }
    
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs = nombreDesintegrateurs + 1;
    }
    
    public void utiliserDesintegrateur() {
        nombreDesintegrateurs = nombreDesintegrateurs - 1;
    }
    
      public String getCouleurJoueur(){
        return couleur;
    }
    
    
    
}   
