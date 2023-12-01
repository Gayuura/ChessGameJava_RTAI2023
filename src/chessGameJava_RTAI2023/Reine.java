package chessGameJava_RTAI2023;

public class Reine extends Piece {

    private int id;
	
    /**
     * Constructeur de la classe Reine
     * @param c
     */
    public Reine(Couleur c, int id) {
        super(c);
        this.id = id;
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
     * @param plateau
     * @param couleur
     * @param depart
     * @param arrivee
     * @return
     */
    public static boolean PositionPossible(Plateau plateau, Couleur couleur, Position depart, Position arrivee) {
    	
    	
    	if ((Fou.PositionPossible(plateau, couleur, depart, arrivee)) || (Tour.PositionPossible(plateau, couleur, depart, arrivee))) {
    		return true;
    	}
    	
    	return false;
    }
}
