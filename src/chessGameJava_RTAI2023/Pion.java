package chessGameJava_RTAI2023;

public class Pion extends Piece {
    
    
    
    /**
     * Constructeur de la classe Pion
     * @param c
     * @param pos
     */
    public Pion (Couleur c, Position pos) {
        super(c,pos);
    }
    
    
    
    /**
     * Fonction qui verifie si la piece peut aller a la position d'arrivée en verifiant le chemin qui doit etre parcouru
     * @param plateau
     * @param PionPremDepla
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean PositionPossible(Plateau plateau, Boolean PionPremDepla, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	int xD = depart.get_x();
    	int yD = depart.get_y();
    	int xA = arrivee.get_x();
    	int yA = arrivee.get_y();
    	
    	//Soit la case d'arrivée a une piece du camp opposé
    	if (plateau.get_plateau()[xD][yD].get_couleur() == Couleur.Blanc) {
    		//S'il avance diagonalement d'une case
    		if (((yA-yD == 1) || (yA-yD == -1)) && ((xA-xD == 1)) && (!plateau.estVide(plateau.get_plateau()[xA][yA]))) {
    			if (plateau.get_plateau()[xA][yA].get_couleur() == Couleur.Noir) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit de 2 cases
    		if (PionPremDepla) {
	    		if ((xA-xD == 2) && (yA-yD == 0)) {
	    			if (plateau.estVide(plateau.get_plateau()[xA-1][yA])) {
	    				if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
		    				possible = true;
		    			}
	    			}
	    			
	    		}
    		}
    		//S'il avance tout droit d'une seule case
    		if ((xA-xD == 1) && (yA-yD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
    				possible = true;
    			}
    		}
    	}
    	else if (plateau.get_plateau()[xD][yD].get_couleur() == Couleur.Noir) {
    		//S'il avance diagonalement d'une case
    		if (((yA-yD == 1) || (yA-yD == -1)) && ((xA-xD == -1)) && (!plateau.estVide(plateau.get_plateau()[xA][yA]))) {
    			if (plateau.get_plateau()[xA][yA].get_couleur() == Couleur.Blanc) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit de 2 cases
    		if (PionPremDepla) {
	    		if ((xA-xD == -2) && (yA-yD == 0)) {
	    			if (plateau.estVide(plateau.get_plateau()[xA+1][yA])) {
	    				if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
		    				possible = true;
		    			}
	    			}
	    			
	    		}
    		}
    		//S'il avance tout droit d'une seule case
    		if((xA-xD == -1) && (yA-yD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
    				possible = true;
    			}
    		}
    	}
    	
    	return possible;
    }
}
