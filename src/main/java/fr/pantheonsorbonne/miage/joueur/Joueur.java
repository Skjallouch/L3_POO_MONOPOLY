package joueur;
import java.util.List;

import plateau.properties.DejaAchete;
import plateau.properties.Properties;
import plateau.Start;

public class Joueur {
    private String name;
    public double porteMonnaie;
    private int positionPlateau;
    private List<Properties> properties;
    private static boolean enPrison;
    private int nombreTours=0;

    public Joueur(String name, int porteMonnaie, int positionPlateau, List<Properties> properties, boolean enPrison) {
        this.name = name;
        this.porteMonnaie = porteMonnaie;
        this.positionPlateau = positionPlateau;
        this.properties = properties;
        Joueur.enPrison = enPrison; 
    }

    // Getters
    public String getName() { //le nom du joueur
        return name;
    }

    public static int getPorteMonnaie() { //combien il a d'argent
        return porteMonnaie;
    }

    public int getPositionPlateau() { //position du joueur dans le plateau
        return positionPlateau;
    }

    public List<Properties> getProperties() { //combien le joueur a de propriétés
        return properties;
    }

    public static boolean getEnPrison(){ // Si le joueur est en prison (oui/non)
        return enPrison;
    }

    public int getNombreTours() {
        return nombreTours;
    }


    // Setters (si nécessaire)

    // Méthodes additionnelles
    public void ajouterArgent(int montant) {
        this.porteMonnaie += montant;
    }

    public void payer(double montant) throws PasAssezArgentException {
        if (Joueur.getPorteMonnaie() < montant) throw new PasAssezArgentException ("Vous n'avez pas assez d'argent pour cette action!");
        this.porteMonnaie -= montant;
    }

    public void getStartingBonus() {
        this.ajouterArgent(Start.RECEIVE_MONEY);
    }

    public void deplacerSurPlateau(int nouvellePosition, boolean avancer) {
        if (nouvellePosition < this.positionPlateau && avancer) {
            nombreTours++;
            this.getStartingBonus();
        }
        this.positionPlateau = nouvellePosition;
    }

    public void deplacerNombreCases(int nombreCases, boolean avancer) {
        if (avancer) {
            if (this.positionPlateau + nombreCases > 40) {
                nombreTours++;
                this.getStartingBonus();
            }
            this.positionPlateau = (this.positionPlateau + nombreCases)%40;
        }
        else {
            if (this.positionPlateau < nombreCases) {
                this.positionPlateau = 40 + this.positionPlateau - nombreCases;
            }
            else {
                this.positionPlateau -= nombreCases;
            }
        }
    }

    public void transfererProprietes (Joueur gagnant) {
        for (Properties proprieteATransferer : this.getProperties()) {
            gagnant.ajouterPropriete(proprieteATransferer);
        }
    }

    public void payerLoyer(Properties propriete) throws PasAssezArgentException {

        if (Joueur.getPorteMonnaie() < propriete.getLoyer()) {
            this.transfererProprietes(propriete.getProprietaire());
            throw new PasAssezArgentException ("Vous n'avez pas assez d'argent pour payer le loyer donc vous avez perdu!");
        }
        this.payer(propriete.getLoyer());
        if (!propriete.estHypotheque()) {
            propriete.getProprietaire().ajouterArgent(propriete.getLoyer());
        }
    }

    public void ajouterPropriete(Properties propriete) {
        this.properties.add(propriete);
        propriete.setProprietaire(this);
    }

    public void acheterPropriete(Properties propriete) throws PasAssezArgentException{
        if (Joueur.getPorteMonnaie() < propriete.getPrice()) throw new PasAssezArgentException("Vous ne pouvez pas acheter ce terrain!");
        this.payer(propriete.getPrice());
        this.ajouterPropriete(propriete);
    }

    public void removePropriete(Properties propriete) {
        this.properties.remove(propriete);
        propriete.setProprietaire(null);
    }

    public void racheterProprieteHypothequee(Properties propriete) throws PasAssezArgentException, DejaAchete {
        double prix = 1.1 * propriete.getPrixRevente(); //prixRevente + 10%
        if (Joueur.getPorteMonnaie() < prix) throw new PasAssezArgentException ("Vous ne pouvez pas racheter cette propriete!");
        if (!propriete.estHypotheque()) throw new DejaAchete("La propriété n'est pas hypothéquée!");
        this.payer(prix);
        propriete.leverHypotheque();
    }

    public void declarerPerte() {
        // méthode pour déclarer que le joueur a perdu
        // qu'est-ce qu'on va faire ? on supprimer toutes les informations avec "= null" ? 
    }
    //Je crois que l'ancien étudiant a mis une méthode gameOver

    public void setPositionPlateau(int nouvellePosition) {
    }

}





//Faire un position plyaer pour savoir sa position et pouvoir avancer