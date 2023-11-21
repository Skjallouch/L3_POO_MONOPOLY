package joueur;

import jeu.DeDouble;

public class JoueurAvance extends DeDouble{
    
    public void joueurAvance(int nbLancersDoublesConsecutifs){
        int playerMove =0;
        if(nbLancersDoublesConsecutifs<3){
            playerMove =resultatDe();
        }
        System.out.println("Le joueur se déplace de " + playerMove + " cases.");
    }
    public void setJail(boolean b) {
        //jsp quoi mettre dedans a voir ms si j'enleve je crois y a un truc qui marche plus :/
    }   
    /*public void positionJoueur( int resultatDe, int positionPlateau, boolean lancerDes) {
        if (lancerDes){
            positionPlateau+= resultatDe;
            for (int i =0; i<Board.lengthBoard; i++){
                cases[i]= cases[i+resultatDe];
            }
        }
    }*/ //peut etre inutile car j'ai ajouté une méthode dans Board pour avoir la position du joueur
}

//faire un truc pour recuperer position du joueur de la classe joueur peut etre
