package vue;

import javax.swing.*;
import controleur.*;
import java.awt.*;
import model.*;

public class afficherListeChambre extends JPanel{
	Hotel hotel;
	
	public afficherListeChambre(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR
        
        JLabel titre = new JLabel("Liste des chambres", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        titre.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0)); // bas: 30px d’espace
        add(titre, BorderLayout.NORTH);

        String[] colonnes = {"Chambre", "Etage", "Type", "Tarif"};
        Object[][] donnees = new Object[hotel.ListChambre.size()][4];
        int i = 0;
        for (Chambre ch : hotel.ListChambre) {
            donnees[i][0] = ch.numero;
            donnees[i][1] = ch.etage;
            donnees[i][2] = ch.type;
            donnees[i][3] = ch.tarif;
            i++;
        }

        JTable tableau = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableau); // pour avoir une barre de défilement
        add(scrollPane, BorderLayout.CENTER); // afficher dans le panel
        
        // pour supprimer et modifier
        GridLayout grille = new GridLayout(2,2);
        JPanel champsPanel = new JPanel(grille);
        
        JComboBox<Chambre> listeChSup = new JComboBox<>(); // liste pour supprimer
        for (Chambre ch : hotel.ListChambre) {
            listeChSup.addItem(ch);
        }
        
        JComboBox<Chambre> listeChMod = new JComboBox<>(); // liste pour modifier
        for (Chambre ch : hotel.ListChambre) {
            listeChMod.addItem(ch);
        }

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBackground(Color.GRAY); // COULEUR
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBackground(Color.GRAY); // COULEUR
        

        champsPanel.add(listeChSup);
        champsPanel.add(listeChMod);
        champsPanel.add(btnSupprimer);
        champsPanel.add(btnModifier);
        add(champsPanel, BorderLayout.SOUTH);
		
        boutonSupModChambre btnSupModCh = new boutonSupModChambre(hotel, listeChSup, listeChMod);
        btnSupprimer.addActionListener(btnSupModCh);
        btnModifier.addActionListener(btnSupModCh);
	}

}