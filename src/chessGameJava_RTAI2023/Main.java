package chessGameJava_RTAI2023;

public class Main {
    public static void main(String[] args) {

        Position pos_depart = new Position ();
        Position pos_arrivee = new Position ();
        Joueur JBlanc = new Joueur("Yacine",Couleur.Blanc);
        Joueur JNoir = new Joueur("Bastien",Couleur.Noir);
    	Plateau plateau = new Plateau(JBlanc,JNoir);
    	Jeu jeu = new Jeu();
    	Piece Roi_Blanc;
    	Piece Roi_Noir;
    	int i = 0;
    	
        plateau.initialiser();

//        Piece[][] test = plateau.get_plateau();
//        test[0][0] = null;
//        test[1][0] = null;
//        test[0][1] = null;
//        test[1][1] = null;
//        test[1][0] = new Pion(Couleur.Noir, new Position(1,0));
//        plateau.set_plateau(test);

//        plateau.set_Piece(new Pion(Couleur.Noir, new Position(1,0)), 1, 0);

        plateau.AfficherPlateau(); //JUSTE POUR TESTER LA METHODE INITIALISER (TEST REUSSI)

        System.out.println("Voici la liste des pieces dispo du Joueur Blanc :");
        System.out.println(JBlanc.AfficherList(JBlanc.get_PieceDispo())+"\n");
        System.out.println("Voici la liste des pieces mortes du Joueur Blanc :");
        System.out.println(JBlanc.AfficherList(JBlanc.get_PieceMorte())+"\n");
//         JPanelPlateau GuiPlateau = new JPanelPlateau();
//        JPanelPromotion GuiPromotion = new JPanelPromotion();

        System.out.println("Voici la liste des pieces dispo du Joueur Noir :");
        System.out.println(JNoir.AfficherList(JNoir.get_PieceDispo())+"\n");
        System.out.println("Voici la liste des pieces mortes du Joueur Noir :");
        System.out.println(JNoir.AfficherList(JNoir.get_PieceMorte())+"\n");
        
        
        
        
        // Test de la fonction lireMatrice() pour afficher le plateau avec ses pièces au départ
        JPanelPlateau jPanelPlateau = new JPanelPlateau();
        // jPanelPlateau.afficherMessageGUI("Voici le plateau de départ : \n");


        // Pour tester le fonctionnement d'un pop-up "Erreur" par exemple
        // JOptionPane.showMessageDialog(jPanelPlateau, "Bonjour, c'est un test !", "Erreur", JOptionPane.ERROR_MESSAGE);









        
        

      //Lancement du jeu
        while (!jeu.echec_math(plateau, JNoir, JBlanc.RechercheRoiList()) && !jeu.echec_math(plateau, JBlanc, JNoir.RechercheRoiList())) {
            jPanelPlateau.lireMatrice(plateau.get_plateau());
            if (i % 2 == 0) {
                System.out.println("\nQue le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
                jPanelPlateau.afficherMessageTourDeJeu(Couleur.Blanc);
                pos_depart.DemanderPosDepart(JBlanc, plateau, jPanelPlateau);
                System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
                pos_arrivee.DemanderPosArrivee(JBlanc, plateau, jPanelPlateau);

                
                while (!(JBlanc.jouer(plateau, JNoir, pos_depart, pos_arrivee))) {
                    pos_depart.DemanderPosDepart(JBlanc, plateau, jPanelPlateau);
                    pos_arrivee.DemanderPosArrivee(JBlanc, plateau, jPanelPlateau);
                }
                
                Plateau aux = (Plateau) plateau.clone();
                
                while (jeu.echec(plateau, JBlanc, JNoir.RechercheRoiList()) && !jeu.echec_math(plateau, JBlanc, JNoir.RechercheRoiList())) {
                	
                	plateau = (Plateau) aux.clone();
                	plateau.AfficherPlateau();
                    jPanelPlateau.lireMatrice(plateau.get_plateau());
                	
                    System.out.println("Votre Roi Noir est en position d'echec, vous devez le deplacer, ou alors le sauver par le biais d'une autre piece !");
                    System.out.println("\nQue le Joueur Noir donne la position de la piece qu'il veut deplacer\n");
                    pos_depart.DemanderPosDepart(JNoir, plateau, jPanelPlateau);
                    System.out.println("Que le Joueur Noir donne la position ou il veut mettre sa piece\n");
                    pos_arrivee.DemanderPosArrivee(JNoir, plateau, jPanelPlateau);

                    while (!(JNoir.jouer(plateau, JBlanc, pos_depart, pos_arrivee))) {
                        pos_depart.DemanderPosDepart(JNoir, plateau, jPanelPlateau);
                        pos_arrivee.DemanderPosArrivee(JNoir, plateau, jPanelPlateau);
                    }
                    
                }

                Jeu.promotionPion(plateau, Couleur.Blanc);

            } else {
                System.out.println("\nQue le Joueur Noir donne la position de la piece qu'il veut deplacer\n");
                jPanelPlateau.afficherMessageTourDeJeu(Couleur.Noir);
                pos_depart.DemanderPosDepart(JNoir, plateau, jPanelPlateau);
                System.out.println("Que le Joueur JNoir donne la position ou il veut mettre sa piece\n");
                pos_arrivee.DemanderPosArrivee(JNoir, plateau, jPanelPlateau);

                while (!(JNoir.jouer(plateau, JBlanc, pos_depart, pos_arrivee))) {
                    pos_depart.DemanderPosDepart(JNoir, plateau, jPanelPlateau);
                    pos_arrivee.DemanderPosArrivee(JNoir, plateau, jPanelPlateau);
                }
                
                Plateau aux = (Plateau) plateau.clone();
                
                while (jeu.echec(plateau, JNoir, JBlanc.RechercheRoiList()) && !jeu.echec_math(plateau, JNoir, JBlanc.RechercheRoiList())) {
                	
                	plateau = (Plateau) aux.clone();
                	plateau.AfficherPlateau();
                    jPanelPlateau.lireMatrice(plateau.get_plateau());
                	
                    System.out.println("Votre Roi Blanc est en position d'echec, vous devez le deplacer, ou alors le sauver par le biais d'une autre piece !");
                    System.out.println("\nQue le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
                    pos_depart.DemanderPosDepart(JBlanc, plateau, jPanelPlateau);
                    System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
                    pos_arrivee.DemanderPosArrivee(JBlanc, plateau, jPanelPlateau);

                    while (!(JBlanc.jouer(plateau, JNoir, pos_depart, pos_arrivee))) {
                        pos_depart.DemanderPosDepart(JBlanc, plateau, jPanelPlateau);
                        pos_arrivee.DemanderPosArrivee(JBlanc, plateau, jPanelPlateau);
                    }

                }

                Jeu.promotionPion(plateau, Couleur.Noir);
            }
            plateau.AfficherPlateau();
            i++;
            
            
            
            //Juste pour trouver ou ca coince
            System.out.println("La Position du ROI BLANC est ["+JBlanc.RechercheRoiList().get_x()+","+JBlanc.RechercheRoiList().get_y()+"]");
            System.out.println("La Position du ROI NOIR est ["+JNoir.RechercheRoiList().get_x()+","+JNoir.RechercheRoiList().get_y()+"]");
        }

        
        //Annonce du gagnant
        if (jeu.echec_math(plateau, JNoir, JBlanc.RechercheRoiList())){
    		System.out.println("Le Roi Blanc est en echec et mat !\n"+"L'equipe Noire, "+JNoir.get_nom()+", a donc gagné !");
    	}
    	else if (jeu.echec_math(plateau, JBlanc, JNoir.RechercheRoiList())) {
    		System.out.println("Le Roi Noir est en echec et mat !\n"+"L'equipe Blanche, "+JBlanc.get_nom()+", a donc gagné !");
    	}
        
        
        
        
        
        //POUR TESTER LES PIECES NOIRES
        /*for ( i = 0; i < 30; i++) {
        	
        	System.out.println("Que le Joueur Blanc donne la position de la piece qu'il veut deplacer\n");
            pos_depart.DemanderPosDepart(JBlanc,plateau);, jPanelPlateau
            System.out.println("Que le Joueur Blanc donne la position ou il veut mettre sa piece\n");
            pos_arrivee.DemanderPosArrivee(JBlanc,plateau);, jPanelPlateau
            while (!(JBlanc.jouer(plateau,JNoir,pos_depart,pos_arrivee))) {
            	pos_depart.DemanderPosDepart(JBlanc,plateau);, jPanelPlateau
            	pos_arrivee.DemanderPosArrivee(JBlanc,plateau);, jPanelPlateau
            }
            plateau.AfficherPlateau();
        }*/
        
        
        
        
        //POUR TESTER LES PIECES BLANCHES
        /*for (int i = 0; i < 30; i++) {
        	
        	System.out.println("Que le Joueur Noir donne la position de la piece qu'il veut deplacer\n");
            pos_depart.DemanderPosDepart(JNoir,plateau);, jPanelPlateau
            System.out.println("Que le Joueur Noir donne la position ou il veut mettre sa piece\n");
            pos_arrivee.DemanderPosArrivee(JNoir,plateau);, jPanelPlateau
            while (!(JNoir.jouer(plateau,JBlanc,pos_depart,pos_arrivee))) {
            	pos_depart.DemanderPosDepart(JNoir,plateau);, jPanelPlateau
            	pos_arrivee.DemanderPosArrivee(JNoir,plateau);, jPanelPlateau
            }
            plateau.AfficherPlateau();
        }*/
    }
}