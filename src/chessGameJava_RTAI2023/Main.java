package chessGameJava_RTAI2023;

public class Main {
    public static void main(String[] args) {

        Position pos = new Position ('a',0);
        Joueur JBlanc = new Joueur("Yacine",Couleur.Blanc);
        Joueur JNoir = new Joueur("Bastien",Couleur.Noir);
    	Plateau plateau = new Plateau(JBlanc,JNoir);
    	
    	
    	
    	
        plateau.initialiser();
        //plateau.AfficherPlateau(); JUSTE POUR TESTER LA METHODE INITIALISER (TEST REUSSI)
        pos.DemanderPos();
    }
}