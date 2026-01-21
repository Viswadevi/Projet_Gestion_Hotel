package vue;

import java.awt.*;
import javax.swing.*;
import model.*;
import controleur.*;

public class afficherClient extends JPanel {	
	Hotel hotel;
	
	public afficherClient(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout()); // pour classer nord, centre, ext...
        
        setBackground(Color.LIGHT_GRAY); // COULEUR
        
        JLabel titre = new JLabel("Ajouter un client", JLabel.CENTER); 
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        add(titre, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // bas: 30px d’espace

        GridLayout grille = new GridLayout(6,2);
        JPanel champsPanel = new JPanel(grille); // Ajuster l'espacement des cellules
        
        champsPanel.setBackground(Color.LIGHT_GRAY);  // Définir le fond // COULEUR pour ce panneau
        
        // ID du client (centrer le label et la barre)
        JPanel pIdCl = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pIdCl.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblIdCl = new JLabel("Numéro d'identification :");
        lblIdCl.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtIdCl = new JTextField(50); // longueur horizontale de la zone blanche
        pIdCl.add(lblIdCl);
        pIdCl.add(txtIdCl);
        champsPanel.add(pIdCl);
        
        // Nom du client (centrer le label et la barre)
        JPanel pNomCl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pNomCl.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblNomCl = new JLabel("Nom :");
        lblNomCl.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtNomCl = new JTextField(50);
        pNomCl.add(lblNomCl);
        pNomCl.add(txtNomCl);
        champsPanel.add(pNomCl);
        
        // Prenom du client (centrer le label et la barre)
        JPanel pPrenomCl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pPrenomCl.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblPrenomCl = new JLabel("Prenom :");
        lblPrenomCl.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtPrenomCl = new JTextField(50);
        pPrenomCl.add(lblPrenomCl);
        pPrenomCl.add(txtPrenomCl);
        champsPanel.add(pPrenomCl);

        // Email du client (centrer le label et la barre)
        JPanel pEmailCl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pEmailCl.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblEmailCl = new JLabel("Email :");
        lblEmailCl.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtEmailCl = new JTextField(50);
        pEmailCl.add(lblEmailCl);
        pEmailCl.add(txtEmailCl);
        champsPanel.add(pEmailCl);
        
        // Numero telephone du client (centrer le label et la barre)
        JPanel pNumTelCl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pNumTelCl.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblNumTelCl = new JLabel("Numéro de téléphone :");
        lblNumTelCl.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtNumTelCl = new JTextField(50);
        pNumTelCl.add(lblNumTelCl);
        pNumTelCl.add(txtNumTelCl);
        champsPanel.add(pNumTelCl);
              
        add(champsPanel, BorderLayout.CENTER); // centrer le tout (ID ,nom ,prenom ,email, num)

        // Bouton "ajouter"
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAjouter = new JButton("Ajouter");
        boutonPanel.setBackground(Color.LIGHT_GRAY);  // COULEUR
        btnAjouter.setBackground(Color.GRAY); // COULEUR
        boutonPanel.add(btnAjouter);
        add(boutonPanel, BorderLayout.SOUTH);
        
        boutonAjouterClient cl = new boutonAjouterClient(txtIdCl, txtNomCl, txtPrenomCl, txtEmailCl, txtNumTelCl, hotel);
        btnAjouter.addActionListener(cl);;
		}

}