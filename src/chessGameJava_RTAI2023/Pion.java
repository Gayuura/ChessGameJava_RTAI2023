package chessGameJava_RTAI2023;

public class Pion extends Piece {

    private int id;

    /**
     * Constructeur de la classe Pion
     * @param c
     * @param pos
     * @param id
     */
    public Pion (Couleur c, Position pos, int id) {
        super(c, pos);
        this.id = id;
    }

    /**
     * Fonction qui verifie si la piece peut aller a cette position
     * @param pos
     * @return
     */
    public boolean checkPos(Position pos) {
    	return true;
    }
}
