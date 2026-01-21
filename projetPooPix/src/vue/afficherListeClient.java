package vue;

import javax.swing.*;
import controleur.*;
import java.awt.*;
import model.*;

public class afficherListeClient extends JPanel {
	Hotel hotel;
	
	public afficherListeClient(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR

        
        JLabel titre = new JLabel("Liste des clients", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        titre.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0)); // bas: 30px d’espace
        add(titre, BorderLayout.NORTH);

        String[] colonnes = {"ID", "Nom", "Prénom", "Email", "Téléphone"};
        Object[][] donnees = new Object[hotel.ListClient.size()][5];
        int i = 0;
        for (Client cl : hotel.ListClient) {
            donnees[i][0] = cl.id_client;
            donnees[i][1] = cl.nom;
            donnees[i][2] = cl.prenom;
            donnees[i][3] = cl.email;
            donnees[i][4] = cl.num_tel;
            i++;
        }

        JTable tableau = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableau); // pour avoir une barre de défilement
        add(scrollPane, BorderLayout.CENTER); // afficher dans le panel
        
        // pour supprimer et modifier
        GridLayout grille = new GridLayout(2,2);
        JPanel champsPanel = new JPanel(grille);
        
        JComboBox<Client> listeClSup = new JComboBox<>(); // liste pour supprimer
        for (Client c : hotel.ListClient) {
            listeClSup.addItem(c);
        }
        
        JComboBox<Client> listeClMod = new JComboBox<>(); // liste pour modifier
        for (Client c : hotel.ListClient) {
            listeClMod.addItem(c);
        }

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBackground(Color.GRAY); // COULEUR
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBackground(Color.GRAY); // COULEUR

        
        champsPanel.add(listeClSup);
        champsPanel.add(listeClMod);
        champsPanel.add(btnSupprimer);
        champsPanel.add(btnModifier);
        add(champsPanel, BorderLayout.SOUTH);
		
        boutonSupModClient btnSupModCl = new boutonSupModClient(hotel, listeClSup, listeClMod);
        btnSupprimer.addActionListener(btnSupModCl);
        btnModifier.addActionListener(btnSupModCl);
	}

}