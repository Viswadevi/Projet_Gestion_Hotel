package vue;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class afficherAccueil extends JPanel {
    public afficherAccueil() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        setBackground(Color.LIGHT_GRAY);
        // Jaune ////////////////////////////////////////////////////////
        // Texte "Accueil" centré
        JLabel titre = new JLabel("Accueil");
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        titre.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Image depuis une URL
        JLabel imageLabel;
        try {
            URL imageUrl = new URL("https://img.freepik.com/vecteurs-premium/modele-conception-vecteur-logo-icone-hotel_827767-3569.jpg");
            ImageIcon icone = new ImageIcon(imageUrl);
            Image imageRedim = icone.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(imageRedim));
        } catch (Exception e) {
            imageLabel = new JLabel("Erreur de chargement de l'image");
        }
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(titre);
        add(Box.createVerticalStrut(30)); // espace
        add(imageLabel);
    }
}
