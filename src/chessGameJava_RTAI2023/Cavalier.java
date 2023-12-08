package chessGameJava_RTAI2023;

public class Cavalier extends Piece {



	/**
	 * Constructeur de la classe Cavalier
	 * @param c
	 * @param pos
	 * @param id
	 */
    public Cavalier (Couleur c, Position pos, int id) {
        super(c,pos,id);
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
    	int xD = depart.get_x();
    	int yD = depart.get_y();
    	int xA = arrivee.get_x();
    	int yA = arrivee.get_y();
    	
    	if (plateau.estVide(plateau.get_plateau()[xA][yA]) || ((!plateau.estVide(plateau.get_plateau()[xA][yA]) && (plateau.get_plateau()[xA][yA].get_couleur() != plateau.get_plateau()[xD][yD].get_couleur())))){
    		//Verifie le deplacement en L (2 cases puis 1 case)
    		if ((Math.abs(xA - xD) == 2) && Math.abs(yA - yD) == 1) {
    			possible = true;
    		}
    		
    		//Verifie le deplacement en L (1 case puis 2 cases)
    		if ((Math.abs(xA - xD) == 1) && Math.abs(yA - yD) == 2) {
    			possible = true;
    		}
    	}
    	
    	return possible;
    }
}