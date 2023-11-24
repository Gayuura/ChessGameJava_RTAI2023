package chessGameJava_RTAI2023;

public class Tour extends Piece {

    private int id;

    
    
    /**
     * Constructeur de la classe Tour
     * @param c
     * @param pos
     * @param id
     */
    public Tour (Couleur c, int id) {
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
     * @param depart
     * @param arrivee
     * @return
     */
    public boolean PositionPossible(Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	
    	
    	return true;
    }
}
