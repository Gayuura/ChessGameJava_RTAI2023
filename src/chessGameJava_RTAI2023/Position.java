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
     * Fonction qui demande une position et verifie si la position est comprise dans le plateau
     * @return
     */
    public void DemanderPos() {
    	
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
     * Fonction qui transforme la premiere coordonnée (x) en int
     * @param x
     * @return
     */
    public int GetYByValue(char x) {
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
