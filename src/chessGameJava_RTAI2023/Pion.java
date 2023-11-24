package chessGameJava_RTAI2023;

public class Pion extends Piece {

    private int id;
    
    /**
     * Constructeur de la classe Pion
     * @param c
     * @param pos
     * @param id
     */
    public Pion (Couleur c, int id) {
        super(c);
        this.id = id;
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
    	int xD = depart.GetxByValue(depart.get_x());
    	int yD = depart.get_y();
    	int xA = arrivee.GetxByValue(arrivee.get_x());
    	int yA = arrivee.get_y();
    	
    	
    	if (couleur == Couleur.Blanc) {
    		//S'il avance diagonalement d'une case
    		if (((xA-xD == 1) || (xA-xD == -1)) && ((yA-yD == 1)) && (!plateau.estVide(plateau.get_plateau()[xA][yA]))) {
    			if (plateau.get_plateau()[xA][yA].get_couleur() == Couleur.Noir) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit de 2 cases
    		if ((yA-yD == 2) && (yD == 1) && (xA-xD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA-1])) {
    				possible = true;
    			}
    			if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit d'une seule case
    		if ((yA-yD == 1) && (xA-xD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
    				possible = true;
    			}
    		}
    	}
    	else if (couleur == Couleur.Noir) {
    		//S'il avance diagonalement d'une case
    		if (((xA-xD == 1) || (xA-xD == -1)) && ((yA-yD == -1)) && (!plateau.estVide(plateau.get_plateau()[xA][yA]))) {
    			if (plateau.get_plateau()[xA][yA].get_couleur() == Couleur.Blanc) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit de 2 cases
    		if ((yA - yD == -2) && (yD == 6) && (xA-xD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA+1])) {
    				possible = true;
    			}
    		}
    		//S'il avance tout droit d'une seule case
    		if((yA-yD == -1) && (xA-xD == 0)) {
    			if (plateau.estVide(plateau.get_plateau()[xA][yA])) {
    				possible = true;
    			}
    		}
    	}
    	
    	return possible;
    }
}
