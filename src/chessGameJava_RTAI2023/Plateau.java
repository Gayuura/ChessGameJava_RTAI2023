package chessGameJava_RTAI2023;

public class Plateau {
    private Piece [][] plateau = new Piece[8][8];
    private Joueur JBlanc,JNoir;

    
    
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
    	if (Case.getClass().getName().contains("Pion") || Case.getClass().getName().contains("Tour") || Case.getClass().getName().contains("Cavalier") || Case.getClass().getName().contains("Fou") || Case.getClass().getName().contains("Reine") || Case.getClass().getName().contains("Roi")) {
    		return false;
    	}
    	return true;
    }
    
    
    
    /**
     * Fonction qui va creer, initialiser et placer les pieces sur le plateau et dans les listes des pieces disponibles des deux joueurs
     */
    public void initialiser() {   
    	
    	//Création et Placement des Pions Blancs et Noirs
    	Pion PionBlanc = new Pion(Couleur.Blanc,0);
    	plateau[1][0] = PionBlanc;
    	
    	JBlanc.AddPieceDispo(PionBlanc);		//Ajout de la piece a la liste des pieces dispo du joueur Blanc
    	
    	Pion PionNoir = new Pion(Couleur.Noir,0);
    	plateau[6][0] = PionNoir;
    	
    	JNoir.AddPieceDispo(PionNoir);			//Ajout de la piece a la liste des pieces dispo du joueur Noir
    	
    	for (int i = 1; i < 8; i++) {
    		PionBlanc.set_id(i);
    		plateau[1][i] = PionBlanc;
    		JBlanc.AddPieceDispo(PionBlanc);
    		
    		PionNoir.set_id(i);
    		plateau[6][i] = PionNoir;
    		JNoir.AddPieceDispo(PionNoir);
    	}
    	
    	
    	//Création et Placement des Tours Blanches sur le plateau et dans la liste des pieces disponibles
    	Tour TourBlanche = new Tour(Couleur.Blanc,0);
    	plateau[0][0] = TourBlanche;
    	JBlanc.AddPieceDispo(TourBlanche);
    	TourBlanche.set_id(1);;
    	plateau[0][7] = TourBlanche;
    	JBlanc.AddPieceDispo(TourBlanche);
    	
    	//Création et Placement des Cavaliers Blancs sur le plateau et dans la liste des pieces disponibles
    	Cavalier CavalierBlanc = new Cavalier(Couleur.Blanc,0);
    	plateau[0][1] = CavalierBlanc;
    	JBlanc.AddPieceDispo(CavalierBlanc);
    	CavalierBlanc.set_id(1);
    	plateau[0][6] = CavalierBlanc;
    	JBlanc.AddPieceDispo(CavalierBlanc);
    	
    	//Création et Placement des Fous Blancs sur le plateau et dans la liste des pieces disponibles
    	Fou FouBlanc = new Fou(Couleur.Blanc,0);
    	plateau[0][2] = FouBlanc;
    	JBlanc.AddPieceDispo(FouBlanc);
    	FouBlanc.set_id(1);
    	plateau[0][5] = FouBlanc;
    	JBlanc.AddPieceDispo(FouBlanc);
    	
    	//Création et Placement des Tours Noires sur le plateau et dans la liste des pieces disponibles
    	Tour TourNoire = new Tour(Couleur.Noir,0);
    	plateau[7][0] = TourNoire;
    	JNoir.AddPieceDispo(TourNoire);
    	TourNoire.set_id(1);
    	plateau[7][7] = TourNoire;
    	JNoir.AddPieceDispo(TourNoire);
    	
    	//Création et Placement des Cavalier Noirs sur le plateau et dans la liste des pieces disponibles
    	Cavalier CavalierNoir = new Cavalier(Couleur.Noir,0);
    	plateau[7][1] = CavalierNoir;
    	JNoir.AddPieceDispo(CavalierNoir);
    	CavalierNoir.set_id(1);
    	plateau[7][6] = CavalierNoir;
    	JNoir.AddPieceDispo(CavalierNoir);
    	
    	//Création et Placement des Fous Noires sur le plateau et dans la liste des pieces disponibles
    	Fou FouNoir = new Fou(Couleur.Noir,0);
    	plateau[7][2] = FouNoir;
    	JNoir.AddPieceDispo(FouNoir);
    	FouNoir.set_id(1);
    	plateau[7][5] = FouNoir;
    	JNoir.AddPieceDispo(FouNoir);
    	
    	//Création et Placement des Reines sur le plateau et dans la liste des pieces disponibles
    	Reine reine = new Reine(Couleur.Blanc);
    	plateau[0][3] = reine;
    	JBlanc.AddPieceDispo(reine);
    	reine.set_couleur(Couleur.Noir);
    	plateau[7][3] = reine;
    	JNoir.AddPieceDispo(reine);
    	
    	//Création et Placement des Roi sur le plateau et dans la liste des pieces disponibles
    	Roi roi = new Roi(Couleur.Blanc);
    	plateau[0][4] = roi;
    	JBlanc.AddPieceDispo(roi);
    	roi.set_couleur(Couleur.Noir);
    	plateau[7][4] = roi;
    	JNoir.AddPieceDispo(roi);
    }
}
