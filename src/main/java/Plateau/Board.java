package plateau;

import plateau.properties.Properties;
import plateau.properties.Station;
import plateau.properties.Utilities;

public class Board { 
    public static final int NUM_SQUARES = 40;
    public static final int POS_G0 = 0;
    public static final int POS_JAIL = 10;
    public static final int POS_FREE_PARKING = 15;
    public static final int POS_GO_TO_JAIL = 20;

    public static final Board[] TABLEAU_BOARD = boardDivision();
    private static final Color COLORLESS = Color.WHITE;
    private static final Color BROWN = new Color(139, 69, 19); // Brown
    private static final Color PINK = new Color(255, 182, 193); // Pink
    private static final Color LIGHT_BLUE = new Color(173, 216, 230); // Light Blue
    private static final Color ORANGE = Color.ORANGE;
    private static final Color RED = Color.RED;
    private static final Color YELLOW = Color.YELLOW;
    private static final Color GREEN = Color.GREEN;
    private static final Color BLUE = Color.BLUE;
    private Case[] cases = new Case[NUM_SQUARES];

    public static Board[] boardDivision() {
        Board[] boards = new Board[NUM_SQUARES];
        for (int i = 0; i < NUM_SQUARES; i++) {
            boards[i] = new Board();
        }
        return boards;
    }
    
    
    //le board est divisé pour avoir chacunes des cases, chaque case a un name, 
    //price, color et une rente qui peut augmenter
    private void initializeProperties() {
            
        cases[0] = new Start ("Case Départ", 0,COLORLESS);
        cases[1] = new Properties ("Boulevard de BelleVille",60, BROWN, new int[] { 2, 4, 10, 30, 90, 160 }, 50 );
        cases[2] = new CommunityChest ( "Caisse de Communalité", 0, COLORLESS);
        cases[3] = new Properties( "Rue LeCourbe",60, BROWN,  new int[] { 4, 8, 20, 60, 180, 320 }, 50);
        cases[4] = new Taxes ("Impôts sur le Revenu", 200,COLORLESS);
        cases[5] = new Station ( "Gare de Montparnasse", 200,COLORLESS);
        cases[6] = new Properties("Rue de Vaugirard", 100, LIGHT_BLUE, new int[] { 6, 12, 30, 90, 270, 400 }, 50);
        cases[7] = new Chance ("Chance",0,COLORLESS);
        cases[8] = new Properties("Rue de Courcelles", 100, LIGHT_BLUE, new int[] { 2, 12, 30, 90, 270, 400 }, 50);
        cases[9] = new Properties("Avenue de la République", 120, LIGHT_BLUE, new int[] { 8, 16, 40, 100, 300, 450}, 50);
        cases[10] = new Jail ("Jail, simple visite",0,COLORLESS);
        cases[11] = new Properties("Boulevard de la Vilette", 140, PINK, new int[] { 10, 20, 50, 150, 450, 625 }, 100);
        cases[12] = new Utilities("Compagnie de distribution d'électricité",150,COLORLESS);
        cases[13] = new Properties("Avenue de Neuilly", 140, PINK, new int[] { 10, 20, 50, 150, 450, 625 }, 100);
        cases[14] = new Properties("Rue de Paradis", 160, PINK, new int [] { 12, 24, 60, 180, 500, 700}, 100);
        cases[15] = new Station("Gare de Lyon", 200,COLORLESS);
        cases[16] = new Properties("Avenue Mozart", 180, ORANGE, new int[] { 14, 28, 70, 200, 550,750 }, 100);
        cases[17] = new CommunityChest("Caisse de communauté",0,COLORLESS);
        cases[18] = new Properties("Boulevard Saint-Michel", 180,ORANGE, new int []{ 14, 28, 70, 200, 550, 750}, 100);
        cases[19] = new Properties("Place Pigalle", 200, ORANGE, new int[] { 16, 32, 80, 220, 600, 800 }, 100);
        cases[20] = new Parking ("Parc Gratuit", 0,COLORLESS);
        cases[21] = new Properties("Avenue Matignon", 220,RED, new int[] { 18, 36, 90, 250, 700, 875 }, 150);
        cases[22] = new Chance ("Chance", 0, COLORLESS);
        cases[23] = new Properties("Boulevard Malesherbes", 220,RED, new int[] { 18, 36, 90, 250, 700,875 }, 150);
        cases[24] = new Properties("Avenue Henri-Martin", 240,RED, new int[] { 20, 40, 100, 300, 750,925 }, 150);
        cases[25] = new Station ("Gare du Nord", 0,COLORLESS);
        cases[26] = new Properties("Faubourg Saint-Honoré", 260, YELLOW, new int[] { 22, 44, 110, 330, 800,975 }, 150);
        cases[27] = new Properties ("Place de la Bourse", 260,YELLOW, new int[] { 22, 44, 110, 330, 800,975 }, 150);
        cases[28] = new Utilities("Compagnie de distribution des eaux",150,COLORLESS);
        cases[29] = new Properties("Rue de la Fayette", 280,YELLOW, new int[] { 24, 48, 120, 360, 850,1025 }, 150);
        cases[30] = new GoToJail("Allez en prison bye bye !",0,COLORLESS);
        cases[31] = new Properties("Avenue de Breteuil", 300, GREEN, new int[] { 26, 52, 130, 390, 900, 1100 }, 200);
        cases[32] = new Properties("Avenue Foch", 300,GREEN, new int[] { 26, 52, 130, 390, 900,1100 }, 200);
        cases[33] = new CommunityChest ("Caisse de Communauté",0,COLORLESS);
        cases[34] = new Properties ("Boulevard des Capucines", 320,GREEN, new int[] { 28, 56, 150, 450, 1000, 1200 }, 200);
        cases[35] = new Station ("Gare de Saint-Lazare", 200,COLORLESS);
        cases[36] = new Chance ("Chance",0,COLORLESS);
        cases[37] = new Properties ("Avenue des Champs - Elysées", 350, BLUE, new int[] { 35, 70, 175, 500, 1100, 1300 }, 200);
        cases[38] = new Taxes ("Taxe de Luxe", 100,COLORLESS);
        cases[39] = new Properties("Rue de la Paix", 400, BLUE, new int[] { 50, 100, 200, 600, 1400,1700 }, 200);  

    }


    private Properties createProperty(String name, int price, Color color, int[] rent, int buildingCost) {
        return new Properties(name, price, color, rent, buildingCost);
    }

    public Board() {
        initializeProperties();
    }
}