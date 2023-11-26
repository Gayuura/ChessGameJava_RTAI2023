package chessGameJava_RTAI2023;

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
     * Fonction qui verifiera si la partie est terminé
     * @return
     */
    public boolean echec_math() {
    	return true;
    }
}
