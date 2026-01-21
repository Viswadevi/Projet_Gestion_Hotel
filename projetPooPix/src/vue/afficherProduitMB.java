package vue;

import java.awt.*;
import javax.swing.*;
import model.*;
import controleur.*;

public class afficherProduitMB extends JPanel {
	Hotel hotel;
	
	public afficherProduitMB(Hotel h) {
		hotel = h;
		setLayout(new BorderLayout()); // pour classer nord, centre, ext...
		
		setBackground(Color.LIGHT_GRAY); // COULEUR
        //setOpaque(true);

        JLabel titre = new JLabel("Ajouter un produit du mini bar", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        add(titre, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0)); // bas: 40px d’espace
        
        GridLayout grille = new GridLayout(3,2);
        JPanel champsPanel = new JPanel(grille); // Ajuster l'espacement des cellules
        
        champsPanel.setBackground(Color.LIGHT_GRAY);  // Définir le fond // COULEUR pour ce panneau
        
        // ID du produit (centrer le label et la barre)
        JPanel pIdProd = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pIdProd.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblIdProd = new JLabel("ID du produit :");
        lblIdProd.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtIdProd = new JTextField(50); // longueur horizontale de la zone blanche
        pIdProd.add(lblIdProd);
        pIdProd.add(txtIdProd);
        champsPanel.add(pIdProd);
        
        // Nom du produit (centrer le label et la barre)
        JPanel pNomProd = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pNomProd.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblNomProd = new JLabel("Nom du produit :");
        lblNomProd.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtNomProd = new JTextField(50); // longueur horizontale de la zone blanche
        pNomProd.add(lblNomProd);
        pNomProd.add(txtNomProd);
        champsPanel.add(pNomProd);
        
        // Prix unitaire du produit (centrer le label et la barre)
        JPanel pPrixUniProd = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pPrixUniProd.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblPrixUniProd = new JLabel("Prix unitaire :");
        lblPrixUniProd.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtPrixUniProd = new JTextField(50); // longueur horizontale de la zone blanche
        pPrixUniProd.add(lblPrixUniProd);
        pPrixUniProd.add(txtPrixUniProd);
        champsPanel.add(pPrixUniProd);
        
        add(champsPanel, BorderLayout.CENTER); // centrer le tout (id, nom, prix)
        
        // Bouton "ajouter"
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAjouter = new JButton("Ajouter");
        boutonPanel.setBackground(Color.LIGHT_GRAY); // COULEUR
        btnAjouter.setBackground(Color.GRAY); // COULEUR
        boutonPanel.add(btnAjouter);
        add(boutonPanel, BorderLayout.SOUTH);
        
    boutonAjouterProduitMB prod = new boutonAjouterProduitMB(txtIdProd, txtNomProd, txtPrixUniProd, hotel);
    btnAjouter.addActionListener(prod);
	}

}