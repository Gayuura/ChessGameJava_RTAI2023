package chessGameJava_RTAI2023;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelPlateau extends JPanel{
    private JPanel lePlateau;
    private JPanel leDamier;
    private JScrollPane GUIConsole;
    private JTextArea textArea;
    private JPanel GUIPromotion;
    private JButton afficheBlancMort;
    private JButton afficheNoirMort;
    private JPanel buttonAfficheMort;
    private Boolean enAttentePlateau = false;
    private Boolean enAttentePromotion = false;
    private Piece piece;
    private int idX;
    private int idY;
    // Création d'une variable local plateau
    private Plateau plateau;

    // Constructeur de la viariable plateau

    /**
     * Constructeur de la classe JPanelPlateau
     * @param jBlanc
     * @param jNoir
     */
    public JPanelPlateau(Joueur jBlanc, Joueur jNoir) {

        leDamier.setLayout(new GridLayout(8,8));
        leDamier.setSize(600,600);
        setButton(leDamier);

        GUIPromotion.setLayout(new GridLayout(1,4));
        GUIPromotion.setVisible(false);

        JFrame frame = new JFrame("JPanelPlateau");
        frame.setContentPane(lePlateau);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,750);
        frame.setResizable(false);
        frame.setVisible(true);
        afficheBlancMort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherMessageGUI("Voici la liste des pieces mortes du Joueur Blanc :");
                afficherMessageGUI(jBlanc.AfficherList(jBlanc.get_PieceMorte())+"\n");
            }
        });
        afficheNoirMort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherMessageGUI("Voici la liste des pieces mortes du Joueur Noir :");
                afficherMessageGUI(jNoir.AfficherList(jNoir.get_PieceMorte())+"\n");
            }
        });
    }

    /**
     * Retourne l'idX
     * @return
     */
    public int getIdX() {
        return idX;
    }

    /**
     * Retourne l'idY
     * @return
     */
    public int getIdY() {
        return idY;
    }

    /**
     * Retourne la piece
     * @return
     */
    public Piece getPiece() {
        return piece;
    }
    // Pour mettre des couleurs au textArea
//    public JTextArea getTextArea() {
//        return textArea;
//    }

    /**
     * Créer les boutons et les ajoutes au panel
     * @param panel1
     */
    public void setButton(JPanel panel1) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton btn = new JButton();
