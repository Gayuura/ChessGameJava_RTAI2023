package chessGameJava_RTAI2023;

import java.util.ArrayList;

public class Joueur {

	private String nom;
	private Couleur couleur;
	
	//Liste des pieces disponibles en jeu
    private ArrayList<Piece> PieceDispo = new ArrayList<Piece>();
    
    //Liste des pieces qui ont été mangé
    private ArrayList<Piece> PieceMangee = new ArrayList<Piece>();
    
    
    
    /**
     * Constructeur de la classe Joueur
     * @param nom
     * @param couleur
     */
    public Joueur(String nom, Couleur couleur) {
    	this.nom = nom;
    	this.couleur = couleur;
    }

    
    
    /**
     * Fonction qui permet d'ajouter une piece a la liste "PieceDispo"
     * @param piece
     */
    public void AddPieceDispo(Piece piece) {
    	this.PieceDispo.add(piece);
    }
    
    
    
    /**
     * Fonction qui permet d'ajouter une piece a la liste "PieceMangee"
     * @param piece
     */
    public void AddPieceMangee(Piece piece) {
    	this.PieceMangee.add(piece);
    }
    
    
    
    /**
     * Fonction jouer() de la classe Joueur qui va verifier le chemin et la position d'arrivée grace a la methode "PositionPossible" et puis lancer la méthode jouer_un_tour() de la classe Jeu pour faire le deplacement
     */
    public void jouer() {

    }
}
