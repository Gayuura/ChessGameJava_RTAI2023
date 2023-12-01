package chessGameJava_RTAI2023;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelPromotion extends JDialog  {
    private Piece piece;
    private JPanel Panel;

    public JPanelPromotion(JFrame parent, Couleur couleur){
        super(parent, "Promotion", true);
        Panel.setLayout(new GridLayout(1,4));
        setButton(Panel, couleur);
        add(Panel);
        setResizable(false);


//        pack();
//        setLocationRelativeTo(parent);
    }

    public Piece afficherFormulaire() {
        setVisible(true);
        return piece;
    }

    private void setButton(JPanel panel, Couleur couleur) {
        JButton btn = new JButton();
        btn.putClientProperty("idX", 0);
        btn.putClientProperty("idY", 0);
        setImgInButton(btn, "Reine", couleur);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Reine(couleur, 10);
                dispose(); // Ferme le formulaire après la sélection
            }
        });
        panel.add(btn);

        JButton btn1 = new JButton();
        btn1.putClientProperty("idX", 0);
        btn1.putClientProperty("idY", 1);
        setImgInButton(btn1, "Tour", couleur);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Tour(couleur, 10);
                dispose(); // Ferme le formulaire après la sélection
            }
        });
        panel.add(btn1);

        JButton btn2 = new JButton();
        btn2.putClientProperty("idX", 0);
        btn2.putClientProperty("idY", 2);
        setImgInButton(btn2, "Fou", couleur);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Fou(couleur, 10);
                dispose(); // Ferme le formulaire après la sélection
            }
        });
        panel.add(btn2);

        JButton btn3 = new JButton();
        btn3.putClientProperty("idX", 0);
        btn3.putClientProperty("idY", 3);
        setImgInButton(btn3, "Cavalier", couleur);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piece = new Cavalier(couleur, 10);
                dispose(); // Ferme le formulaire après la sélection
            }
        });
        panel.add(btn3);
    }

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
}
