package chessGameJava_RTAI2023;

public class Plateau {
    private Position coord;
    private Piece [][] plateau = new Piece[8][8];

    /**
     * Fonction qui va creer, initialiser et placer les pieces sur le plateau
     */
    public void initialiser() {   
    	
    	
    	
    	//Création et Placement des Pions Blancs et Noirs
    	Pion PionBlanc = new Pion(Couleur.Blanc,0);
    	plateau[1][0] = PionBlanc;
    	Pion PionNoir = new Pion(Couleur.Noir,0);
    	plateau[6][0] = PionNoir;
    	for (int i = 1; i < 8; i++) {
    		PionBlanc.set_id(i);
    		plateau[1][i] = PionBlanc;
    		
    		PionNoir.set_id(i);
    		plateau[6][i] = PionNoir;
    	}
    	
    	
    	//Création et Placement des Tours Blanches
    	Tour TourBlanche = new Tour(Couleur.Blanc,0);
    	plateau[0][0] = TourBlanche;
    	TourBlanche.set_id(1);;
    	plateau[0][7] = TourBlanche;
    	
    	//Création et Placement des Cavaliers Blancs
    	Cavalier CavalierBlanc = new Cavalier(Couleur.Blanc,0);
    	plateau[0][1] = CavalierBlanc;
    	CavalierBlanc.set_id(1);
    	plateau[0][6] = CavalierBlanc;
    	
    	//Création et Placement des Fous Blancs
    	Fou FouBlanc = new Fou(Couleur.Blanc,0);
    	plateau[0][2] = FouBlanc;
    	FouBlanc.set_id(1);
    	plateau[0][5] = FouBlanc;
    	
    	//Création et Placement des Tours Noires
    	Tour TourNoire = new Tour(Couleur.Noir,0);
    	plateau[7][0] = TourNoire;
    	TourNoire.set_id(1);
    	plateau[7][7] = TourNoire;
    	
    	//Création et Placement des Cavaliers Noirs
    	Cavalier CavalierNoir = new Cavalier(Couleur.Noir,0);
    	plateau[7][1] = CavalierNoir;
    	CavalierNoir.set_id(1);
    	plateau[7][6] = CavalierNoir;
    	
    	//Création et Placement des Fous Noirs
    	Fou FouNoir = new Fou(Couleur.Noir,0);
    	plateau[7][2] = FouNoir;
    	FouNoir.set_id(1);
    	plateau[7][5] = FouNoir;
    	
    	//Création et Placement des Reines Blanche et Noire
    	Reine reine = new Reine(Couleur.Blanc);
    	plateau[0][3] = reine;
    	reine.set_couleur(Couleur.Noir);
    	plateau[7][3] = reine;
    	
    	//Création et Placement des Rois Blanc et Noir
    	Roi roi = new Roi(Couleur.Blanc);
    	plateau[0][4] = roi;
    	roi.set_couleur(Couleur.Noir);
    	plateau[7][4] = roi;
    	

    	
    }
}
