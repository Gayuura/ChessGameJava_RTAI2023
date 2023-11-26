package chessGameJava_RTAI2023;

public class Fou extends Piece {
    private int id;

    
    
    /**
     * Constructeur de la classe Fou
     * @param c
     * @param id
     */
    public Fou(Couleur c, int id) {
        super(c);
        this.id = id;
    }
    
    
    
    /**
     * Fonction getter pour l'attribut id
     * @return
     */
    public int get_id() {
    	return this.id;
    }
    
    
    
    /**
     * Fonction setter de l'attribut id
     * @param id
     */
    public void set_id(int id) {
    	this.id = id;
    }

    
    
/**
 * Fonction qui verifie si la piece peut aller a la position d'arrivée en verifiant le chemin qui doit etre parcouru
 * @param plateau
 * @param couleur
 * @param depart
 * @param arrivee
 * @return
 */
    public static boolean PositionPossible(Plateau plateau, Couleur couleur, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	boolean aucunePiece = true;
    	int i;
    	int j;
    	int xD = depart.get_x();
    	int yD = depart.GetYByValue(depart.get_y());
    	int xA = arrivee.get_x();
    	int yA = arrivee.GetYByValue(arrivee.get_y());
    	
    	
    	if (plateau.estVide(plateau.get_plateau()[xA][yA]) || ((!plateau.estVide(plateau.get_plateau()[xA][yA]) && (plateau.get_plateau()[xA][yA].get_couleur() != couleur)))){
    		//Verifie que c'est un deplacement diagonal
    		if (Math.abs(xA-xD) == Math.abs(yA-yD)) {
    		
	    		//Verifie le deplacement diagonal devant
		    	if (xA-xD > 0) {
		    		//Vers la droite
		    		if (yA-yD > 0) {
			    		i = xD + 1;
			    		j = yD + 1;
			    		while ((aucunePiece) && (i < xA) && (j < yA)) {
			    			if (!plateau.estVide(plateau.get_plateau()[i][j])) {
		    					aucunePiece = false;
		    				}
			    			i++;
			    			j++;
			    		}
			    		if (aucunePiece) {
		    				possible = true;
		    			}
		    		}
		    		//Vers la gauche
		    		else if (yA-yD < 0) {
		    			i = xD + 1;
		    			j = yD - 1;
		    			while ((aucunePiece) && (i < xA) && (j > yA)) {
			    			if (!plateau.estVide(plateau.get_plateau()[i][j])) {
		    					aucunePiece = false;
		    				}
			    			i++;
			    			j--;
			    		}
		    			if (aucunePiece) {
		    				possible = true;
		    			}
		    		}
		    	}
		    	//Verifie le deplacement diagonal derriere
		    	else if (xA-xD < 0) {
		    		//Vers la droite
		    		if (yA-yD > 0) {
		    			i = xD - 1;
		    			j = yD + 1;
		    			while ((aucunePiece) && (i > xA) && (j < yA)) {
			    			if (!plateau.estVide(plateau.get_plateau()[i][j])) {
		    					aucunePiece = false;
		    				}
			    			i--;
			    			j++;
			    		}
		    			if (aucunePiece) {
		    				possible = true;
		    			}
		    		}
		    		//Vers la gauche
		    		if (yA-yD < 0) {
		    			i = xD - 1;
		    			j = yD - 1;
		    			while ((aucunePiece) && (i > xA) && (j > yA)) {
			    			if (!plateau.estVide(plateau.get_plateau()[i][j])) {
		    					aucunePiece = false;
		    				}
			    			i--;
			    			j--;
			    		}
		    			if (aucunePiece) {
		    				possible = true;
		    			}
		    		}
		    	}
    		}
    	}
    	
    	return possible;
    }
}
