package chessGameJava_RTAI2023;

public abstract class Piece {
    protected Couleur c;

    /**
     * Constructeur de la classe Piece
     * @param c
     * @param pos
     */
    public Piece(Couleur c) {
        this.c = c;
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
