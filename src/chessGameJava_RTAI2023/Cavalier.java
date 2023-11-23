package chessGameJava_RTAI2023;

public class Cavalier extends Piece {

    private int id;

    /**
     * Constructeur de la classe Cavalier
     * @param c
     * @param pos
     * @param id
     */
    public Cavalier (Couleur c, int id) {
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
     * Fonction qui verifie si la piece peut aller a certaine position
     * @return
     */
    public boolean checkPos() {
    	return true;
    }
}