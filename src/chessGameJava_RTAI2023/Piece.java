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
     * Fonction getter de l'attribut couleur
     * @return
     */
    public Couleur get_couleur() {
    	return this.c;
    }

}
