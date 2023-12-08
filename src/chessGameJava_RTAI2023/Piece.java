package chessGameJava_RTAI2023;

public class Piece implements Cloneable{
    private Couleur c;
    private Position pos;
    private int id;

    
    
    /**
     * Constructeur de la classe Piece
     * @param c
     * @param pos
     */
    public Piece(Couleur c, Position pos, int id) {
        this.c = c;
        this.pos = pos;
        this.id = id;
    }
    
    
    
    /**
     * Constructeur par default de la classe Piece
     */
    public Piece() {
    }
    
    
    
    /**
     * Fonction getter de l'attribut couleur
     * @return
     */
    public Couleur get_couleur() {
    	return this.c;
    }
    
    
    
    /**
     * Fonction setter de l'attribut couleur
     * @param c
     */
    public void set_couleur(Couleur c) {
    	this.c = c;
    }
    
    
    
    /**
     * Fonction getter de l'attribut pos
     */
    public Position get_pos() {
    	return this.pos;
    }
    
    
    
    /**
     * Fonction setter pour l'attribut pos
     * @param pos
     */
    public void set_pos(Position pos) {
    	this.pos = pos;
    }
    
    
    
    /**
     * Fonction getter de l'attribut id
     */
    public int get_id() {
    	return this.id;
    }
    
    
    
    @Override
    public Piece clone() {
        try {
            Piece clone = (Piece) super.clone();
            clone.set_pos(this.get_pos().clone());
            clone.c = this.c;  // La couleur est immuable, pas besoin de clonage profond
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
    
    
    
    //JUSTE POUR TESTER L'AFFICHAGE, A SUPPRIMER QUAND ON AURA L'INTERFACE GRAPHIQUE
    public String toString() {
    	String res = "";
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
