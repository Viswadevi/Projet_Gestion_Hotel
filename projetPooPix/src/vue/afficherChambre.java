package vue;

import java.awt.*;
import javax.swing.*;
import model.*;
import controleur.*;

public class afficherChambre extends JPanel {	
	Hotel hotel;
	
	public afficherChambre(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout()); // pour classer nord, centre, ext...
        
        setBackground(Color.LIGHT_GRAY); // COULEUR
        //setOpaque(true);

        JLabel titre = new JLabel("Ajouter une chambre", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        add(titre, BorderLayout.NORTH);
        
        // Bordure autour de l'ensemble
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // bas: 30px d’espace

        GridLayout grille = new GridLayout(5,2);
        JPanel champsPanel = new JPanel(grille); // Ajuster l'espacement des cellules
        
        champsPanel.setBackground(Color.LIGHT_GRAY);  // COULEUR
        
        // Numéro de chambre (centrer le label et la barre)
        JPanel pNumCh = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pNumCh.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblNumCh = new JLabel("Numéro de chambre :");
        lblNumCh.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtNumCh = new JTextField(50); // longueur horizontale de la zone blanche
        pNumCh.add(lblNumCh);
        pNumCh.add(txtNumCh);
        champsPanel.add(pNumCh);
        
        // Étage (centrer le label et la barre)
        JPanel pEtage = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pEtage.setBackground(Color.LIGHT_GRAY); // COULEUR
        JLabel lblEtage = new JLabel("Étage :");
        lblEtage.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtEtage = new JTextField(50);
        pEtage.add(lblEtage);
        pEtage.add(txtEtage);
        champsPanel.add(pEtage);
        
        // Tarif (centrer le label et la barre)
        JPanel pTarif = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pTarif.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblTarif = new JLabel("Tarif :");
        lblTarif.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtTarif = new JTextField(50);
        pTarif.add(lblTarif);
        pTarif.add(txtTarif);
        champsPanel.add(pTarif);
        
        // Type de chambre (centrer le label et la barre)
        JPanel pTypeCh = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pTypeCh.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JLabel lblTypeCh = new JLabel("Type de chambre :");
        lblTypeCh.setFont(new Font("Arial", Font.BOLD, 18));
        lblTypeCh.setBackground(Color.LIGHT_GRAY);  // COULEUR
        JRadioButton typeDouble = new JRadioButton("Double");
        typeDouble.setFont(new Font("Arial", Font.BOLD, 18));
        typeDouble.setBackground(Color.LIGHT_GRAY); // COULEUR
        JRadioButton typeSimple = new JRadioButton("Simple");
        typeSimple.setFont(new Font("Arial", Font.BOLD, 18));
        typeSimple.setBackground(Color.LIGHT_GRAY); // COULEUR
        JRadioButton typeSuiteN = new JRadioButton("Suite normale");
        typeSuiteN.setFont(new Font("Arial", Font.BOLD, 18));
        typeSuiteN.setBackground(Color.LIGHT_GRAY); // COULEUR
        JRadioButton typeSuiteP = new JRadioButton("Suite présidentielle");
        typeSuiteP.setFont(new Font("Arial", Font.BOLD, 18));
        typeSuiteP.setBackground(Color.LIGHT_GRAY);; // COULEUR
        
        // Regrouper les boutons pour une sélection unique
        ButtonGroup groupeType = new ButtonGroup();
        groupeType.add(typeDouble);
        groupeType.add(typeSimple);
        groupeType.add(typeSuiteN);
        groupeType.add(typeSuiteP);
        
        // afficher les boutons
        pTypeCh.add(lblTypeCh);
        pTypeCh.add(typeDouble);
        pTypeCh.add(typeSimple);
        pTypeCh.add(typeSuiteN);
        pTypeCh.add(typeSuiteP);
        champsPanel.add(pTypeCh);
        
        add(champsPanel, BorderLayout.CENTER); // centrer le tout (num, etage, tarif, type)

        // Bouton "ajouter"
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAjouter = new JButton("Ajouter");
        boutonPanel.setBackground(Color.LIGHT_GRAY); // COULEUR
        btnAjouter.setBackground(Color.GRAY); // COULEUR
        boutonPanel.add(btnAjouter);
        add(boutonPanel, BorderLayout.SOUTH);
	
        
    boutonAjouterChambre ch = new boutonAjouterChambre(txtNumCh, txtEtage, txtTarif, groupeType, hotel);
    btnAjouter.addActionListener(ch);;
	}

}