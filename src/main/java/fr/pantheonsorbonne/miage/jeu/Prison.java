package jeu;

import java.util.List;

import joueur.Joueur;
import joueur.JoueurAvance;
import plateau.properties.Properties;

public class Prison extends Joueur {

    private static final int COUT_LIBERATION_PRISON = 50;

    public Prison(String name, int porteMonnaie, int positionPlateau, List<Properties> properties, boolean enPrison) {
        super(name, porteMonnaie, positionPlateau, properties, enPrison);
    }

    public static void allerEnPrison(JoueurAvance joueurAvance, int nbLancersDoublesConsecutifs, boolean cartePrison, boolean goToJail, boolean jail) {
        if (nbLancersDoublesConsecutifs == 3 && joueurAvance.memeValeur()) {
            joueurAvance.setJail(true);
        }
        if (cartePrison) {
            joueurAvance.setJail(true);
        }
        if (goToJail && jail) {
            joueurAvance.setJail(true);
        }
    }

    public static int sortirDePrison(int porteMonnaie, boolean cartePrison, int doubleDe, int nbLancersDoublesConsecutifs, JoueurAvance joueurAvance) {
        if (nbLancersDoublesConsecutifs == 2 && joueurAvance.memeValeur()) {
            return joueurAvance.getPositionPlateau() + 1;
        }
        if (porteMonnaie > COUT_LIBERATION_PRISON) {
            return joueurAvance.getPositionPlateau() + 1;
        }
        if (cartePrison) {
            return joueurAvance.getPositionPlateau() + 1;
        }
        // Gérer le cas où aucune condition n'est satisfaite
        return joueurAvance.getPositionPlateau(); // ou autre valeur par défaut
    }
}


/* 
condition pour la prison:
En faisant trois doubles d'affilé ;
En tirant une carte "Allez en prison" ;
En atterrissant sur la case "Allez en prison".

condition pour en sortir:
Lancer les dés et obtenir un double ;
Payer 50 € (ou 5 000 F) ;
Utiliser une carte "vous êtes libéré de prison".

*/

