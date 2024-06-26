package chessGameJava_RTAI2023;

public class Jeu implements IJeu{

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
     * Fonction qui verifie si la piece choisie corresponds aux pieces qu'il peut choisir
     * @param J
     * @param piece
     * @return
     */
    public static boolean EstSaPiece(Joueur J, Piece piece) {
    	boolean MaPiece = false;
    	
    	if ((piece.get_couleur() == J.get_couleur())){
    		MaPiece = true;
    	}    	
    	return MaPiece;
    }
    
    
    
    /**
     * Fonction qui verifie s'il y'a un echec a la position donnée en parametre
     * @param plateau
     * @param JAdverse
     * @param PosRoi
     * @return
     */
    public static boolean echec(Plateau plateau, Joueur JAdverse, Position PosRoi) {
    	boolean echec = false;
    	int i = 0;
    	
    	while ((i < JAdverse.get_PieceDispo().size()) && (!echec)) {
    		if (JAdverse.get_PieceDispo().get(i).getClass().getName().contains("Pion")) {
	    		echec = Pion.PositionPossible(plateau,PionPremDepla(JAdverse.get_PieceDispo().get(i).get_pos().get_x()),JAdverse.get_PieceDispo().get(i).get_pos(),PosRoi);
    		}
    		else if (JAdverse.get_PieceDispo().get(i).getClass().getName().contains("Tour")) {
	    		echec = Tour.PositionPossible(plateau,JAdverse.get_PieceDispo().get(i).get_pos(),PosRoi);
    		}
    		else if (JAdverse.get_PieceDispo().get(i).getClass().getName().contains("Fou")) {
	    		echec = Fou.PositionPossible(plateau,JAdverse.get_PieceDispo().get(i).get_pos(),PosRoi);
    		}
    		else if (JAdverse.get_PieceDispo().get(i).getClass().getName().contains("Cavalier")) {
	    		echec = Cavalier.PositionPossible(plateau,JAdverse.get_PieceDispo().get(i).get_pos(),PosRoi);
    		}
    		else if (JAdverse.get_PieceDispo().get(i).getClass().getName().contains("Reine")) {
	    		echec = Reine.PositionPossible(plateau,JAdverse.get_PieceDispo().get(i).get_pos(),PosRoi);
    		}
    		
    		i++;
    	}
    	
    	return echec;
    }
    
    
    
/**
 * Fonction qui verifiera s'il y'a echec et math
 * @param plateau
 * @param JAdverse
 * @param PosRoi
 * @return
 */
    public boolean echec_math(Plateau plateau, Joueur JAdverse, Position PosRoi) {
    	
    	boolean Termine = false;
    	Position pos;
    	//Si le Roi est en echec sur sa case
    	if (this.echec(plateau, JAdverse, pos = new Position(PosRoi.get_x(), PosRoi.get_y()))) {
	    	if (PosRoi.get_x() > 0 && PosRoi.get_y() > 0 && PosRoi.get_x() < 7 && PosRoi.get_y() < 7) {
	    		if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()))) &&  (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()-1)))) {
	    			Termine = true;
	    		}
	    	}
	    	else if (PosRoi.get_x() == 0) {
	    		if (PosRoi.get_y() == 0) {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()+1)))){
	    				Termine = true;
	    			}
	    		}
	    		else if (PosRoi.get_y() == 7) {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()-1)))){
	    				Termine = true;
	    			}
	    		}
	    		else {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y())) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()-1))))){
	    				Termine = true;
	    			}
	    		}
	    	}
	    	else if (PosRoi.get_x() == 7) {
	    		if (PosRoi.get_y() == 0) {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()+1)))){
	    				Termine = true;
	    			}
	    		}
	    		else if (PosRoi.get_y() == 7) {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()-1)))){
	    				Termine = true;
	    			}
	    		}
	    		else {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y())) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()-1))))){
	    				Termine = true;
	    			}
	    		}
	    	}
	    	else if ((PosRoi.get_x() > 0) && (PosRoi.get_x() < 7)) {
	    		if (PosRoi.get_y() == 0 ) {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()+1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y())))) {
	    				Termine = true;
	    			}
	    		}
	    		else if (PosRoi.get_y() == 7 ) {
	    			if ((!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()-1, PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x(), PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y()-1))) && (!Roi.PositionPossible(plateau, JAdverse, PosRoi, pos = new Position(PosRoi.get_x()+1, PosRoi.get_y())))) {
	    				Termine = true;
	    			}
	    		}
	    	}
    	}
    	
    	return Termine;
    }

	public static void promotionPion(Plateau plateau, JPanelPlateau jPanelPlateau, Joueur joueur){
		Couleur couleur = joueur.get_couleur();
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				Piece p = plateau.get_plateau()[i][j];
				if(p != null && p.getClass().getName().contains("Pion")){
					if(p.get_couleur() == couleur ){
						if(p.get_pos().get_x() == 0 || p.get_pos().get_x() == 7){
							jPanelPlateau.attenteInteractionPromotion(couleur);
							joueur.SuppPieceDispo(p);
							p = jPanelPlateau.getPiece();
							p.set_pos(new Position(i,j));
							joueur.AddPieceDispo(p);
							plateau.set_Piece(jPanelPlateau.getPiece(), p.get_pos().get_x(), p.get_pos().get_y());
						}
					}
				}
			}
		}
	}
}
