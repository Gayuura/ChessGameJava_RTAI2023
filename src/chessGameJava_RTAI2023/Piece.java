package chessGameJava_RTAI2023;

public abstract class Piece {
    protected Couleur c;
    protected Position pos;

    /**
     * Constructeur de la classe Piece
     * @param c
     * @param pos
     */
    public Piece(Couleur c, Position pos) {
        this.c = c;
        this.pos = pos;
    }

    /**
     * Fonction qui verifie si le chemin peut etre pris par la piece en parametre
     * @param depart
     * @param arrivee
     * @return
     */
    public boolean verifChemin(Position depart, Position arrivee) {
    	return true;
    }
}
