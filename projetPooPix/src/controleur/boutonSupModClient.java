package controleur;

import javax.swing.*;
import java.awt.event.*;
import model.*;

public class boutonSupModClient implements ActionListener {
    Hotel hotel;
    JComboBox<Client> listeClSup;
    JComboBox<Client> listeClMod;

    public boutonSupModClient(Hotel h, JComboBox<Client> sup, JComboBox<Client> mod) {
        hotel = h;
        listeClSup = sup;
        listeClMod = mod;
    }

    public void actionPerformed(ActionEvent e) {
        if (((JButton)e.getSource()).getText().equals("Supprimer")) {
            Client selected = (Client) listeClSup.getSelectedItem();
        	if (selected != null) {
        		hotel.ListClient.remove(selected); // supprime de la liste
        		listeClSup.removeItem(selected); // supprime de la barre deroulante
        		listeClMod.removeItem(selected);
        		JOptionPane.showMessageDialog(null, "Client supprimé !");
        	}
        }
        if (((JButton)e.getSource()).getText().equals("Modifier")) {
            Client selected = (Client) listeClMod.getSelectedItem();
            if (selected != null) {
            	int oldId = selected.id_client;
                String newId = JOptionPane.showInputDialog("Nouveau ID du client :", selected.id_client);
            	if (newId != null) {	
                	try {
            			selected.id_client = Integer.parseInt(newId);
            			if (selected.id_client != oldId) { // si on a changé l'id on fait la boucle
            				for (Client c : hotel.ListClient) {
            					// si l'id existe déjà, sans compter lui meme
            					if (c.id_client == selected.id_client && c != selected) {
            						selected.id_client = oldId; // il reprend son ancienne valeur
            						JOptionPane.showMessageDialog(null, "ID client déjà existant");
            						return;
            					}
            				}
            			}
            		} catch (NumberFormatException a) {
            			JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.");
            		}
            	}
                String newNom = JOptionPane.showInputDialog("Nouveau nom :", selected.nom);
                String newPrenom = JOptionPane.showInputDialog("Nouveau prénom :", selected.prenom);
                String newEmail = JOptionPane.showInputDialog("Nouveau email :", selected.email);
                String newNumTel = JOptionPane.showInputDialog("Nouveau numero de téléphone :", selected.num_tel);
                if (newNom != null && newPrenom != null && newEmail != null && newNumTel != null) {
                	selected.nom = newNom;
                    selected.prenom = newPrenom;
                    selected.email = newEmail;
                    selected.num_tel = newNumTel;
                    listeClMod.repaint(); // met à jour la modification
                    listeClSup.repaint();
                    JOptionPane.showMessageDialog(null, "Client modifié !");
                }
            }
        }        
    }
}