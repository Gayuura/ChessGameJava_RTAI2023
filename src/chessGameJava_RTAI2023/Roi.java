package chessGameJava_RTAI2023;

public class Roi extends Piece {

	
	
    /**
     * Constructeur de la classe Roi
     * @param c
     */
    public Roi(Couleur c) {
        super(c);
    }
    
    
    
    /**
     * Fonction setter qui modifie l'attribut couleur
     * @param c
     */
    public void set_couleur(Couleur c) {
    	super.set_couleur(c);
    }
    
    
    
    /**
     * Fonction qui applique la regle Roque
     * @param plateau
     * @param depart
     * @param arrivee
     * @return
     */
    public static Piece [][] RegleRoque(Plateau plateau, Position depart, Position arrivee) {

    	boolean Vide = true;
    	Piece [][] aux = plateau.get_plateau();
    	int xD = depart.get_x();
    	int yD = depart.GetYByValue(depart.get_y());
    	int xA = arrivee.get_x();
    	int yA = arrivee.GetYByValue(arrivee.get_y());
    	
    	//Si la position de depart concerne le Roi Blanc
    	if ((xD == 0) && (yD == 4) && (plateau.get_plateau()[xD][yD].getClass().getName().contains("Roi")))  {
    		//Si la position d'arrivee concerne la Tour Blanche à droite
    		if ((xA == 0) && (yA == 7) && (plateau.get_plateau()[xA][yA].getClass().getName().contains("Tour"))) {
    			for (int i = yD+1; i < yA; i++) {
    				if (!plateau.estVide(plateau.get_plateau()[xD][i])) {
    					Vide = false;
    				}
    			}
    			if (Vide = true) {
    				aux[xD][yA-1] = aux[xD][yD];
    				aux[xD][yD] = null;
    				aux[xD][yD+1] = aux[xA][yA];
    				aux[xA][yA] = null;
    			}
    		}
    		//Si la position d'arrivee concerne la Tour Blanche à gauche
    		else if ((xA == 0) && (yA == 0) && (plateau.get_plateau()[xA][yA].getClass().getName().contains("Tour"))) {
    			for (int i = yD-1; i > yA; i--) {
    				if (!plateau.estVide(plateau.get_plateau()[xD][i])) {
    					Vide = false;
    				}
    			}
    			if (Vide = true) {
    				aux[xD][yD-2] = aux[xD][yD];
    				aux[xD][yD] = null;
    				aux[xD][yD-1] = aux[xA][yA];
    				aux[xA][yA] = null;
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
    			if (Vide = true) {
    				aux[xD][yA-1] = aux[xD][yD];
    				aux[xD][yD] = null;
    				aux[xD][yD+1] = aux[xA][yA];
    				aux[xA][yA] = null;
    			}
    		}
    		//Si la position d'arrivee concerne la Tour Noire à gauche
    		else if ((xA == 7) && (yA == 0) && (plateau.get_plateau()[xA][yA].getClass().getName().contains("Tour"))) {
    			for (int i = yD-1; i > yA; i--) {
    				if (!plateau.estVide(plateau.get_plateau()[xD][i])) {
    					Vide = false;
    				}
    			}
    			if (Vide = true) {
    				aux[xD][yD-2] = aux[xD][yD];
    				aux[xD][yD] = null;
    				aux[xD][yD-1] = aux[xA][yA];
    				aux[xA][yA] = null;
    			}
    		}
    	}
    	
    	return aux;
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
    	
    	int xD = depart.get_x();
    	int yD = depart.GetYByValue(depart.get_y());
    	int xA = arrivee.get_x();
    	int yA = arrivee.GetYByValue(arrivee.get_y());
    	
    	if (!Jeu.echec(plateau, xA, yA)) {
	    	if (plateau.estVide(plateau.get_plateau()[xA][yA]) || ((!plateau.estVide(plateau.get_plateau()[xA][yA]) && (plateau.get_plateau()[xA][yA].get_couleur() != couleur)))){
	    		//Verifie le deplacement devant et derriere
	    		if ((Math.abs(xA - xD) == 1) && (yA-yD == 0)) {
	    			possible = true;
	    		}
	    		//Verifie le deplacement a droite et a gauche
	    		if ((xA - xD == 0) && (Math.abs(yA-yD) == 1)) {
	    			possible = true;
	    		}
	    	}
    	}
    	else {
    		System.out.println("Votre Roi sera en echec a cette position !");
    	}
    	
    	return possible;
    }
}
