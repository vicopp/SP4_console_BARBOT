/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
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

    
    public Jeton prendreUnJeton(){
       int ligne;
       int colonne;
       
       Scanner sc = new Scanner(System.in);
       System.out.println("Dans quelle ligne souhaites tu prendre ton jeton ?");
       ligne = sc.nextInt();
       System.out.println("Dans quelle colonne souhaites tu prendre ton jeton ?");
       colonne = sc.nextInt();
       
       
       Jeton temp = plateau.recupererJeton(ligne, colonne);
       
       plateau.supprimerJeton(ligne, colonne);
       plateau.tasserColonne(colonne);
       
       return temp;
    }
    
    
     public void placerJeton(String couleur,Joueur joueurCourant){
         
            int colonne;
            
            do {
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Choisis la colonne, comprise entre 0 et 6, dans laquelle tu veux placer ton jeton");
                colonne = sc.nextInt(); 
               
                 if (colonne > 6) {
                  System.out.println("chiffre trop grand");
            
    
                } else if (plateau.colonneRemplie(colonne)) {
                    System.out.println("deja remplie");
                       
                } else if (colonne < 0 ) {
                System.out.println("chiffre trop petit");
                }    
            } while (colonne < 0 || colonne > 6 || plateau.colonneRemplie(colonne));
           
            int ligne = plateau.derniereL(colonne);
            
            if (plateau.presenceTrouNoir(ligne, colonne)){
                plateau.supprimerJeton(ligne, colonne);
                plateau.supprimerTrouNoir(ligne, colonne);
            
            } else if(plateau.presenceDesintegrateur(ligne, colonne)){
                
                joueurCourant.obtenirDesintegrateur();
                plateau.supprimerDesintegrateur(ligne, colonne);
                ligne = plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), colonne); 
                
            } else {
                ligne = plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), colonne);
            }
           
    }
   
    public void manipDesintegrateur(){ 
        
            Scanner sc = new Scanner(System.in);
            int ligne, colonne;
            
            do {
                System.out.println("choisis la colonne ou tu veux desintegrer le jeton");
                colonne = sc.nextInt();
                
                System.out.println("choisis la ligne ou tu veux desintegrer le jeton");
                ligne = sc.nextInt();
                
                
                if(joueurCourant.couleur == plateau.lireCouleurDuJeton(ligne,colonne)){
                    System.out.println("desintegre un jeton de l'autre joueur");
                }
            } while (joueurCourant.couleur == plateau.lireCouleurDuJeton(ligne,colonne));
            
            joueurCourant.utiliserDesintegrateur();
            plateau.supprimerJeton(ligne, colonne);
            plateau.tasserColonne(colonne);
    }
   
    
}
   
 
    
    


    

