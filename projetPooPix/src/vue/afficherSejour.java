package vue;

import javax.swing.*;
import java.awt.*;
import model.*;
import controleur.*;

public class afficherSejour extends JPanel {
    Hotel hotel;

    public afficherSejour(Hotel h) {
        hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel titre = new JLabel("Créer ou modifier un séjour", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        titre.setForeground(Color.DARK_GRAY); // COULEUR
        add(titre, BorderLayout.NORTH);
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // bas: 30px d’espace

        GridLayout grille = new GridLayout(4, 2);
        JPanel champsPanel = new JPanel(grille);
        champsPanel.setBackground(Color.LIGHT_GRAY); // COULEUR

        // ID du séjour (centrer le label et la barre)
        JPanel pIdSej = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pIdSej.setBackground(Color.LIGHT_GRAY); // COULEUR
        JLabel lblIdSej = new JLabel("ID du séjour :");
        lblIdSej.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtIdSej = new JTextField(10); // longueur horizontale de la zone blanche
        pIdSej.add(lblIdSej);
        pIdSej.add(txtIdSej);
        champsPanel.add(pIdSej);

        // numéro de réservation (centrer le label et la barre)
        JPanel pReservation = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pReservation.setBackground(Color.LIGHT_GRAY); // COULEUR
        JLabel lblReservation = new JLabel("Réservation :");
        lblReservation.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Reservation> reservationBox = new JComboBox<>();

        for (Chambre c : hotel.ListChambre) {
            for (Reservation r : c.ListReservation) {
                reservationBox.addItem(r);
            }
        }
        pReservation.add(lblReservation);
        pReservation.add(reservationBox);
        champsPanel.add(pReservation);

        // séjour payé ? (centrer le label et la barre)
        JPanel pPayee = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pPayee.setBackground(Color.LIGHT_GRAY); // COULEUR
        JCheckBox boxPayee = new JCheckBox("   Facture payée");
        boxPayee.setBackground(Color.LIGHT_GRAY);
        boxPayee.setFont(new Font("Arial", Font.BOLD, 18));
        pPayee.add(boxPayee);
        champsPanel.add(pPayee);

        add(champsPanel, BorderLayout.CENTER); // centrer le tout

        // bouton "valider"
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnValider = new JButton("Valider");
        boutonPanel.setBackground(Color.LIGHT_GRAY); // Couleur de fond du bouton
        btnValider.setBackground(Color.GRAY); // Couleur du texte du bouton
        //btnValider.setFont(new Font("Arial", Font.BOLD, 18)); // Taille du texte
        boutonPanel.add(btnValider);
        add(boutonPanel, BorderLayout.SOUTH);

        boutonAjouterSejour btnAjouterSej = new boutonAjouterSejour(txtIdSej, reservationBox, boxPayee, hotel);
        btnValider.addActionListener(btnAjouterSej);
    }
}
