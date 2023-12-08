package chessGameJava_RTAI2023;

import java.util.ArrayList;
import java.util.Iterator;

public class Joueur implements Cloneable{

	private String nom;
	private Couleur couleur;


	
	//Liste des pieces disponibles en jeu
    private ArrayList<Piece> PieceDispo = new ArrayList<Piece>();
    
    //Liste des pieces qui ont été mangé
    private ArrayList<Piece> PieceMorte = new ArrayList<Piece>();
    
    
    
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
     * Fonction getter pour l'attribut couleur
     * @return
     */
    public Couleur get_couleur() {
    	return this.couleur;
    }
    
    
    
    /**
     * Fonction getter pour l'attribut nom
     * @return
     */
    public String get_nom() {
    	return this.nom;
    }
    
    
    
    /**
     * Fonction getter de la liste PieceDispo
     * @return
     */
    public ArrayList<Piece> get_PieceDispo(){
    	return this.PieceDispo;
    }
    
    
    
    /**
     * Fonction getter de la liste PieceMangee
     * @return
     */
    public ArrayList<Piece> get_PieceMorte(){
    	return this.PieceMorte;
    }
    
    
    
    /**
     * Fonction qui va afficher une liste
     */
    public String AfficherList(ArrayList<Piece> liste) {
    	String res = "";
		Iterator<Piece> l = liste.iterator();
		while (l.hasNext()) {
			res += l.next().toString()+" / ";
		}
		return res;
	}
    
    
    
