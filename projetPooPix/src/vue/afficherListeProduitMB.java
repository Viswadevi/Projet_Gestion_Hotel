package vue;

import javax.swing.*;
import controleur.*;
import java.awt.*;
import model.*;

public class afficherListeProduitMB extends JPanel{
	Hotel hotel;
	
	public afficherListeProduitMB(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR
        
        JLabel titre = new JLabel("Liste des produits mini bar", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        titre.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0)); // bas: 30px d’espace
        add(titre, BorderLayout.NORTH);

        String[] colonnes = {"ID", "Nom", "Prix unitaire"};
        Object[][] donnees = new Object[hotel.ListProduit_mini_bar.size()][3];
        int i = 0;
        for (Produit_mini_bar prodMB : hotel.ListProduit_mini_bar) {
            donnees[i][0] = prodMB.id_produit;
            donnees[i][1] = prodMB.nom;
            donnees[i][2] = prodMB.prix_unitaire;
            i++;
        }

        JTable tableau = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableau); // pour avoir une barre de défilement
        add(scrollPane, BorderLayout.CENTER); // afficher dans le panel
        
        // pour supprimer et modifier
        GridLayout grille = new GridLayout(2,2);
        JPanel champsPanel = new JPanel(grille);
        
        JComboBox<Produit_mini_bar> listeProdMBSup = new JComboBox<>(); // liste pour supprimer
        for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
            listeProdMBSup.addItem(p);
            listeProdMBSup.setBackground(Color.GRAY); // COULEUR
        }
        
        JComboBox<Produit_mini_bar> listeProdMBMod = new JComboBox<>(); // liste pour modifier
        for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
            listeProdMBMod.addItem(p);
            listeProdMBMod.setBackground(Color.GRAY); // COULEUR
        }

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBackground(Color.GRAY); // COULEUR
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBackground(Color.GRAY); // COULEUR
        

        champsPanel.add(listeProdMBSup);
        champsPanel.add(listeProdMBMod);
        champsPanel.add(btnSupprimer);
        champsPanel.add(btnModifier);
        add(champsPanel, BorderLayout.SOUTH);
		
        boutonSupModProduitMB btnSupModProdMB = new boutonSupModProduitMB(hotel, listeProdMBSup, listeProdMBMod);
        btnSupprimer.addActionListener(btnSupModProdMB);
        btnModifier.addActionListener(btnSupModProdMB);
	}

}