package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class boutonAjouterProduitMB implements ActionListener {
	JTextField txtIdProd;
	JTextField txtNomProd;
	JTextField txtPrixUniProd;
	Hotel hotel;
	
	// constructeur
	public boutonAjouterProduitMB(JTextField idProd, JTextField nomProd, JTextField prixUniProd, Hotel h) {
		txtIdProd = idProd;
		txtNomProd = nomProd;
		txtPrixUniProd = prixUniProd;
		hotel = h;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
		int id = Integer.parseInt(txtIdProd.getText());
        for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
        	if (p.id_produit == id) {
        		JOptionPane.showMessageDialog(null, "ID produit mini bar déjà existant");
        		return;
        	}
    	}
		String nom = txtNomProd.getText();
		float prix = Float.parseFloat(txtPrixUniProd.getText());
		
		// crée nouveau produit mini bar avec valeurs qu'on recupère
		Produit_mini_bar newProdMB = new Produit_mini_bar(id, nom, prix, hotel);
		hotel.ajoutProduit_mini_bar(newProdMB);
		JOptionPane.showMessageDialog(null, "Produit mini bar ajouté !");
		}
		catch (NumberFormatException a) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides.");
		}
	}
}