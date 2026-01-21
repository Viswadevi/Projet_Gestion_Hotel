package vue;

import java.awt.*;
import javax.swing.*;
import model.*;
import controleur.*;

public class afficherConsommation extends JPanel{
	Hotel hotel;
	
	public afficherConsommation(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout()); // pour classer nord, centre, ext...
        
        setBackground(Color.LIGHT_GRAY); // COULEUR

        JLabel titre = new JLabel("Enregistrer une consommation", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        add(titre, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // bas: 30px d’espace

        GridLayout grille = new GridLayout(4,2);
        JPanel champsPanel = new JPanel(grille); // Ajuster l'espacement des cellules
        
        champsPanel.setBackground(Color.LIGHT_GRAY);  // COULEUR
        
        // ID consommation (centrer le label et la barre)
        JPanel pIdConso = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pIdConso.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblIdConso = new JLabel("ID consommation :");
        lblIdConso.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtIdConso = new JTextField(20);
        pIdConso.add(lblIdConso);
        pIdConso.add(txtIdConso);
        champsPanel.add(pIdConso);
        
        // sejour concerné (centrer le label et la barre)
        JPanel pSejour = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pSejour.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblSejour = new JLabel("Sejour concerné:");
        lblSejour.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Sejour> listeSej = new JComboBox<>();
        for (Client c : hotel.ListClient) {
            for (Reservation r : c.ListReservation) {
                listeSej.addItem(r.sejour);
            }
        }
        pSejour.add(lblSejour);
        pSejour.add(listeSej);
        champsPanel.add(pSejour);
        
        // produit mini bar consommé (centrer le label et la barre)
        JPanel pProdMB = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pProdMB.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblProdMB = new JLabel("Produit mini bar consommé :");
        lblProdMB.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Produit_mini_bar> listeProdMB = new JComboBox<>();
        for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
        	listeProdMB.addItem(p);
        }
        pProdMB.add(lblProdMB);
        pProdMB.add(listeProdMB);
        champsPanel.add(pProdMB);
        
        // quantité consommée du produit mini bar (centrer le label et la barre)
        JPanel pQuantite = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pQuantite.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblQuantite = new JLabel("Quantité consommée :");
        lblQuantite.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtQuantite = new JTextField(20);
        pQuantite.add(lblQuantite);
        pQuantite.add(txtQuantite);
        champsPanel.add(pQuantite);
        
        add(champsPanel, BorderLayout.CENTER);
        
        // bouton "ajouter"
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAjouter = new JButton("Enregistrer");
        boutonPanel.setBackground(Color.LIGHT_GRAY);  // COULEUR
        btnAjouter.setBackground(Color.GRAY);  // COULEUR
        boutonPanel.add(btnAjouter);
        add(boutonPanel, BorderLayout.SOUTH);
        
        boutonAjouterConsommation conso = new boutonAjouterConsommation(txtIdConso, listeSej, listeProdMB, txtQuantite, hotel);
        btnAjouter.addActionListener(conso);
	}
}