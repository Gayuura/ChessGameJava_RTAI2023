package chessGameJava_RTAI2023;

public abstract class Piece {
    private Couleur c;

    /**
     * Constructeur de la classe Piece
     * @param c
     * @param pos
     */
    public Piece(Couleur c) {
        this.c = c;
    }
    
    
    
    /**
     * Fonction setter de l'attrubut couleur
     * @param c
     */
    public void set_couleur(Couleur c) {
    	this.c = c;
    }
    
    
    
    /**
     * Fonction getter de l'attribut couleur
     * @return
     */
    public Couleur get_couleur() {
    	return this.c;
    }
    
    
    
    /**
     * Fonction getter de id
     * @return
     */
    public int get_id() {
    	return this.get_id();
    }

    
    
    public String toString() {
    	String res = " ";
    	if (this.getClass().getName().contains("Pion"))
			res = ("Pion");
		else if (this.getClass().getName().contains("Tour"))
			res = ("Tour");
		else if (this.getClass().getName().contains("Fou"))
			res = ("Fou");
		else if (this.getClass().getName().contains("Cavalier"))
			res = ("Cavalier");
		else if (this.getClass().getName().contains("Reine"))
			res = ("Reine");
		else if (this.getClass().getName().contains("Roi"))
			res = ("Roi");
    	
    	return res;
    }
}
