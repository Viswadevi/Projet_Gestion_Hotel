package controleur;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import model.*;

public class boutonSupModConsommation implements ActionListener {
	Hotel hotel;
	JComboBox<Consommation> listeConsoSup;
	JComboBox<Consommation> listeConsoMod;
	
	public boutonSupModConsommation(Hotel h, JComboBox<Consommation> sup, JComboBox<Consommation> mod) {
		hotel = h;
		listeConsoSup = sup;
		listeConsoMod = mod;
	}
	
	public void actionPerformed(ActionEvent e) {
        if (((JButton)e.getSource()).getText().equals("Annuler")) {
            Consommation selected = (Consommation) listeConsoSup.getSelectedItem();
            if (selected != null) {
                selected.produit_mini_bar.ListConsommation.remove(selected);
                selected.sejour.ListConsommation.remove(selected);
                listeConsoSup.removeItem(selected); // supprime de la barre deroulante
                listeConsoMod.removeItem(selected);
                JOptionPane.showMessageDialog(null, "Consommation annulée !");
            }
        }
        if (((JButton)e.getSource()).getText().equals("Modifier")) {
            Consommation selected = (Consommation) listeConsoMod.getSelectedItem();
            if (selected != null) {
            	try {
            		// Modifier l'ID
            		int oldId = selected.id_conso;
            		String newId = JOptionPane.showInputDialog("Nouvel ID :", selected.id_conso);
                    if (newId != null) selected.id_conso = Integer.parseInt(newId);
                    if (selected.id_conso != oldId) {
                    	for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
                    		for (Consommation c : p.ListConsommation) {
                    			// si l'id existe déjà, sans compter lui meme
                    			if (c.id_conso == selected.id_conso && c != selected) {
                    				selected.id_conso = oldId; // il reprend son ancienne valeur
            						JOptionPane.showMessageDialog(null, "ID consommation déjà existant");
            						return;
                    			}
                    		}
                    	}
                    }
                    
                    // Modifier la quantité
                    String newQuantite = JOptionPane.showInputDialog("Nouvelle quantité :", selected.quantite);
                    if (newQuantite != null) selected.quantite = Integer.parseInt(newQuantite);
                    
                    // Modifier sejour
                    ArrayList<Sejour> toutSejours = new ArrayList<>();
                    for (Client c : hotel.ListClient) {
                        for (Reservation r : c.ListReservation) {
                        	toutSejours.add(r.sejour);        	
                        }
                    }
                    Sejour newSejour = (Sejour) JOptionPane.showInputDialog( 
                    		null, "Nouveau séjour :", "Choix séjour", 
                    		JOptionPane.QUESTION_MESSAGE, null, 
                    		toutSejours.toArray(), selected.sejour);
                    if (newSejour != null && newSejour != selected.sejour) {
                    	selected.sejour.ListConsommation.remove(selected);
                    	newSejour.ajoutConsommation(selected);
                    	selected.sejour = newSejour;
                    }
                    
                    // Modifier produit mini bar
                    Produit_mini_bar newProdMB = (Produit_mini_bar) JOptionPane.showInputDialog(
                    		null, "Nouveau produit mini bar", "Chois produit mini bar",
                    		JOptionPane.QUESTION_MESSAGE, null, 
                    		hotel.ListProduit_mini_bar.toArray(), selected.produit_mini_bar);
                    if (newProdMB != null && newProdMB != selected.produit_mini_bar) {
                    	selected.produit_mini_bar.ListConsommation.remove(selected);
                    	newProdMB.ajoutConsommation(selected);;
                    	selected.produit_mini_bar = newProdMB;
                    }
                    
                    selected.total = selected.produit_mini_bar.prix_unitaire * selected.quantite;
                    
                    listeConsoSup.repaint(); // met à jour la barre déroulante
                    listeConsoMod.repaint();
                    JOptionPane.showMessageDialog(null, "Consommation modifiée !");
            	} catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "Erreur de saisie : vérifiez les valeurs.");
            	}
            }
        }
	}

}