package vue;

import java.awt.*;
import javax.swing.*;
import model.*;
import controleur.*;

public class afficherReservation extends JPanel {
    Hotel hotel;

    public afficherReservation(Hotel h) {
        hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR

        JLabel titre = new JLabel("Enregistrer une réservation", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        add(titre, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        GridLayout grille = new GridLayout(6, 2);
        JPanel champsPanel = new JPanel(grille);

        champsPanel.setBackground(Color.LIGHT_GRAY);  // COULEUR

        // ID de réservation
        JPanel pIdRes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pIdRes.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblIdRes = new JLabel("Numéro de réservation :");
        lblIdRes.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtIdRes = new JTextField(10);
        pIdRes.add(lblIdRes);
        pIdRes.add(txtIdRes);
        champsPanel.add(pIdRes);

        // Client
        JPanel pClient = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pClient.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblCl = new JLabel("Client :");
        lblCl.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Client> clientBox = new JComboBox<>();
        for (Client ci : hotel.ListClient) {
            clientBox.addItem(ci);
        }
        pClient.add(lblCl);
        pClient.add(clientBox);
        champsPanel.add(pClient);

        // Chambre
        JPanel pChambre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pChambre.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblChambre = new JLabel("Chambre :");
        lblChambre.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Chambre> chambreBox = new JComboBox<>();
        for (Chambre ca : hotel.ListChambre) {
            chambreBox.addItem(ca);
        }
        pChambre.add(lblChambre);
        pChambre.add(chambreBox);
        champsPanel.add(pChambre);

        // Listes déroulantes pour les dates
        String[] jours = new String[31];
        for (int i = 1; i <= 31; i++) jours[i - 1] = String.valueOf(i);

        String[] mois = new String[12];
        for (int i = 1; i <= 12; i++) mois[i - 1] = String.valueOf(i);

        String[] annees = new String[50];
        for (int i = 0; i < 50; i++) annees[i] = String.valueOf(2025 + i);

        // Date début
        JPanel pDateDeb = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pDateDeb.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblDateDeb = new JLabel("Date de debut de réservation : ");
        lblDateDeb.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<String> jourDebBox = new JComboBox<>(jours);
        JComboBox<String> moisDebBox = new JComboBox<>(mois);
        JComboBox<String> anneeDebBox = new JComboBox<>(annees);
        pDateDeb.add(lblDateDeb);
        pDateDeb.add(jourDebBox);
        pDateDeb.add(moisDebBox);
        pDateDeb.add(anneeDebBox);
        champsPanel.add(pDateDeb);

        // Date fin
        JPanel pDateFin = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pDateFin.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblDateFin = new JLabel("Date de fin de réservation : ");
        lblDateFin.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<String> jourFinBox = new JComboBox<>(jours);
        JComboBox<String> moisFinBox = new JComboBox<>(mois);
        JComboBox<String> anneeFinBox = new JComboBox<>(annees);
        pDateFin.add(lblDateFin);
        pDateFin.add(jourFinBox);
        pDateFin.add(moisFinBox);
        pDateFin.add(anneeFinBox);
        champsPanel.add(pDateFin);

        // Statut
        JPanel pStatutRes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pStatutRes.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblStatutRes = new JLabel("Statut :");
        lblStatutRes.setFont(new Font("Arial", Font.BOLD, 18));
        lblStatutRes.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JRadioButton attente = new JRadioButton("en attente");
        attente.setFont(new Font("Arial", Font.BOLD, 18));
        attente.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JRadioButton validee = new JRadioButton("validée");
        validee.setFont(new Font("Arial", Font.BOLD, 18));
        validee.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JRadioButton terminee = new JRadioButton("terminée");
        terminee.setFont(new Font("Arial", Font.BOLD, 18));
        terminee.setBackground(Color.LIGHT_GRAY);  // COULEUR

        ButtonGroup groupeStatut = new ButtonGroup();
        groupeStatut.add(attente);
        groupeStatut.add(validee);
        groupeStatut.add(terminee);

        pStatutRes.add(lblStatutRes);
        pStatutRes.add(attente);
        pStatutRes.add(validee);
        pStatutRes.add(terminee);
        champsPanel.add(pStatutRes);

        // Ajout du panneau de champs au centre
        add(champsPanel, BorderLayout.CENTER);

        // Bouton Enregistrer
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAjouter = new JButton("Enregistrer");
        boutonPanel.setBackground(Color.LIGHT_GRAY);  // COULEUR
        btnAjouter.setBackground(Color.GRAY);  // COULEUR
        boutonPanel.add(btnAjouter);
        add(boutonPanel, BorderLayout.SOUTH);

        // Action
        boutonAjouterReservation res = new boutonAjouterReservation(
            txtIdRes, jourDebBox, moisDebBox, anneeDebBox,
            jourFinBox, moisFinBox, anneeFinBox,
            groupeStatut, clientBox, chambreBox,
            hotel
        );
        btnAjouter.addActionListener(res);
    }
}