    /**
     * Fonction qui va retourner la position du Roi
     * @return
     */
    public Position RechercheRoiList(){
    	Position pos = new Position();
    	boolean trouve = false;
		int i = 0;
		
		while ((i < this.get_PieceDispo().size()) && !trouve) {
			if (this.get_PieceDispo().get(i).getClass().getName().contains("Roi")) {
				pos = this.get_PieceDispo().get(i).get_pos();
				trouve = true;
			}
			i++;
		}
		return pos;
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
    public void AddPieceMorte(Piece piece) {
    	this.PieceMorte.add(piece);
    }
    
    
    
    /**
     * Fonction qui supprime la piece de la liste des pieces disponibles
     * @param piece
     */
    public void SuppPieceDispo(Piece piece) {
    	this.PieceDispo.remove(piece);
    }
    
    
    
    public Object clone() {
        Object o = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la 
            // méthode super.clone()
            o = super.clone();
        } catch(CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver, car nous implémentons 
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        
        // on renvoie le clone
        return o;
    }
    
    
    
	/**
	 * Fonction jouer() de la classe Joueur qui va verifier le chemin et la position d'arrivée sont possibles et puis fera le deplacement voulu de la piece
	 * @param plateau
	 * @param depart
	 * @param arrivee
	 * @return
	 */
    public boolean jouer(Plateau plateau, Joueur JAdverse, Position depart, Position arrivee) {
    	boolean possible = false;
    	
    	//Récuperation des x et des y (version indice de matrice) de la position de depart et d'arrivée
    	int xD = depart.get_x();
    	int yD = depart.get_y();
    	int xA = arrivee.get_x();
    	int yA = arrivee.get_y();
    	Position pos = new Position();
    	
    	//On verifie si la regle Roque est demandée
    	if ((!plateau.estVide(plateau.get_plateau()[xA][yA])) && (plateau.get_plateau()[xD][yD].toString() == "Roi") && (plateau.get_plateau()[xA][yA].toString() == "Tour")) {
    		if (!Roi.RegleRoque(plateau, depart, arrivee)) {
				JPanelPlateau.afficherMessage("La regle Roque ne s'applique pas ici !");
    		}
    		else {
    			//Si la position de depart concerne le Roi Blanc
    			if ((xD == 0) && (yD == 4)) {
    				//Si la position d'arrivee concerne la Tour Blanche à droite
    				if ((xA == 0) && (yA == 7)) {
    					
    					//Modification de la position du Roi qui va se deplacer
    					pos = new Position(xD,yA-1);
    					plateau.get_plateau()[xD][yD].set_pos(pos);
    					
    					//Modification de la position de la Tour qui va se deplacer
    					pos = new Position(xD,yD+1);
    					plateau.get_plateau()[xA][yA].set_pos(pos);
    					
    					plateau.get_plateau()[xD][yA-1] = plateau.get_plateau()[xD][yD];
    					plateau.get_plateau()[xD][yD] = null;
    					plateau.get_plateau()[xD][yD+1] = plateau.get_plateau()[xA][yA];
    					plateau.get_plateau()[xA][yA] = null;
    				}
    				//Si la position d'arrivee concerne la Tour Blanche à gauche
    				else if ((xA == 0) && (yA == 0)) {
    					
    					//Modification de la position du Roi qui va se deplacer
    					pos = new Position(xD,yD-2);
    					plateau.get_plateau()[xD][yD].set_pos(pos);
    					
    					//Modification de la position de la Tour qui va se deplacer
    					pos = new Position(xD,yD-1);
    					plateau.get_plateau()[xA][yA].set_pos(pos);
    					
    					
    					plateau.get_plateau()[xD][yD-2] = plateau.get_plateau()[xD][yD];
    					plateau.get_plateau()[xD][yD] = null;
    					plateau.get_plateau()[xD][yD-1] = plateau.get_plateau()[xA][yA];
    					plateau.get_plateau()[xA][yA] = null;
    				}
    			}
    			////Si la position de depart concerne le Roi Noir
    			else if ((xD == 7) && (yD == 4)) {
    				//Si la position d'arrivee concerne la Tour Noire à droite
    				if ((xA == 7) && (yA == 7)){
    					
    					//Modification de la position du Roi qui va se deplacer
    					pos = new Position(xD,yA-1);
    					plateau.get_plateau()[xD][yD].set_pos(pos);
    					
    					//Modification de la position de la Tour qui va se deplacer
    					pos = new Position(xD,yD+1);
    					plateau.get_plateau()[xA][yA].set_pos(pos);
    					
    					
    					plateau.get_plateau()[xD][yA-1] = plateau.get_plateau()[xD][yD];
    					plateau.get_plateau()[xD][yD] = null;
    					plateau.get_plateau()[xD][yD+1] = plateau.get_plateau()[xA][yA];
    					plateau.get_plateau()[xA][yA] = null;
    				}
    				//Si la position d'arrivee concerne la Tour Noire à gauche
    				else if ((xA == 7) && (yA == 0)) {
    					
    					//Modification de la position du Roi qui va se deplacer
    					pos = new Position(xD,yD-2);
    					plateau.get_plateau()[xD][yD].set_pos(pos);
    					
    					//Modification de la position de la Tour qui va se deplacer
    					pos = new Position(xD,yD-1);
    					plateau.get_plateau()[xA][yA].set_pos(pos);
    					
    					
    					plateau.get_plateau()[xD][yD-2] = plateau.get_plateau()[xD][yD];
    					plateau.get_plateau()[xD][yD] = null;
    					plateau.get_plateau()[xD][yD-1] = plateau.get_plateau()[xA][yA];
    					plateau.get_plateau()[xA][yA] = null;
    				}
    			}
    			
    			possible = true;
    		}
    	}
    	else {
    		
	    	//Récuperation du type de la piece qu'on souhaite deplacer
	    	switch(plateau.get_plateau()[xD][yD].toString()) {
	    	case "Pion":
	    		possible = Pion.PositionPossible(plateau,Jeu.PionPremDepla(xD),depart,arrivee);
	    		break;
	    	case "Tour":
	    		possible = Tour.PositionPossible(plateau,depart,arrivee);
	    		break;
	    	case "Fou":
	    		possible = Fou.PositionPossible(plateau,depart,arrivee);
	    		break;
	    	case "Cavalier":
	    		possible = Cavalier.PositionPossible(plateau,depart,arrivee);
	    		break;
	    	case "Reine":
	    		possible = Reine.PositionPossible(plateau,depart,arrivee);
	    		break;
	    	case "Roi":
	    		possible = Roi.PositionPossible(plateau,JAdverse,depart,arrivee);
	    		break;
	    	}
	    	//Si la piece ne peut pas se deplacer a la position d'arrivée
	    	
	    	if (!possible) {
				JPanelPlateau.afficherMessage("Votre "+plateau.get_plateau()[xD][yD].toString()+" "+plateau.get_plateau()[xD][yD].get_couleur()+" ne peut pas se deplacer a la position voulue !\nVeuillez resaisir les positions pour le deplacement.");
	    	}
	    	//Sinon
	    	else {
	    		//Si la case d'arrivée n'est pas vide
	    		if (!(plateau.estVide(plateau.get_plateau()[xA][yA]))){
	    			
	    			//On l'ajoute a la liste des pieces mangée
		        	JAdverse.AddPieceMorte(plateau.get_plateau()[xA][yA]);
		        	
		        	//On la supprime de la liste des pieces disponibles
		        	JAdverse.SuppPieceDispo(plateau.get_plateau()[xA][yA]);
		        	
		        	//On affiche les nouvelles listes
		        	System.out.println("Voici la liste des pieces dispo du Joueur "+JAdverse.get_couleur()+" :");
	                System.out.println(JAdverse.AfficherList(JAdverse.get_PieceDispo())+"\n");
	                System.out.println("Voici la liste des pieces mortes du Joueur Blanc :");
	                System.out.println(JAdverse.AfficherList(JAdverse.get_PieceMorte())+"\n");
	    		}
	    		
	    		//Modification de la position de la piéce à deplacer
	    		pos = new Position(xA,yA);
	    		plateau.get_plateau()[xD][yD].set_pos(pos);
				
	    		//On fait le deplacement de la piece vers la position d'arrivée
	    		plateau.get_plateau()[xA][yA] = plateau.get_plateau()[xD][yD];
	    		plateau.get_plateau()[xD][yD] = null;
	    	}
    	}
    	
    	return possible;
    }
}
