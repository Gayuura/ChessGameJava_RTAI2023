package chessGameJava_RTAI2023;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Position pos_depart = new Position (0,'a');
        Position pos_arrivee = new Position (0,'a');
        Joueur JBlanc = new Joueur("Yacine",Couleur.Blanc);
        Joueur JNoir = new Joueur("Bastien",Couleur.Noir);
    	Plateau plateau = new Plateau(JBlanc,JNoir);
    	
    	
    	
    	
        plateau.initialiser();

        Piece[][] test = plateau.get_plateau();
        test[0][0] = null;
        test[1][0] = null;
        test[0][1] = null;
        test[1][1] = null;
        test[1][0] = new Pion(Couleur.Noir, 10);
        plateau.set_plateau(test);

        plateau.AfficherPlateau(); //JUSTE POUR TESTER LA METHODE INITIALISER (TEST REUSSI)

//         JPanelPlateau GuiPlateau = new JPanelPlateau();
//        JPanelPromotion GuiPromotion = new JPanelPromotion();

        // Test de la fonction lireMatrice() pour afficher le plateau avec ses pièces au départ
        JPanelPlateau jPanelPlateau = new JPanelPlateau(); // Peut être enlever plateau dans les parenthèses
        jPanelPlateau.lireMatrice(plateau.get_plateau());

        // Pour tester le fonctionnement d'un pop-up "Erreur" par exemple
        // JOptionPane.showMessageDialog(jPanelPlateau, "Bonjour, c'est un test !", "Erreur", JOptionPane.ERROR_MESSAGE);











//        Position pos = new Position ('a',0);
        
        
        
        
        
        for (int i = 0; i < 30; i++) {
        	if (i % 2 == 0) {
                System.out.println("Que le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
                pos_depart.DemanderPosDepart(JBlanc,plateau, jPanelPlateau);
                System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
                pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
                while (!(JBlanc.jouer(plateau,JNoir,pos_depart,pos_arrivee))) {
                	pos_depart.DemanderPosDepart(JBlanc,plateau, jPanelPlateau);
                	pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
                }
                plateau.AfficherPlateau();
                System.out.println("Voici la liste des pieces dispo du Joueur Noir :");
                System.out.println(JNoir.AfficherList(JNoir.get_PieceDispo())+"\n");
                System.out.println("Voici la liste des pieces mortes du Joueur Noir :");
                System.out.println(JNoir.AfficherList(JNoir.get_PieceMorte())+"\n");
        	}
        	else {
                System.out.println("Que le Joueur Noir donne la position de la piece qu'il veut deplacer\n");
                pos_depart.DemanderPosDepart(JNoir,plateau, jPanelPlateau);
                System.out.println("Que le Joueur Noir donne la position ou il veut mettre sa piece\n");
                pos_arrivee.DemanderPosArrivee(JNoir,plateau);
                while (!(JNoir.jouer(plateau,JBlanc,pos_depart,pos_arrivee))) {
                	pos_depart.DemanderPosDepart(JNoir,plateau, jPanelPlateau);
                	pos_arrivee.DemanderPosArrivee(JNoir,plateau);
                }
                plateau.AfficherPlateau();
                System.out.println("Voici la liste des pieces dispo du Joueur Blanc :");
                System.out.println(JBlanc.AfficherList(JBlanc.get_PieceDispo())+"\n");
                System.out.println("Voici la liste des pieces mortes du Joueur Blanc :");
                System.out.println(JBlanc.AfficherList(JBlanc.get_PieceMorte())+"\n");
        	}
        }
        
        /*for (int i = 0; i < 30; i++) {
        	System.out.println("Que le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
            pos_depart.DemanderPosDepart(JBlanc,plateau);
            System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
            pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
            while (!(JBlanc.jouer(plateau,JNoir,pos_depart,pos_arrivee))) {
            	pos_depart.DemanderPosDepart(JBlanc,plateau);
            	pos_arrivee.DemanderPosArrivee(JBlanc,plateau);
            }
            plateau.AfficherPlateau();
        }*/
    }
}