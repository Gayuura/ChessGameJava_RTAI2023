package chessGameJava_RTAI2023;

public class Roi extends Piece {

    /**
     * Constructeur de la classe Roi
     * @param c
     * @param pos
     */
    public Roi(Couleur c, Position pos) {
        super(c, pos);
    }

    /**
     * Fonction qui verifie si la piece peut aller a certaine position
     * @return
     */
    public boolean checkPos() {
    	return true;
    }
}
