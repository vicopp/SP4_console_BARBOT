/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victor
 */
public class PlateauDeJeu {
    
    CelluleDeGrille[][] grille = new CelluleDeGrille [6][7];
    
    public PlateauDeJeu() {
        
        for (int i =0; i<6; i++) {
            for (int j =0 ;j<7;j++) {
            
            grille[i][j] = new CelluleDeGrille();
        }
        }
        
    }
    public int ajouterJetonDansColonne(Jeton jeton, int colonne) {
        for (int i=0 ; i<6 ; i++) {
            if (grille[i][colonne].presenceJeton() != true) {
            
            grille[i][colonne].affecterJeton(jeton);
            return i;
            }
        }
        return 0;
        
    }
    
    public boolean grilleRemplie() {
        
        for (int i=0; i<6; i++) {
            
            for (int j = 0; j<7; j++) {
            if (grille [i][j].jetonCourant == null) {
                return false;
            }
            
        }
            
        }
        return true;
        
    }
    
    public void afficherGrilleSurConsole() {
        
        for (int i = 0; i<6; i++) {
        
        for (int j =0 ; j<7 ; j++) {
            if (j==6) {
                
                System.out.println(grille[i][j]);
                
            } else {
                
                System.out.println(grille[i][j] + " ");
                
            }
            
        }
    }
        
    }
    
    public boolean presenceJeton(int ligne, int colonne) {
        
        return grille [ligne][colonne].presenceJeton();
        
    }
    public String lireCouleurDuJeton(int ligne, int colonne) {
        return grille [ligne][colonne].lireCouleurDuJeton();
    }
    
    
    public boolean etreGagnantePourCouleur(String couleur) {
        
        int compteur = 0;
        // ligne
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (couleur == grille[i][j].lireCouleurDuJeton()
                        && couleur == grille[i][j + 1].lireCouleurDuJeton()
                        && couleur == grille[i][j + 2].lireCouleurDuJeton()
                        && couleur == grille[i][j + 3].lireCouleurDuJeton()) {
                    

                    return true; //ligne gagnante

                }

            }

        }
        //colonne
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (couleur == grille[i][j].lireCouleurDuJeton()
                        && couleur == grille[i + 1][j].lireCouleurDuJeton()
                        && couleur == grille[i + 2][j].lireCouleurDuJeton()
                        && couleur == grille[i + 3][j].lireCouleurDuJeton()) {
                    
                    return true; //colonne gagnante
                }
            }
        }

        //diagonnale montante
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (couleur == grille[i][j].lireCouleurDuJeton()
                        && couleur == grille[i + 1][j + 1].lireCouleurDuJeton()
                        && couleur == grille[i + 2][j + 2].lireCouleurDuJeton()
                        && couleur == grille[i + 3][j + 3].lireCouleurDuJeton()) {
                    return true;
                }
            }

        }
        //diagonale descandante
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (couleur == grille[i][j].lireCouleurDuJeton()
                        && couleur == grille[i - 1][j + 1].lireCouleurDuJeton()
                        && couleur == grille[i - 2][j + 2].lireCouleurDuJeton()
                        && couleur == grille[i - 3][j + 3].lireCouleurDuJeton()) {
                    return true;
                }
            }

        }
        return false;
    }

    public void tasserColonne(int colonne) {
        for (int i=5; i>=1; i--) {
            
            if (grille[i][colonne].jetonCourant == null) {
                
                grille[i][colonne].jetonCourant = grille[i-1][colonne].jetonCourant;
                
                grille[i-1][colonne].jetonCourant = null;
                
            }
            
        }
        
    }
    
}
