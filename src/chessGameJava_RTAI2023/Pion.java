package chessGameJava_RTAI2023;

public class Pion extends Piece {

    private int id;
    
    
    
    /**
     * Constructeur de la classe Pion
     * @param c
     * @param id
     */
    public Pion (Couleur c, int id) {
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
     * @param PionPremDepla
     * @param couleur
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean PositionPossible(Plateau plateau, Boolean PionPremDepla, Couleur couleur, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	int xD = depart.get_x();
    	int yD = depart.GetYByValue(depart.get_y());
    	int xA = arrivee.get_x();
    	int yA = arrivee.GetYByValue(arrivee.get_y());
    	
    	
    	if (couleur == Couleur.Blanc) {
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
	    				possible = true;
	    			}
	    			if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
	    				possible = true;
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
    	else if (couleur == Couleur.Noir) {
    		//S'il avance diagonalement d'une case
    		if (((yA-yD == 1) || (yA-yD == -1)) && ((xA-xD == -1)) && (!plateau.estVide(plateau.get_plateau()[xA][yA]))) {
    			if (plateau.get_plateau()[xA][yA].get_couleur() == Couleur.Blanc) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit de 2 cases
    		if ((xA - xD == -2) && (xD == 6) && (yA-yD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA+1])) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit d'une seule case
    		if((xA-xD == -1) && (yA-yD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
    				possible = true;
    			}
    		}
    	}
		Jeu.promotionPion(plateau, depart, arrivee, couleur);
    	
    	return possible;
    }
}
