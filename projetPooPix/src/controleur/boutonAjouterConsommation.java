package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class boutonAjouterConsommation implements ActionListener{
	JTextField txtIdConso;
	JComboBox<Sejour> sejourBox;
	JComboBox<Produit_mini_bar> produitBox;
	JTextField txtQuantite;
	Hotel hotel;
	
	// constructeur
	public boutonAjouterConsommation(JTextField IdConso, JComboBox<Sejour> sejBox, JComboBox<Produit_mini_bar> prodBox, JTextField q, Hotel h) {
		txtIdConso = IdConso;
		sejourBox = sejBox;
		produitBox = prodBox;
		txtQuantite = q;
		hotel = h;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtIdConso.getText());
			for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
				for (Consommation c : p.ListConsommation) {
					if (c.id_conso == id) {
						JOptionPane.showMessageDialog(null, "ID consommation déjà existant");
						return;
					}
				}
			}
			int quantite = Integer.parseInt(txtQuantite.getText());
			Sejour sejour = (Sejour)sejourBox.getSelectedItem();
			Produit_mini_bar produit = (Produit_mini_bar)produitBox.getSelectedItem();
			
			float total = produit.prix_unitaire * quantite ;
			
			Consommation newConso = new Consommation(id, quantite, total, sejour, produit);
			sejour.ajoutConsommation(newConso);
			produit.ajoutConsommation(newConso);
	        JOptionPane.showMessageDialog(null, "Consommation enregistrée !");
		} catch (NumberFormatException a) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides.");
		}
	}

}