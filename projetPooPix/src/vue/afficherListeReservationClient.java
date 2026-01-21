package vue;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.*;
import controleur.*;

public class afficherListeReservationClient extends JPanel {
	Hotel hotel;

    public afficherListeReservationClient(Hotel h) {
    	hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR
        
        
        JLabel titre = new JLabel("Historique des réservations par client", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        titre.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0)); // bas: 30px d’espace
        add(titre, BorderLayout.NORTH);

        // Compter le total de réservations pour toutes les lignes du tableau
        ArrayList<Reservation> toutesReservations = new ArrayList<>();
        for (Client cl : hotel.ListClient) {
            toutesReservations.addAll(cl.ListReservation);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String[] colonnes = {"ID", "Client", "Chambre", "Date de début", "Date de fin", "Statut"};
        Object[][] donnees = new Object[toutesReservations.size()][6];

        int i = 0;
        for (Reservation res : toutesReservations) {
            donnees[i][0] = res.id_reserve;
            donnees[i][1] = res.client;  // ou res.client.getNom() + " " + res.client.getPrenom()
            donnees[i][2] = res.chambre;
            donnees[i][3] = sdf.format(res.date_deb);
            donnees[i][4] = sdf.format(res.date_fin);
            donnees[i][5] = res.statut;
            i++;
        }

        JTable tableau = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableau);
        add(scrollPane, BorderLayout.CENTER);
        
        // pour annuler et modifier
        GridLayout grille = new GridLayout(2,2);
        JPanel champsPanel = new JPanel(grille);
        
        JComboBox<Reservation> listeResSup= new JComboBox<>();
        for (Client c : hotel.ListClient) {
            for (Reservation r : c.ListReservation) {
                listeResSup.addItem(r);
            }
        }
        
        JComboBox<Reservation> listeResMod = new JComboBox<>();
        for (Client c : hotel.ListClient) {
            for (Reservation r : c.ListReservation) {
                listeResMod.addItem(r);
            }
        }
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBackground(Color.GRAY); // COULEUR
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBackground(Color.GRAY); // COULEUR
        
        
        champsPanel.add(listeResSup);
        champsPanel.add(listeResMod);
        champsPanel.add(btnAnnuler);
        champsPanel.add(btnModifier);
        add(champsPanel, BorderLayout.SOUTH);
        
        boutonSupModReservation btnSupModRes = new boutonSupModReservation(hotel, listeResSup, listeResMod);
        btnAnnuler.addActionListener(btnSupModRes);
        btnModifier.addActionListener(btnSupModRes);
    }
}