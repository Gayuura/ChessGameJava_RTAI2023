package chessGameJava_RTAI2023;

public class Plateau implements Cloneable{
    private Piece [][] plateau = new Piece[8][8];
    private Joueur JBlanc,JNoir;

    
    
    /**
     * Constructeur du plateau
     * @param JBlanc
     * @param JNoir
     */
    public Plateau(Joueur JBlanc, Joueur JNoir) {
    	this.JBlanc = JBlanc;
    	this.JNoir = JNoir;
    }
    
    
    
    /**
     * Fonction getter pour l'attribut plateau
     * @return
     */
    public Piece[][] get_plateau(){
    	return this.plateau;
    }
    
    
    
    /**
     * Fonction setter pour l'attribut plateau
     * @param plateau
     */
    public void set_plateau(Piece[][] plateau) {
    	this.plateau = plateau;
    }
    
    public void set_Piece(Piece p, int x, int y) {
		this.plateau[x][y] = p;
	}
    
    @Override
    public Object clone() {
        Plateau p = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la méthode super.clone()
            p = (Plateau) super.clone();

            // On clone l'attribut de type Piece[][] qui n'est pas immuable.
            p.plateau = new Piece[8][8];
            for (int i = 0; i < plateau.length; i++) {
                for (int j = 0; j < plateau[i].length; j++) {
                    if (plateau[i][j] != null) {
                        p.plateau[i][j] = plateau[i][j].clone();
                    }
                    else {
                    	p.plateau[i][j] = null;
                    }
                }
            }

            // On clone l'attribut de type Joueur qui n'est pas immuable.
            p.JBlanc = (Joueur) JBlanc.clone();
            p.JNoir = (Joueur) JNoir.clone();

        } catch (CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver, car nous implémentons l'interface Cloneable
            cnse.printStackTrace(System.err);
        }

        // On renvoie le clone
        return p;
    }


    
    
    
    /**
     * Fonction qui verifie si une case est vide
     * @param Case
     * @return
     */
    public boolean estVide(Piece Case) {
    	return Case == null;
    }
    
    
    
    // JUSTE POUR TESTER LA METHODE INITIALISER, A SUPPRIMER QUAND ON AURA L'INTERFACE GRAPHIQUE
    public void AfficherPlateau() {
    	System.out.println("Affichage du plateau\n");
    	for (int i = plateau.length-1; i >= 0; i--) {
    		System.out.print(i+1);
    		for (int j = 0; j < plateau.length; j++) {
    			if (!estVide(plateau[i][j])) {
    				System.out.print("    "+plateau[i][j].toString()+"_"+plateau[i][j].get_couleur());
    			}
    			else 
    				System.out.print("              ");
    		}
    		System.out.println("\n");
    	}
    }
    
    
    /**
     * Fonction qui va creer, initialiser et placer les pieces sur le plateau et dans les listes des pieces disponibles des deux joueurs
     */
    public void initialiser() {   
    	
    	
    	//Création et Placement des Pions Blancs
    	for (int j = 0; j < plateau.length; j++) {
    		plateau[1][j] = new Pion(Couleur.Blanc,new Position(1,j));
    		JBlanc.AddPieceDispo(plateau[1][j]);
    		
    	}
    	
    	//Création et Placement des Pions Noirs
    	for (int j = 0; j < plateau.length; j++) {
    		plateau[6][j] = new Pion(Couleur.Noir,new Position(6,j));
    		JNoir.AddPieceDispo(plateau[6][j]);
    	}
    	
    	//Création et Placement des autres Pieces Blanches
    	plateau[0][0] = new Tour(Couleur.Blanc,new Position(0,0));
    	
    	plateau[0][1] = new Cavalier(Couleur.Blanc,new Position(0,1));
    	
    	plateau[0][2] = new Fou(Couleur.Blanc,new Position(0,2));
    	
    	plateau[0][3] = new Reine(Couleur.Blanc,new Position(0,3));
    	
    	plateau[0][4] = new Roi(Couleur.Blanc,new Position(0,4));
    	
    	plateau[0][5] = new Fou(Couleur.Blanc,new Position(0,5));
    	
    	plateau[0][6] = new Cavalier(Couleur.Blanc,new Position(0,6));
    	
    	plateau[0][7] = new Tour(Couleur.Blanc,new Position(0,7));
    	
    	//Mise à jour de la liste des pieces dispo du Joueur Blanc
    	for (int j = 0; j < plateau.length; j++) {
    		JBlanc.AddPieceDispo(plateau[0][j]);
    	}
    	
    	//Création et Placement des autres Pieces Noires
    	plateau[7][0] = new Tour(Couleur.Noir,new Position(7,0));
    	
    	plateau[7][1] = new Cavalier(Couleur.Noir,new Position(7,1));
    	
    	plateau[7][2] = new Fou(Couleur.Noir,new Position(7,2));
    	
    	plateau[7][3] = new Reine(Couleur.Noir,new Position(7,3));
    	
    	plateau[7][4] = new Roi(Couleur.Noir,new Position(7,4));
    	
    	plateau[7][5] = new Fou(Couleur.Noir,new Position(7,5));
    	
    	plateau[7][6] = new Cavalier(Couleur.Noir,new Position(7,6));
    	
    	plateau[7][7] = new Tour(Couleur.Noir,new Position(7,7));
    	
    	//Mise à jour de la liste des pieces dispo du Joueur Noir
    	for (int j = 0; j < plateau.length; j++) {
    		JNoir.AddPieceDispo(plateau[7][j]);
    	}
    }
}
