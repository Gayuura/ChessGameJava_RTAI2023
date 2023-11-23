package chessGameJava_RTAI2023;

public class Reine extends Piece {

    /**
     * Constructeur de la classe Reine
     * @param c
     * @param pos
     */
    public Reine(Couleur c) {
        super(c);
    }

    
    
    /**
     * Fonction setter qui modifie l'attribut couleur
     * @param c
     */
    public void set_couleur(Couleur c) {
    	this.c = c;
    }
    
    
    
    /**
     * Fonction qui verifie si la piece peut aller a certaine position
     * @return
     */
    public boolean checkPos() {
    	return true;
    }
}
