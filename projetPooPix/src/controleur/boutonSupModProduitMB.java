package controleur;

import javax.swing.*;
import java.awt.event.*;
import model.*;

public class boutonSupModProduitMB implements ActionListener {
	Hotel hotel;
	JComboBox<Produit_mini_bar> listeProdMBSup;
	JComboBox<Produit_mini_bar> listeProdMBMod;
	
	public boutonSupModProduitMB(Hotel h, JComboBox<Produit_mini_bar> sup, JComboBox<Produit_mini_bar> mod) {
		hotel = h;
		listeProdMBSup = sup;
		listeProdMBMod = mod;
	}
	
    public void actionPerformed(ActionEvent e) {
        if (((JButton)e.getSource()).getText().equals("Supprimer")) {
            Produit_mini_bar selected = (Produit_mini_bar) listeProdMBSup.getSelectedItem();
        	if (selected != null) {
        		hotel.ListProduit_mini_bar.remove(selected); // supprime de la liste
        		listeProdMBSup.removeItem(selected); // supprime de la barre deroulante
        		listeProdMBMod.removeItem(selected);
        		JOptionPane.showMessageDialog(null, "Produit mini bar supprimé !");
        	}
        }
        if (((JButton)e.getSource()).getText().equals("Modifier")) {
            Produit_mini_bar selected = (Produit_mini_bar) listeProdMBMod.getSelectedItem();
            if (selected != null) {
            	int oldId = selected.id_produit;
                String newId = JOptionPane.showInputDialog("Nouveau ID du produit mini bar :", selected.id_produit);
            	if (newId != null) {	
                	try { 
            			selected.id_produit = Integer.parseInt(newId);
            			for (Produit_mini_bar p : hotel.ListProduit_mini_bar) {
            				// si l'id existe déjà, sans compter lui meme
            				if (p.id_produit == selected.id_produit && p != selected) {
            					selected.id_produit = oldId; // il reprend son ancienne valeur
            					JOptionPane.showMessageDialog(null, "ID produit mini bar déjà existant");
            					return;
            				}
            			}
            		} catch (NumberFormatException a) {
            			JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.");
            		}
            	}
                String newNom = JOptionPane.showInputDialog("Nouveau nom :", selected.nom);
                if (newNom != null) {
                	selected.nom = newNom;
                String saisiePrix = JOptionPane.showInputDialog("Nouveau prix du produit mini bar :", selected.prix_unitaire);
                if (saisiePrix != null) {	
                    try {
                		float newPrix = Float.parseFloat(saisiePrix);
                		selected.prix_unitaire = newPrix;
                	} catch (NumberFormatException a) {
                		JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.");
                	}
                }
                    listeProdMBMod.repaint(); // met à jour la modification
                    listeProdMBSup.repaint();
                    JOptionPane.showMessageDialog(null, "Produit mini bar modifié !");
                }
            }
        }
    }
}