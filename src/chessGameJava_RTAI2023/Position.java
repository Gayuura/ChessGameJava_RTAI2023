package chessGameJava_RTAI2023;

import java.util.Scanner;
public class Position {
    private int x;
    private char y;

    
    
    /**
     * Constructeur de la classe Position
     * @param x
     * @param y
     */
    public Position(int x, char y) {
        this.x = x;
        this.y = y;
    }
    
    
    
    /**
     * Fonction getter de x
     * @return
     */
    public int get_x() {
    	return this.x;
    }
    
    
    
    /**
     * Fonction getter de y
     * @return
     */
    public char get_y() {
    	return this.y;
    }
    
    
    
    /**
     * Fonction setter de l'attribut x
     * @param x
     */
    public void set_x(int x) {
    	this.x = x;
    }
    
    
    
    /**
     * Fonction setter de l'attribut y
     * @param y
     */
    public void set_y(char y) {
    	this.y = y;
    }
    
    
    
    /**
     * Fonction qui demande la position d'arrivee et verifie si la position est comprise dans le plateau
     * @param J
     * @param plateau
     */
    public void DemanderPosArrivee(Joueur J, Plateau plateau) {
    	
    	Scanner scanner = new Scanner(System.in);

	    System.out.print("Veuillez saisir une position x (1, 2, 3, 4, 5, 6, 7 ou 8)\n x : ");
	    int x = scanner.nextInt();
	    while ((x > 8) || (x < 1)) {
	    	System.out.print("Votre position x se situe en dehors du plateau, \n veuillez resaisir une position entre 1 et 8 !");
	    	x = scanner.nextInt();
	    }
	    	
	    System.out.print("Parfait, veuillez saisir à présent une position y (a, b, c, d, e, f, g ou h)\n y : ");
	    char y = scanner.next().charAt(0);
	    while ((y != 'a') && (y != 'b') && (y != 'c') && (y != 'd') && (y != 'e') && (y != 'f') && (y != 'g') && (y != 'h')) {
	    	System.out.print("Votre position y se situe en dehors du plateau, \n veuillez resaisir une position entre a et h !");
	    	y = scanner.next().charAt(0);
	    }

    	this.set_x(x-1);
    	this.set_y(y);
    }
    
    
    
    /**
     * Fonction qui demande la position de depart et verifie si la position est comprise dans le plateau
     * @param J
     * @param plateau
     */
    public void DemanderPosDepart(Joueur J, Plateau plateau) {
    	
    	boolean MaPiece = false;
    	Scanner scanner = new Scanner(System.in);

    	while(!MaPiece) {
	    	
    		System.out.print("Veuillez saisir une position x entre 1 et 8 !\n x : ");
	    	x = scanner.nextInt();
		    while ((x > 8) || (x < 1)) {
		    	System.out.print("Votre position x se situe en dehors du plateau, \n veuillez resaisir une position entre 1 et 8 !\n x : ");
		    	x = scanner.nextInt();
		    }
		    	
		    System.out.print("Parfait, veuillez saisir à présent une position y (a, b, c, d, e, f, g ou h)\n y : ");
		    y = scanner.next().charAt(0);
		    while ((y != 'a') && (y != 'b') && (y != 'c') && (y != 'd') && (y != 'e') && (y != 'f') && (y != 'g') && (y != 'h')) {
		    	System.out.print("Votre position y se situe en dehors du plateau, \n veuillez resaisir une position entre a et h !");
		    	y = scanner.next().charAt(0);
		    }
	    	
	    	
	    	//On verifie si la piece choisie corresponds aux pieces qu'il peut choisir
	    	if (plateau.estVide(plateau.get_plateau()[x-1][GetYByValue(y)])) {
	    		System.out.println("Il n'y a aucune piece à cette position.\n");
	    	}
	    	//On verifie s'il existe bien une piece à cette position
	    	else if (EstSaPiece(J,plateau.get_plateau()[x-1][GetYByValue(y)])) {
	    		MaPiece = true;
	    	}
	    	else {
	    		System.out.println("Vous avez demander le deplacement d'une piece adverse ! Choisissez une piece de votre camp, Merci");
	    	}
    	}
    	this.set_x(x-1);
    	this.set_y(y);
    }
    
    
    
    /**
     * Fonction qui verifie si la piece choisie corresponds aux pieces qu'il peut choisir
     * @param J
     * @param piece
     * @return
     */
    public boolean EstSaPiece(Joueur J, Piece piece) {
    	boolean MaPiece = false;
    	
    	if ((piece.get_couleur() == J.get_couleur())){
    		MaPiece = true;
    	}    	
    	return MaPiece;
    }
    
    
    
    /**
     * Fonction qui transforme la premiere coordonnée (x) en int
     * @param x
     * @return
     */
    public int GetYByValue(char y) {
    	int resultat = 0;
    	
    	switch(y) {
    	case 'a':
    		resultat = 0;
    		break;
    	case 'b':
    		resultat = 1;
    		break;
    	case 'c':
    		resultat = 2;
    		break;
    	case 'd':
    		resultat = 3;
    		break;
    	case 'e':
    		resultat = 4;
    		break;
    	case 'f':
    		resultat = 5;
    		break;
    	case 'g':
    		resultat = 6;
    		break;
    	case 'h':
    		resultat = 7;
    		break;
    	}
    	
    	return resultat;
    }
}
