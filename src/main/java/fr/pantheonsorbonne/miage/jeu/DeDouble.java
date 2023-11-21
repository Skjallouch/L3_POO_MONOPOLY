package jeu;

public class DeDouble {
    private int valeurDe;
    private static final int VALEUR_MAX = 12;
    private static final int VALEUR_MIN_DE = 1;
    private static final int VALEUR_MAX_DE = 6;
    private static final int NB_LANCERS_DOUBLE_MAX = 3;
    protected int resultatDe;
    private boolean memeValeur;

    public DeDouble() {
        this.resultatDe = 0;
        this.valeurDe = 0;
        this.memeValeur = false;
    }

    public int getValeur() {
        return this.valeurDe;
    }

    public boolean memeValeur() {
        return memeValeur;
    }

    public int getResultatDe() {
        return resultatDe;
    }

    public void lancerDes() {
        // Lancer deux dés
        int de1 = (int) (Math.random() * (VALEUR_MAX_DE - VALEUR_MIN_DE + 1)) + VALEUR_MIN_DE;
        int de2 = (int) (Math.random() * (VALEUR_MAX_DE - VALEUR_MIN_DE + 1)) + VALEUR_MIN_DE;

        // Résultat et valeur du dé
        resultatDe = de1 + de2;
        valeurDe = Math.min(resultatDe, VALEUR_MAX);

        // Si les deux dés ont la même valeur
        memeValeur = de1 == de2;
    }

    public void lancerEtVerifierDes() {
        lancerDes();
        memeValeurDes();
    }

    public void memeValeurDes() {
        int nbLancersDoublesConsecutifs = 0; // Compteur de dés doubles consécutifs
        for (int i = 0; i < NB_LANCERS_DOUBLE_MAX; i++) {
            lancerDes();
            // Si les dés ont la même valeur
            if (memeValeur()) {
                nbLancersDoublesConsecutifs++;
            } else {
                nbLancersDoublesConsecutifs = 0; // Réinitialise le compteur s'il n'y a pas de doubles
            }
        }
        // Si le joueur a obtenu des dés doubles pendant trois lancers consécutifs
        if (nbLancersDoublesConsecutifs == NB_LANCERS_DOUBLE_MAX && memeValeur()) {
            // Prison.conditionPourAllerEnPrison(...); // Le joueur va en prison
        }
    }
}

   


    /* 
    public void avancerJoueur(Joueur joueur) {
        //position du joueur en fonction du résultat des dés
        joueur.avancer(resultatDe);
    };*/
    //on sait pas quoi faire avec 



/*Dans dedouble faut faire : 
 *modeliser le resultat des deux de pour faire avancer le joueur
 *si les deux dé ont la meme valeur on fait rejouer le joueur
 *si meme dédoubles 3 fois, go en prison
 */