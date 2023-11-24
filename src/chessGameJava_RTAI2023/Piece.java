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

}