//                btn.setText(i + "," + j);

                btn.putClientProperty("idX", i);
                btn.putClientProperty("idY", j);

                if((i+j)%2==0)
                    btn.setBackground(Color.WHITE);
                else
                    btn.setBackground(Color.BLACK);


                //Défini l'image du bouton
                setImgInButton(btn, "", Couleur.Noir);

                btn.addActionListener(new ActionListener() {
                    /**
                     * Affiche les coordonnées du bouton cliqué
                     * @param e
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = (JButton) e.getSource();
                        int idX = (int) btn.getClientProperty("idX");
                        int idY = (int) btn.getClientProperty("idY");
                        System.out.println("idX = " + idX + " idY = " + idY);
//                        System.out.println("btn = " + btn.getSize());
                    }
                });
                panel1.add(btn);
            }
        }
    }


    /**
     * Défini l'image redimensionner du bouton
     * @param btn
     * @param nomPiece
     * @param couleur
     */
    public void setImgInButton(JButton btn, String nomPiece, Couleur couleur) {
        Image icon = getImageIcon(couleur, nomPiece).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btn.setIcon(new ImageIcon(icon));
    }


    /**
     * Retourne l'image de la pièce
     * @param couleur
     * @param nomPiece
     * @return
     */
    public ImageIcon getImageIcon(Couleur couleur, String nomPiece) {

        if (couleur == Couleur.Blanc)
            switch (nomPiece) {
                case "Pion":
                    return new ImageIcon("src/assets/w_pawn_png_shadow_1024px.png");
                case "Tour":
                    return new ImageIcon("src/assets/w_rook_png_shadow_1024px.png");
                case "Cavalier":
                    return new ImageIcon("src/assets/w_knight_png_shadow_1024px.png");
                case "Fou":
                    return new ImageIcon("src/assets/w_bishop_png_shadow_1024px.png");
                case "Reine":
                    return new ImageIcon("src/assets/w_queen_png_shadow_1024px.png");
                case "Roi":
                    return new ImageIcon("src/assets/w_king_png_shadow_1024px.png");
                default:
                    return new ImageIcon("src/assets/square_no_color_png_shadow_1024px.png");
            }
        else if (couleur == Couleur.Noir){
            switch (nomPiece) {
                case "Pion":
                    return new ImageIcon("src/assets/b_pawn_png_shadow_1024px.png");
                case "Tour":
                    return new ImageIcon("src/assets/b_rook_png_shadow_1024px.png");
                case "Cavalier":
                    return new ImageIcon("src/assets/b_knight_png_shadow_1024px.png");
                case "Fou":
                    return new ImageIcon("src/assets/b_bishop_png_shadow_1024px.png");
                case "Reine":
                    return new ImageIcon("src/assets/b_queen_png_shadow_1024px.png");
                case "Roi":
                    return new ImageIcon("src/assets/b_king_png_shadow_1024px.png");
                default:
                    return new ImageIcon("src/assets/square_no_color_png_shadow_1024px.png");
            }
        }
        return null;
    }

    /**
     * Fonction lireMatrice() qui permet de mettre à jour l'interface graphique (damier) en fonction de la matrice du plateau
     * @param plateau : matrice du plateau représentant l'emplacement des pièces
     */
    public void lireMatrice(Piece[][] plateau) {
        // On supprime le contenu actuel du damier
        leDamier.removeAll();

        // On ajoute les nouveaux boutons en fonction de la matrice du plateau
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < plateau[i].length; j++) {
                JButton btn = new JButton();

                // On configure le bouton en fonction de la pièce présente sur la case
                if (plateau[i][j] != null) {
                    setImgInButton(btn, plateau[i][j].getClass().getSimpleName(), plateau[i][j].get_couleur());
                }

                btn.putClientProperty("idX", i+1);
                btn.putClientProperty("idY", j);

                // On alterne la couleur d'une case en fonction de la position pour créer un motif de damier (Noir et blanc)
                if ((i + j) % 2 == 0)
                    btn.setBackground(Color.WHITE);
                else
                    btn.setBackground(Color.BLACK);

                // ActionListener qui représente l'action sur un bouton, lorsqu'il est cliqué : le code de l'ActionPerformed est exécuté
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Code déclenché lorsqu'un joueur clique sur un bouton
                        JButton btn = (JButton) e.getSource();
                        idX = (int) btn.getClientProperty("idX");
                        idY = (int) btn.getClientProperty("idY");
                        System.out.println("idX = " + idX + " idY = " + idY);
                        enAttentePlateau = false;
                    }
                });

                // On ajoute le bouton à l'interface graphique (au Damier)
                leDamier.add(btn);
            }
        }
        // On met à jour l'affichage
        leDamier.revalidate();
        leDamier.repaint();
    }

    /**
     * Fonction qui permet de définir les boutons du panel de promotion
     * @param couleur
     */
    private void setButtonPromotion(Couleur couleur) {
        JButton btn = new JButton();
        btn.putClientProperty("idX", 0);
        btn.putClientProperty("idY", 0);
        setImgInButton(btn, "Reine", couleur);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Reine(couleur, null,0);
                enAttentePromotion = false;
            }
        });
        GUIPromotion.add(btn);

        JButton btn1 = new JButton();
        btn1.putClientProperty("idX", 0);
        btn1.putClientProperty("idY", 1);
        setImgInButton(btn1, "Tour", couleur);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Tour(couleur, null,0);
                enAttentePromotion = false;
            }
        });
        GUIPromotion.add(btn1);

        JButton btn2 = new JButton();
        btn2.putClientProperty("idX", 0);
        btn2.putClientProperty("idY", 2);
        setImgInButton(btn2, "Fou", couleur);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Fou(couleur, null,0);
                enAttentePromotion = false;
            }
        });
        GUIPromotion.add(btn2);

        JButton btn3 = new JButton();
        btn3.putClientProperty("idX", 0);
        btn3.putClientProperty("idY", 3);
        setImgInButton(btn3, "Cavalier", couleur);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Cavalier(couleur, null,0);
                enAttentePromotion = false;
            }
        });
        GUIPromotion.add(btn3);
    }

    /**
     * Fonction qui permet d'afficher un message dans une fenetre
     * @param message
     */
    public static void afficherMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message);
    }

    /**
     * Fonction qui permet d'afficher un message dans une fenetre et de recuperer la valeur saisie par l'utilisateur
     * @param message
     * @return
     */
    public static String afficherInput(String message) {
        return JOptionPane.showInputDialog(new JFrame(), message);
    }

    /**
     * Fonction qui permet d'afficher un message dans une fenetre et retourner la valeur du bouton cliqué
     * @param message
     */
    public static int afficherConfirm(String message) {
        return JOptionPane.showConfirmDialog(new JFrame(), message);
    }

    /**
     * Fonction qui permet d'afficher un message dans la console de l'interface graphique
     * @param message
     */
    public void afficherMessageGUI(String message) {
        textArea.append(message + "\n");
    }

    /**
     * Fonction qui permet d'afficher le tour actuelle dans la console de l'interface graphique
     * @param couleurJoueur
     */
    public void afficherMessageTourDeJeu(Couleur couleurJoueur) {
        String message = "[" + couleurJoueur + "]";
        textArea.append(message + "\n");
    }

    /**
     * Fonction qui permet de mettre en pause le script tant que l'utilisateur n'a pas cliqué sur un bouton du plateau
     */
    public void attenteInteractionPlateau() {
        enAttentePlateau = true;
        while (enAttentePlateau) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Fonction qui permet de mettre en pause le script tant que l'utilisateur n'a pas cliqué sur un bouton du panel de promotion
     * @param couleur
     */
    public void attenteInteractionPromotion(Couleur couleur) {
        enAttentePromotion = true;
        GUIPromotion.removeAll();
        setButtonPromotion(couleur);
        GUIPromotion.setVisible(true);
        while (enAttentePromotion) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        GUIPromotion.setVisible(false);
        System.out.println("piece = " + piece);
    }
}
