package plateau.properties;
import java.awt.Color;

import joueur.Joueur;
import plateau.Case;

public class Station extends Case {

    private Joueur proprietaire;
    private boolean estHypotheque = false;

    public Station(String name, int price, Color color) {
        super(name, price);
        setColor(color);
    }

    public boolean estHypotheque() {
        return estHypotheque;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    

}

