package chessGameJava_RTAI2023;

public class Reine extends Piece {
	
    /**
     * Constructeur de la classe Reine
     * @param c
     * @param pos
     */
    public Reine(Couleur c, Position pos) {
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
    	
    	
    	if ((Fou.PositionPossible(plateau, depart, arrivee)) || (Tour.PositionPossible(plateau, depart, arrivee))) {
    		return true;
    	}
    	
    	return false;
    }
}
