package chessGameJava_RTAI2023;

public class Plateau {
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
    public void set_plateau(Piece [][] plateau) {
    	this.plateau = plateau;
    }
    
    
    
    /**
     * Fonction qui verifie si une case est vide
     * @param Case
     * @return
     */
    public boolean estVide(Piece Case) {
    	if (Case != null) {
    		return false;    		
    	}
    	return true;
    }
    
    
    
    // JUSTE POUR TESTER LA METHODE INITIALISER (TEST REUSSI)
    public void AfficherPlateau() {
    	System.out.println("Affichage du plateau\n");
    	for (int i = plateau.length-1; i >= 0; i--) {
    		for (int j = 0; j < plateau.length; j++) {
    			if (!estVide(plateau[i][j])) {
    				if ((plateau[i][j].getClass().getName().contains("Reine")) || (plateau[i][j].getClass().getName().contains("Roi"))){
    					System.out.print("    "+plateau[i][j].toString()+"_"+plateau[i][j].get_couleur());
    				}
    				else
    					System.out.print("    "+plateau[i][j].toString()+"_"+plateau[i][j].get_couleur()+"_"+plateau[i][j].get_id());
    			}
    			else 
    				System.out.print("                ");
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
    		plateau[1][j] = new Pion(Couleur.Blanc,j);
    		JBlanc.AddPieceDispo(plateau[1][j]);
    		
    	}
    	
    	//Création et Placement des Pions Noirs
    	for (int j = 0; j < plateau.length; j++) {
    		plateau[6][j] = new Pion(Couleur.Noir,j);
    		JNoir.AddPieceDispo(plateau[6][j]);
    	}
    	
    	//Création et Placement des autres Pieces Blanches
    	plateau[0][0] = new Tour(Couleur.Blanc,0);
    	plateau[0][1] = new Cavalier(Couleur.Blanc,0);
    	plateau[0][2] = new Fou(Couleur.Blanc,0);
    	plateau[0][3] = new Reine(Couleur.Blanc);
    	plateau[0][4] = new Roi(Couleur.Blanc);
    	plateau[0][5] = new Fou(Couleur.Blanc,1);
    	plateau[0][6] = new Cavalier(Couleur.Blanc,1);
    	plateau[0][7] = new Tour(Couleur.Blanc,1);
    	
    	//Mise à jour de la liste des pieces dispo du Joueur Blanc
    	for (int i = 0; i < plateau.length; i++) {
    		JBlanc.AddPieceDispo(plateau[0][i]);
    	}
    	
    	//Création et Placement des autres Pieces Noires
    	plateau[7][0] = new Tour(Couleur.Noir,0);
    	plateau[7][1] = new Cavalier(Couleur.Noir,0);
    	plateau[7][2] = new Fou(Couleur.Noir,0);
    	plateau[7][3] = new Reine(Couleur.Noir);
    	plateau[7][4] = new Roi(Couleur.Noir);
    	plateau[7][5] = new Fou(Couleur.Noir,1);
    	plateau[7][6] = new Cavalier(Couleur.Noir,1);
    	plateau[7][7] = new Tour(Couleur.Noir,1);
    	
    	//Mise à jour de la liste des pieces dispo du Joueur Noir
    	for (int i = 0; i < plateau.length; i++) {
    		JNoir.AddPieceDispo(plateau[7][i]);
    	}
    }
}
