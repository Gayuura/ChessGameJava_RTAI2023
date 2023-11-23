package chessGameJava_RTAI2023;

import java.util.Scanner;
public class Position {
    private char x;
    private int y;

    
    /**
     * Constructeur de la classe Position
     * @param x
     * @param y
     */
    public Position(char x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    /**
     * Fonction getter de x
     * @return
     */
    public char get_x() {
    	return this.x;
    }
    
    
    /**
     * Fonction getter de y
     * @return
     */
    public int get_y() {
    	return this.get_y();
    }
    
    
    /**
     * Fonction qui demande une position et verifie si la position est comprise dans le plateau
     * @return
     */
    public Position DemanderPos() {
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Veuillez saisir une position x (a, b, c, d, e, f, g ou h)\n x : ");
    	char x = scanner.next().charAt(0);
    	while ((x != 'a') && (x != 'b') && (x != 'c') && (x != 'd') && (x != 'e') && (x != 'f') && (x != 'g') && (x != 'h')) {
    		System.out.print("Votre position x se situe en dehors du plateau, \n veuillez resaisir une position entre a et h !");
    		x = scanner.next().charAt(0);
    	}
    	
    	System.out.print("Parfait, veuillez saisir à présent une position y (1, 2, 3, 4, 5, 6, 7 ou 8)\n y : ");
    	int y = scanner.nextInt();
    	while ((y != 1) && (y != 2) && (y != 3) && (y != 4) && (y != 5) && (y != 6) && (y != 7) && (y != 8)) {
    		System.out.print("Votre position y se situe en dehors du plateau, \n veuillez resaisir une position entre 1 et 8 !");
    		y = scanner.nextInt();
    	}
    	
    	Position pos = new Position(x,y);
    	return pos;
    }
    
    
    /**
     * Fonctio
     */
    public int GetxByValue(char x) {
    	int resultat = 0;
    	
    	switch(x) {
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
