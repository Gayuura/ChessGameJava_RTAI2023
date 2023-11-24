package chessGameJava_RTAI2023;

import java.util.ArrayList;

public class Joueur {

	private String nom;
	private Couleur couleur;
	private Position pos;
	private Plateau plateau = new Plateau();
	
	//Liste des pieces disponibles en jeu
    private ArrayList<Piece> PieceDispo = new ArrayList<Piece>();
    
    //Liste des pieces qui ont été mangé
    private ArrayList<Piece> PieceMangee = new ArrayList<Piece>();
    
    
    
    /**
     * Constructeur de la classe Joueur
     * @param nom
     * @param couleur
     */
    public Joueur(String nom, Couleur couleur, Position pos, Plateau plateau) {
    	this.nom = nom;
    	this.couleur = couleur;
    	this.pos = pos;
    	this.plateau = plateau;
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
     * Fonction jouer() de la classe Joueur qui va verifier le chemin et la position d'arrivée sont possibles et puis fera le deplacement voulu de la piece
     * @param pos_depart
     * @param pos_arrivee
     */
    public void jouer(Boolean premTour, Position pos_depart, Position pos_arrivee) {
    	boolean possible = false;
    	Piece [][] piece = plateau.get_plateau();
    	//Récuperation du x et du y (version indice de matrice) de la position de depart
    	int x = pos.GetxByValue(pos_depart.get_x());
    	int y = pos_depart.get_y();
    	//Récuperation du type de la piece qu'on souhaite deplacer
    	String maClasse = piece[x][y].getClass().getName();
    	
    	
    	switch(maClasse) {
    	case "Pion":
    		possible = Pion.PositionPossible(plateau,piece[x][y].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Tour":
    		possible = Tour.PositionPossible(piece[x][y].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Fou":
    		possible = Fou.PositionPossible(piece[x][y].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Cavalier":
    		possible = Cavalier.PositionPossible(piece[x][y].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Reine":
    		possible = Reine.PositionPossible(piece[x][y].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Roi":
    		possible = Roi.PositionPossible(piece[x][y].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	}
    	
    	if (!possible) {
    		System.out.println("Votre "+maClasse+" ne peut se deplacer a la position voulue !");
    	}
    	else {
    		
    	}
    }
}
