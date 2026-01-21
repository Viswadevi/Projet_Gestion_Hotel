package controleur;

import javax.swing.*;
import java.awt.event.*;
import model.*;

public class boutonSupModChambre implements ActionListener {
    Hotel hotel;
    JComboBox<Chambre> listeChSup;
    JComboBox<Chambre> listeChMod;

    public boutonSupModChambre(Hotel h, JComboBox<Chambre> sup, JComboBox<Chambre> mod) {
        hotel = h;
        listeChSup = sup;
        listeChMod = mod;
    }

    public void actionPerformed(ActionEvent e) {

        if (((JButton)e.getSource()).getText().equals("Supprimer")) {
            Chambre selected = (Chambre) listeChSup.getSelectedItem();
            if (selected != null) {
                hotel.ListChambre.remove(selected); // supprime de la liste
                listeChSup.removeItem(selected); // supprime de la barre deroulante
                listeChMod.removeItem(selected);
                JOptionPane.showMessageDialog(null, "Chambre supprimée !");
            }
        }

        if (((JButton)e.getSource()).getText().equals("Modifier")) {
            Chambre selected = (Chambre) listeChMod.getSelectedItem();
            if (selected != null) {
                try {
                	int oldNum = selected.numero;
                    String newNum = JOptionPane.showInputDialog("Nouveau numéro :", selected.numero);
                    if (newNum != null) selected.numero = Integer.parseInt(newNum);
                    if (selected.numero != oldNum) { // si on a changé le numero on fait la boucle
                    	for (Chambre c : hotel.ListChambre) {
                    		// si le numéro existe déjà, sans compter lui meme
                    		if (c.numero == selected.numero && c != selected) {
                    			selected.numero = oldNum; // il reprend son ancienne valeur
                    			JOptionPane.showMessageDialog(null, "Numéro de chambre déjà existant");
                    			return;
                    		}
                    	}
                    }
                    String newEtage = JOptionPane.showInputDialog("Nouvel étage :", selected.etage);
                    if (newEtage != null) selected.etage = Integer.parseInt(newEtage);
                    String newTarif = JOptionPane.showInputDialog("Nouveau tarif :", selected.tarif);
                    if (newTarif != null) selected.tarif = Float.parseFloat(newTarif);

                    // Choix du type via des options
                    String[] types = {"Simple", "Double", "Suite normale", "Suite présidentielle"};
                    String newType = (String) JOptionPane.showInputDialog(
                            null, // pas de parent
                            "Nouveau type de chambre :", // message
                            "Input", // titre
                            JOptionPane.QUESTION_MESSAGE, // icone (ici: ?)
                            null, // pas d'icone personnalisé
                            types, // options dans la file deroulante
                            selected.type // selection par defaut (affiche l'ancien)
                    );

                    if (newType != null) selected.type = newType;

                    listeChMod.repaint();
                    listeChSup.repaint();
                    JOptionPane.showMessageDialog(null, "Chambre modifiée !");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur : Entrez des valeurs valides.");
                }
            }
        }
    }
}