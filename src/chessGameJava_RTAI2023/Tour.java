package chessGameJava_RTAI2023;

public class Tour extends Piece {

    private int id;

    
    
    /**
     * Constructeur de la classe Tour
     * @param c
     * @param id
     */
    public Tour (Couleur c, int id) {
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
     * @param couleur
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean PositionPossible(Plateau plateau, Couleur couleur, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	boolean aucunePiece = true;
    	int i;
    	int xD = depart.get_x();
    	int yD = depart.GetYByValue(depart.get_y());
    	int xA = arrivee.get_x();
    	int yA = arrivee.GetYByValue(arrivee.get_y());
    	
    	if (plateau.estVide(plateau.get_plateau()[xA][yA]) || ((!plateau.estVide(plateau.get_plateau()[xA][yA]) && (plateau.get_plateau()[xA][yA].get_couleur() != couleur)))){
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
