package jeu;

import java.util.List;

import joueur.Joueur;
import joueur.JoueurAvance;
import plateau.properties.Properties;

public class Prison extends Joueur {

    public Prison(String name, int porteMonnaie, int positionPlateau, List<Properties> properties, boolean enPrison) {
        super(name, porteMonnaie, positionPlateau, properties, enPrison);
    }
    public static void conditionPourAllerEnPrison(JoueurAvance joueurAvance, int nbLancersDoublesConsecutifs, boolean cartePrison, boolean goToJail, boolean jail) {
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
    public static int conditionPourSortirDePrison(int porteMonnaie, boolean cartePrison, int doubleDe, int nbLancersDoublesConsecutifs, JoueurAvance joueurAvance, int POS_JAIL) {
        if (nbLancersDoublesConsecutifs == 2 && joueurAvance.memeValeur()) {
            // JoueurAvance.getOutJail(); 
            return POS_JAIL + 1;
        }
        if (porteMonnaie > 50) {
            porteMonnaie -= 50;
            return POS_JAIL + 1;
        }
        if (cartePrison) {
            return POS_JAIL + 1;
        }
        // Gérer le cas où aucune condition n'est satisfaite
        throw new IllegalArgumentException("Aucune condition pour sortir de prison n'est satisfaite.");
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

