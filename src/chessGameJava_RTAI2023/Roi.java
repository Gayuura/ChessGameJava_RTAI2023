package chessGameJava_RTAI2023;

public class Roi extends Piece {

	
	
    /**
     * Constructeur de la classe Roi
     * @param c
     * @param pos
     */
    public Roi(Couleur c, Position pos) {
        super(c,pos);
    }
    
    
    
    /**
     * Fonction qui applique la regle Roque
     * @param plateau
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean RegleRoque(Plateau plateau, Position depart, Position arrivee) {

    	boolean Vide = true;
    	int xD = depart.get_x();
    	int yD = depart.get_y();
    	int xA = arrivee.get_x();
    	int yA = arrivee.get_y();
    	
    	//Si la position de depart concerne le Roi Blanc
    	if ((xD == 0) && (yD == 4) && (plateau.get_plateau()[xD][yD].getClass().getName().contains("Roi")))  {
    		//Si la position d'arrivee concerne la Tour Blanche à droite
    		if ((xA == 0) && (yA == 7) && (plateau.get_plateau()[xA][yA].getClass().getName().contains("Tour"))) {
    			for (int i = yD+1; i < yA; i++) {
    				if (!plateau.estVide(plateau.get_plateau()[xD][i])) {
    					Vide = false;
    				}
    			}
    		}
    		//Si la position d'arrivee concerne la Tour Blanche à gauche
    		else if ((xA == 0) && (yA == 0) && (plateau.get_plateau()[xA][yA].getClass().getName().contains("Tour"))) {
    			for (int i = yD-1; i > yA; i--) {
    				if (!plateau.estVide(plateau.get_plateau()[xD][i])) {
    					Vide = false;
    				}
    			}
    		}
    	}
    	//Si la position de depart concerne le Roi Noir
    	else if ((xD == 7) && (yD == 4) && (plateau.get_plateau()[xD][yD].getClass().getName().contains("Roi")))  {
    		//Si la position d'arrivee concerne la Tour Noire à droite
    		if ((xA == 7) && (yA == 7) && (plateau.get_plateau()[xA][yA].getClass().getName().contains("Tour"))) {
    			for (int i = yD+1; i < yA; i++) {
    				if (!plateau.estVide(plateau.get_plateau()[xD][i])) {
    					Vide = false;
    				}
    			}
    		}
    		//Si la position d'arrivee concerne la Tour Noire à gauche
    		else if ((xA == 7) && (yA == 0) && (plateau.get_plateau()[xA][yA].getClass().getName().contains("Tour"))) {
    			for (int i = yD-1; i > yA; i--) {
    				if (!plateau.estVide(plateau.get_plateau()[xD][i])) {
    					Vide = false;
    				}
    			}
    		}
    	}
    	
    	return Vide;
    }
    
    
    
    /**
     * Fonction qui verifie si la piece peut aller a la position d'arrivée en verifiant le chemin qui doit etre parcouru
     * @param plateau
     * @param JAdverse
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean PositionPossible(Plateau plateau, Joueur JAdverse, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	
    	int xD = depart.get_x();
    	int yD = depart.get_y();
    	int xA = arrivee.get_x();
    	int yA = arrivee.get_y();
    	
    	Piece aux = plateau.get_plateau()[xA][yA];
    	
    	

	    if ( (plateau.estVide(plateau.get_plateau()[xA][yA])) || ((!plateau.estVide(plateau.get_plateau()[xA][yA]) && (plateau.get_plateau()[xA][yA].get_couleur() != plateau.get_plateau()[xD][yD].get_couleur()))) ){
	    	
	    	plateau.get_plateau()[xA][yA] = plateau.get_plateau()[xD][yD];
	    	plateau.get_plateau()[xA][yA].set_pos(arrivee);
    		plateau.get_plateau()[xD][yD] = null;
    		
	    	//Verifie le deplacement devant et derriere
	    	if ((Math.abs(xA - xD) == 1) && (yA-yD == 0)) {
	    		if (!Jeu.echec(plateau, JAdverse, arrivee)) {
	    			possible = true;
	    		}
	    	}
	    	//Verifie le deplacement a droite et a gauche
	    	else if ((xA - xD == 0) && (Math.abs(yA-yD) == 1)) {
	    		if (!Jeu.echec(plateau, JAdverse, arrivee)) {
	    			possible = true;
	    		}
	    	}
	    	//Verifie le deplacement en diagonal
	    	else if ((Math.abs(yA-yD) == 1) && (Math.abs(xA-xD) == 1)) {
	    		if (!Jeu.echec(plateau, JAdverse, arrivee)) {
	    			possible = true;
	    		}
	    	}
	    	
	    		
	    		
	    	plateau.get_plateau()[xD][yD] = plateau.get_plateau()[xA][yA];
	    	plateau.get_plateau()[xD][yD].set_pos(depart);
    		plateau.get_plateau()[xA][yA] = aux;
	    }
    	
    	return possible;
    }
}
