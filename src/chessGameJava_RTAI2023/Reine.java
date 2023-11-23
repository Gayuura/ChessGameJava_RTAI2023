package chessGameJava_RTAI2023;

public class Reine extends Piece {

    /**
     * Constructeur de la classe Reine
     * @param c
     * @param pos
     */
    public Reine(Couleur c, Position pos) {
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
