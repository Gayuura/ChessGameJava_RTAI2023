package chessGameJava_RTAI2023;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Position pos_depart = new Position (0,'a');
        Position pos_arrivee = new Position (0,'a');
        Joueur JBlanc = new Joueur("Yacine",Couleur.Blanc);
        Joueur JNoir = new Joueur("Bastien",Couleur.Noir);
    	Plateau plateau = new Plateau(JBlanc,JNoir);
    	
    	
    	
    	
        plateau.initialiser();
        plateau.AfficherPlateau(); //JUSTE POUR TESTER LA METHODE INITIALISER (TEST REUSSI)
        System.out.println(JBlanc.AfficherList(JBlanc.get_PieceDispo())); //POUR TESTER LE CONTENU DES LISTES
        System.out.println(JBlanc.AfficherList(JBlanc.get_PieceMangee()));
        
        
        
        System.out.println("Que le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
        pos_depart.DemanderPos();
        System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
        pos_arrivee.DemanderPos();
        while (!(JBlanc.jouer(plateau, true, pos_depart, pos_arrivee))) {
        	pos_arrivee.DemanderPos();
        }
        plateau.AfficherPlateau();
        
        
        
        
        
        System.out.println("Que le Joueur Noir donne la position de la piece qu'il veut deplacer\n");
        pos_depart.DemanderPos();
        System.out.println("Que le Joueur Noir donne la position ou il veut mettre sa piece\n");
        pos_arrivee.DemanderPos();
        while (!(JNoir.jouer(plateau, true, pos_depart, pos_arrivee))) {
        	pos_arrivee.DemanderPos();
        }
        plateau.AfficherPlateau();
        
        
        
        
        
        System.out.println("Que le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
        pos_depart.DemanderPos();
        System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
        pos_arrivee.DemanderPos();
        while (!(JBlanc.jouer(plateau, true, pos_depart, pos_arrivee))) {
        	pos_arrivee.DemanderPos();
        }
        plateau.AfficherPlateau();
        
        
        
        System.out.println(JNoir.AfficherList(JBlanc.get_PieceDispo()));
        System.out.println(JNoir.AfficherList(JBlanc.get_PieceMangee()));
    }
}