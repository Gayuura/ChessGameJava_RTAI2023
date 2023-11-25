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
     * Fonction qui verifie si la piece peut aller a la position d'arrivée en verifiant le chemin qui doit etre parcouru
     * @param couleur
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean PositionPossible(Couleur couleur, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	
    	
    	return true;
    }
}
