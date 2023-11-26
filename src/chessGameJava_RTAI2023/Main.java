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
        System.out.println("Voici la liste des pieces dispo du Joueur Blanc : \n");
        System.out.println(JBlanc.AfficherList(JBlanc.get_PieceDispo())); //POUR TESTER LE CONTENU DES LISTES
        System.out.println("Voici la liste des pieces Mortes du Joueur Blanc : \n");
        System.out.println(JBlanc.AfficherList(JBlanc.get_PieceMorte()));
        
        
        
        System.out.println("Que le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
        pos_depart.DemanderPosDepart(JBlanc,plateau);
        System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
        pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
        while (!(JBlanc.jouer(plateau,JNoir,pos_depart,pos_arrivee))) {
        	pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
        }
        plateau.AfficherPlateau();
        
        
        
        
        
        System.out.println("Que le Joueur Noir donne la position de la piece qu'il veut deplacer\n");
        pos_depart.DemanderPosDepart(JNoir,plateau);
        System.out.println("Que le Joueur Noir donne la position ou il veut mettre sa piece\n");
        pos_arrivee.DemanderPosArrivee(JNoir,plateau);
        while (!(JNoir.jouer(plateau,JBlanc,pos_depart,pos_arrivee))) {
        	pos_arrivee.DemanderPosArrivee(JNoir,plateau);
        }
        plateau.AfficherPlateau();
        
        
        
        
        
        System.out.println("Que le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
        pos_depart.DemanderPosDepart(JBlanc,plateau);
        System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
        pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
        while (!(JBlanc.jouer(plateau,JNoir,pos_depart,pos_arrivee))) {
        	pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
        }
        plateau.AfficherPlateau();
        
        
        System.out.println("Voici la liste des pieces dispo du Joueur Noir :");
        System.out.println(JNoir.AfficherList(JNoir.get_PieceDispo())+"\n");
        System.out.println("Voici la liste des pieces mortes du Joueur Noir :");
        System.out.println(JNoir.AfficherList(JNoir.get_PieceMorte()));
    }
}