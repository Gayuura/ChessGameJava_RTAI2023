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
     * Fonction jouer() de la classe Joueur qui va verifier le chemin et la position d'arrivée sont possibles et puis fera le deplacement voulu de la piece
     * @param pos_depart
     * @param pos_arrivee
     */
    public void jouer(Plateau plateau, Boolean premTour, Position pos_depart, Position pos_arrivee) {
    	boolean possible = false;
    	
    	//Récuperation des x et des y (version indice de matrice) de la position de depart et d'arrivée
    	int xD = pos_depart.GetxByValue(pos_depart.get_x());
    	int yD = pos_depart.get_y();
    	int xA = pos_arrivee.GetxByValue(pos_arrivee.get_x());
    	int yA = pos_arrivee.get_y();
    	Piece [][] aux = plateau.get_plateau();
    	

    	//Récuperation du type de la piece qu'on souhaite deplacer
    	
    	switch(plateau.get_plateau()[xD][yD].toString()) {
    	case "Pion":
    		possible = Pion.PositionPossible(plateau,plateau.get_plateau()[xD][yD].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Tour":
    		possible = Tour.PositionPossible(plateau.get_plateau()[xD][yD].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Fou":
    		possible = Fou.PositionPossible(plateau.get_plateau()[xD][yD].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Cavalier":
    		possible = Cavalier.PositionPossible(plateau.get_plateau()[xD][yD].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Reine":
    		possible = Reine.PositionPossible(plateau.get_plateau()[xD][yD].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	case "Roi":
    		possible = Roi.PositionPossible(plateau.get_plateau()[xD][yD].get_couleur(),pos_depart,pos_arrivee);
    		break;
    	}
    	
    	if (!possible) {
    		System.out.println("Votre "+plateau.get_plateau()[xD][yD].toString()+" "+plateau.get_plateau()[xD][yD].get_couleur()+" ne peut se deplacer a la position voulue !");
    	}
    	else {
        	aux[xA][yA] = aux[xD][yD];
        	aux[xD][yD] = null;
        	
        	plateau.set_plateau(aux);
    	}
    }
}
