package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class boutonAjouterClient implements ActionListener {
	JTextField txtIdCl;
	JTextField txtNomCl;
	JTextField txtPrenomCl;
	JTextField txtEmailCl;
	JTextField txtNumTelCl;
	Hotel hotel;
	
	// constructeur
	public boutonAjouterClient(JTextField idCl, JTextField nomCl, JTextField prenomCl,
								JTextField email, JTextField numTelCl, Hotel h) {
		txtIdCl = idCl;
		txtNomCl = nomCl;
		txtPrenomCl = prenomCl;
		txtEmailCl = email;
		txtNumTelCl = numTelCl;
		hotel = h;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
		int id = Integer.parseInt(txtIdCl.getText());
        for (Client c : hotel.ListClient) {
        	if (c.id_client == id) {
        		JOptionPane.showMessageDialog(null, "ID client déjà existant");
        		return;
        	}
    	}
		String nom = txtNomCl.getText();
		String prenom = txtPrenomCl.getText();
		String email = txtEmailCl.getText();
		String numTel = txtNumTelCl.getText();
		
		// crée nouveau client avec valeurs qu'on recupère
		Client newCl = new Client(id, nom, prenom, email, numTel, hotel);
		hotel.ajoutClient(newCl);
		JOptionPane.showMessageDialog(null, "Client ajouté !");
		}
		catch (NumberFormatException a) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides.");
		}		
	}
}