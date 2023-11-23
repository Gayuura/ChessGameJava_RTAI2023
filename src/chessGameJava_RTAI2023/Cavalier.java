package chessGameJava_RTAI2023;

public class Cavalier extends Piece {

    private int id;

    /**
     * Constructeur de la classe Cavalier
     * @param c
     * @param pos
     * @param id
     */
    public Cavalier (Couleur c, Position pos, int id) {
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