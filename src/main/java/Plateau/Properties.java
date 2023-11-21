package plateau.properties;

import java.awt.Color;

import joueur.Joueur;
import plateau.Case;

public class Properties extends Case {

    private int[] tableauLoyer;
    private int nombreMaisons = 0;
    private boolean estHotel = false;
    private Joueur proprietaire = null;
    private int prixMaison;
    private boolean estHypotheque;

    public Properties(String name, int price, Color color, int[] tableauLoyer, int prixMaison) {
        super(name, price);
        setColor(color);
        this.tableauLoyer = tableauLoyer;
        this.prixMaison = prixMaison;
    }

    // "get" methods

    public int[] getTableauLoyer() {
        return tableauLoyer;
    }

    public int getNombreMaisons() {
        return nombreMaisons;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public int getLoyer() {
        if (this.estHotel())
            return tableauLoyer[5];
        return tableauLoyer[this.getNombreMaisons()];
    }

    public int getPrixRevente() {
        return this.price / 2;
    }

    // "is a" methods

    public boolean estHotel() {
        return estHotel;
    }

    public boolean estLibre() {
        return proprietaire == null;
    }

    public boolean estHypotheque() {
        return estHypotheque;
    }

    // "set" methods

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    // other methods

    public void vendreHotel() throws CannotSellException {
        if (!this.estHotel())
            throw new CannotSellException("Vous n'avez pas d'hotel sur ce terrain!");
        this.estHotel = false;
        this.getProprietaire().ajouterArgent(prixMaison / 2);
        this.nombreMaisons = 4;
    }

    public void vendreMaison() throws CannotSellException {
        if (this.getNombreMaisons() == 0)
            throw new CannotSellException("Vous n'avez pas de maison sur ce terrain!");
        this.getProprietaire().ajouterArgent(prixMaison / 2);
        this.nombreMaisons--;
    }

    public void hypothequerTerrain() {
        this.getProprietaire().ajouterArgent(this.getPrixRevente());
        estHypotheque = true;
    }

    public void leverHypotheque() {
        this.estHypotheque = false;
    }

}
