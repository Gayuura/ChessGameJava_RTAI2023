package chessGameJava_RTAI2023;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelPlateau extends JPanel{
    private JPanel lePlateau;
    private JPanel leDamier;
    private Boolean enAttente = false;
    private int idX;
    private int idY;


    public JPanelPlateau() {



//        lePlateau.setLayout(new GridLayout(8,8));
        leDamier.setLayout(new GridLayout(8,8));
        setButton(leDamier);

        JFrame frame = new JFrame("JPanelPlateau");
        frame.setContentPane(lePlateau);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,750);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public int getIdX() {
        return idX;
    }

    public int getIdY() {
        return idY;
    }

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
     * Fonction lireMatrice() qui permet le lire la matrice du plateau au niveau de l'interface graphique
     */
    public void lireMatrice(Piece[][] plateau) {
        // On supprime le contenu actuel du damier
        leDamier.removeAll();

        // On ajoute les nouveaux boutons en fonction de la matrice du plateau
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                JButton btn = new JButton();

                // On configure le bouton en fonction de la pièce présente sur la case
                if (plateau[i][j] != null) {
                    setImgInButton(btn, plateau[i][j].getClass().getSimpleName(), plateau[i][j].get_couleur());
                }

                btn.putClientProperty("idX", i);
                btn.putClientProperty("idY", j);

                if ((i + j) % 2 == 0)
                    btn.setBackground(Color.WHITE);
                else
                    btn.setBackground(Color.BLACK);

                // On ajoute un ActionListener pour gérer les clics sur les boutons
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = (JButton) e.getSource();
                        idX = (int) btn.getClientProperty("idX");
                        idY = (int) btn.getClientProperty("idY");
                        System.out.println("idX = " + idX + " idY = " + idY);
                        enAttente = false;
                    }
                });

                leDamier.add(btn);
            }
        }
        // On met à jour l'affichage
        leDamier.revalidate();
        leDamier.repaint();
    }
    
    public static void afficherMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message);
    }

    public static String afficherInput(String message) {
        return JOptionPane.showInputDialog(new JFrame(), message);
    }

    public static int afficherConfirm(String message) {
        return JOptionPane.showConfirmDialog(new JFrame(), message);
    }

    public void click() {
        enAttente = true;
        while (enAttente) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
