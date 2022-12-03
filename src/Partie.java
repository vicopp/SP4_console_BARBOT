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
    
    public void creerEtAffecterJeton(Joueur joueur1){

        if ("rouge".equals(joueur1.getCouleurJoueur())){  
            for (int i=0;i<31;i++){
                Jeton jeton = new Jeton ("rouge");
                joueur1.ajouterJeton(jeton);

            }         
        }

        if ("jaune".equals(joueur1.getCouleurJoueur())){

            for (int i=0;i<31;i++){
                Jeton jeton=new Jeton ("jaune");
                joueur1.ajouterJeton(jeton);
            }
        }
    }
    
    
    public void placerTrousNoirsEtDesintegrateurs() {
        Random L = new Random();
        Random C = new Random();
        for (int i = 0; i < 2; i++) {
            int ligne = L.nextInt(0, 6);
            int colonne = C.nextInt(0, 7);
            if (plateau.presenceTrouNoir(ligne, colonne) == false && plateau.presenceDesintegrateur(ligne, colonne) == false) {
                plateau.placerTrouNoir(ligne, colonne);
            } else {
                i -= 1;
            }
        }
         for (int j = 0; j < 3; j++) {
            int ligne = L.nextInt(0, 6);
            int colonne = C.nextInt(0, 7);
            if (plateau.presenceTrouNoir(ligne, colonne) == false && plateau.presenceDesintegrateur(ligne, colonne) == false) {
                plateau.placerTrouNoir(ligne, colonne);
                plateau.placerDesintegrateur(ligne, colonne);
            } else {
                j -= 1;
            }
        }
        for (int k = 0; k < 2; k++) {
            int ligne = L.nextInt(0, 6);
            int colonne = C.nextInt(0, 7);
            if (plateau.presenceDesintegrateur(ligne, colonne) == false) {
                plateau.placerDesintegrateur(ligne, colonne);
            } else {
                k -= 1;
            }
        }
    }
    public void initialiserPartie() {
        attriberCouleursAuxJoueurs();
        placerTrousNoirsEtDesintegrateurs();
        creerEtAffecterJeton(ListeJoueurs[0]);
        creerEtAffecterJeton(ListeJoueurs[1]);
        plateau.afficherGrilleSurConsole();
    }

    
    
    
    
}
