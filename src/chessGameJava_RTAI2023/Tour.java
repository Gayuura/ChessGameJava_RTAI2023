package chessGameJava_RTAI2023;

public class Tour extends Piece {

    
    
    /**
     * Constructeur de la classe Tour
     * @param c
     * @param pos
     */
    public Tour (Couleur c, Position pos) {
        super(c,pos);
    }
    
    
    
    /**
     * Fonction qui verifie si la piece peut aller a la position d'arrivée en verifiant le chemin qui doit etre parcouru
     * @param plateau
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean PositionPossible(Plateau plateau, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	boolean aucunePiece = true;
    	int i;
    	int xD = depart.get_x();
    	int yD = depart.get_y();
    	int xA = arrivee.get_x();
    	int yA = arrivee.get_y();
    	
    	if (plateau.estVide(plateau.get_plateau()[xA][yA]) || ((!plateau.estVide(plateau.get_plateau()[xA][yA]) && (plateau.get_plateau()[xA][yA].get_couleur() != plateau.get_plateau()[xD][yD].get_couleur())))){
	    	if (xA-xD == 0) {
	    		//Verifie un deplacement horizontal vers la droite
	    		if (yA-yD > 0) {
	    			i = yD + 1;
	    			while ((aucunePiece) && (i < yA)) {
	    				if (!plateau.estVide(plateau.get_plateau()[xA][i])) {
	    					aucunePiece = false;
	    				}
	    				i++;
	    			}
	    			if (aucunePiece) {
	    				possible = true;
	    			}
	    		}
	    		//Verifie un deplacement horizontal vers la gauche
	    		else if (yA-yD < 0) {
	    			i = yD - 1;
	    			while ((aucunePiece) && (i > yA)) {
	    				if (!plateau.estVide(plateau.get_plateau()[xA][i])) {
	    					aucunePiece = false;
	    				}
	    				i--;
	    			}
	    			if (aucunePiece) {
	    				possible = true;
	    			}
	    		}
	    	}
	    	
	
	    	else if (yA-yD == 0) {
	    		//Verifie un deplacement vertical vers le haut
	    		if (xA-xD > 0) {
	    			i = xD + 1;
	    			while ((aucunePiece) && (i < xA)) {
	    				if (!plateau.estVide(plateau.get_plateau()[i][yA])) {
	    					aucunePiece = false;
	    				}
	    				i++;
	    			}
	    			if (aucunePiece) {
	    				possible = true;
	    			}
	    		}
	    		//Verifie un deplacement vertical vers le bas
	    		if (xA-xD < 0) {
	    			i = xD - 1;
	    			while ((aucunePiece) && (i > xA)) {
	    				if (!plateau.estVide(plateau.get_plateau()[i][yA])) {
	    					aucunePiece = false;
	    				}
	    				i--;
	    			}
	    			if (aucunePiece) {
	    				possible = true;
	    			}
	    		}
	    	}
    	}
    	
    	return possible;
    }
}
