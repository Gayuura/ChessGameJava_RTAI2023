package chessGameJava_RTAI2023;

public class Cavalier extends Piece {

    private int id;

    
    
    /**
     * Constructeur de la classe Cavalier
     * @param c
     * @param id
     */
    public Cavalier (Couleur c, int id) {
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
    public static boolean PositionPossible(Couleur couleur, Position depart, Position arrivee) {
    	
    	boolean possible = false;
    	
    	
    	return true;
    }
}