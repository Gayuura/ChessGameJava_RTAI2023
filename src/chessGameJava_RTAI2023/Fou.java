package chessGameJava_RTAI2023;

public class Fou extends Piece {
    private int id;

    /**
     * Constructeur de la classe Fou
     * @param c
     * @param pos
     * @param id
     */
    public Fou(Couleur c, Position pos, int id) {
        super(c, pos);
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
