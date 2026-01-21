package vue;

import javax.swing.*;
import controleur.*;
import java.awt.*;
import java.util.ArrayList;

import model.*;

public class afficherListeConsommationProduit extends JPanel {
	Hotel hotel;
	
	public afficherListeConsommationProduit(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR

        JLabel titre = new JLabel("Historique des consommations par produit mini bar", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        titre.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0)); // bas: 30px d’espace
        add(titre, BorderLayout.NORTH);
        
        // Compter le total de consommations pour toutes les lignes du tableau
        ArrayList<Consommation> toutesConsommations = new ArrayList<>();
        for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
            toutesConsommations.addAll(p.ListConsommation);
        }
        String[] colonnes = {"ID Consommation", "Produit mini bar", "Séjour concerné", "quantité consommé", "montant total"};
        Object[][] donnees = new Object[toutesConsommations.size()][5];
        
        int i = 0;
        for (Consommation conso : toutesConsommations) {
        	donnees[i][0] = conso.id_conso;
        	donnees[i][1] = conso.produit_mini_bar;
        	donnees[i][2] = conso.sejour;
        	donnees[i][3] = conso.quantite;
        	donnees[i][4] = conso.total;
        	i++;
        }
        
        JTable tableau = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableau);
        add(scrollPane, BorderLayout.CENTER);
        
        // pour supprimer et modifier
        GridLayout grille = new GridLayout(2,2);
        JPanel champsPanel = new JPanel(grille);
        
        JComboBox<Consommation> listeConsoSup = new JComboBox<>(); // liste pour supprimer
        for (Produit_mini_bar pmb : hotel.ListProduit_mini_bar) {
        	for (Consommation c : pmb.ListConsommation) {
        		listeConsoSup.addItem(c);
        	}
        }
        
        JComboBox<Consommation> listeConsoMod = new JComboBox<>(); // liste pour supprimer
        for (Produit_mini_bar pmb : hotel.ListProduit_mini_bar) {
        	for (Consommation c : pmb.ListConsommation) {
        		listeConsoMod.addItem(c);
        	}
        }

        JButton btnSupprimer = new JButton("Annuler");
        btnSupprimer.setBackground(Color.GRAY); // COULEUR
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBackground(Color.GRAY); // COULEUR
        

        champsPanel.add(listeConsoSup);
        champsPanel.add(listeConsoMod);
        champsPanel.add(btnSupprimer);
        champsPanel.add(btnModifier);
        add(champsPanel, BorderLayout.SOUTH);
        
        boutonSupModConsommation btnSupModConso = new boutonSupModConsommation(hotel, listeConsoSup, listeConsoMod);
        btnSupprimer.addActionListener(btnSupModConso);
        btnModifier.addActionListener(btnSupModConso);
	}

}