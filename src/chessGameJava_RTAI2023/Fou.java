package chessGameJava_RTAI2023;

public class Fou extends Piece {
    private int id;

    /**
     * Constructeur de la classe Fou
     * @param c
     * @param pos
     * @param id
     */
    public Fou(Couleur c, int id) {
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
