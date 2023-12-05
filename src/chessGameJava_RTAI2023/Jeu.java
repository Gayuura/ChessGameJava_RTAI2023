package chessGameJava_RTAI2023;

import javax.swing.*;

public class Jeu implements InterJeu{
    private Joueur JBlanc;
    private Joueur JNoir;
 
    
    
    /**
     * Fonction qui verifie si le Pion effectue son premier deplacement de la partie
     * @param x
     * @return
     */
    public static boolean PionPremDepla(int x) {
    	if ((x == 1) || (x == 6)){
    		return true;
    	}
    	return false;
    }
    
    
    
    /**
     * Fonction qui verifie s'il y'a un echec a la position donnée en parametre
     * @param plateau
     * @param i
     * @param y
     * @return
     */
    public static boolean echec(Plateau plateau, int x, int y) {
    	return false;
    }
    
    
    
    /**
     * Fonction qui verifiera s'il y'a echec et math
     * @param plateau
     * @param PosRoi
     * @return
     */
    public boolean echec_math(Plateau plateau, Position PosRoi) {
    	
    	boolean Termine = false;
    	int x = PosRoi.get_x();
    	int y = PosRoi.GetYByValue(PosRoi.get_y());
    	
    	if ((this.echec(plateau, x+1, y)) &&  (this.echec(plateau, x-1, y)) && (this.echec(plateau, x, y+1)) && (this.echec(plateau, x, y-1))) {
    		Termine = true;
    	}
    	
    	return Termine;
    }

	public static void promotionPion(Plateau plateau, Position depart, Position arrivee, Couleur couleur) {

		if(couleur == Couleur.Blanc) {
			if(arrivee.get_x() == 7) {
				JPanelPromotion jPanelPromotion = new JPanelPromotion(new JFrame(), Couleur.Blanc);
				Piece rs = jPanelPromotion.afficherFormulaire();
				plateau.set_Piece(rs, depart.get_x(), depart.GetYByValue(depart.get_y()));
			}
		}
		else if(couleur == Couleur.Noir){
			if(arrivee.get_x() == 0) {
				JPanelPromotion jPanelPromotion = new JPanelPromotion(new JFrame(), Couleur.Blanc);
				Piece rs = jPanelPromotion.afficherFormulaire();
				plateau.set_Piece(rs, depart.get_x(), depart.GetYByValue(depart.get_y()));
			}
		}
	}
}
