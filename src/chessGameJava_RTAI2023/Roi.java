package chessGameJava_RTAI2023;

public class Roi extends Piece {

	
	
    /**
     * Constructeur de la classe Roi
     * @param c
     * @param pos
     */
    public Roi(Couleur c) {
        super(c);
    }

    
    
    /**
     * Fonction setter qui modifie l'attribut couleur
     * @param c
     */
    public void set_couleur(Couleur c) {
    	this.c = c;
    }
    
    
    
    /**
     * Fonction qui verifie si la piece peut aller a la position d'arrivée en verifiant le chemin qui doit etre parcouru
     * @param depart
     * @param arrivee
     * @return
     */
    public boolean PositionPossible(Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	
    	
    	return true;
    }
}
