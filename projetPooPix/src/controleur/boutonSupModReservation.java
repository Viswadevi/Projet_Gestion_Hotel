package controleur;

import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.*;

public class boutonSupModReservation implements ActionListener {
    Hotel hotel;
    JComboBox<Reservation> listeResSup;
    JComboBox<Reservation> listeResMod;

    public boutonSupModReservation(Hotel h, JComboBox<Reservation> sup, JComboBox<Reservation> mod) {
        hotel = h;
        listeResSup = sup;
        listeResMod = mod;
    }
    
	private boolean estDisponible(Chambre chambre, Date debut, Date fin, Reservation actuelle) {
	    for (Reservation res : chambre.ListReservation) {
	    	if (res == actuelle) continue; // on ignore la réservation qu'on est en train de modifier
	    	
	        Date debutExistante = res.date_deb;
	        Date finExistante = res.date_fin;

	        // Chevauchement
	        if (!(fin.before(debutExistante) || debut.after(finExistante))) {
	            return false;
	        }
	    }
	    return true;
	}

    public void actionPerformed(ActionEvent e) {
    	
        if (((JButton)e.getSource()).getText().equals("Annuler")) {
            Reservation selected = (Reservation) listeResSup.getSelectedItem();
            if (selected != null) {
                selected.client.ListReservation.remove(selected);
                selected.chambre.ListReservation.remove(selected);
                listeResSup.removeItem(selected); // supprime de la barre deroulante
                listeResMod.removeItem(selected);
                JOptionPane.showMessageDialog(null, "Réservation annulée !");
            }
        }
    	
        if (((JButton)e.getSource()).getText().equals("Modifier")) {
        Reservation selected = (Reservation) listeResMod.getSelectedItem();
        if (selected != null) {
            try {
                // Modifier ID
            	int oldId = selected.id_reserve;
                String newId = JOptionPane.showInputDialog("Nouvel ID :", selected.id_reserve);
                if (newId != null) selected.id_reserve = Integer.parseInt(newId);
                if (selected.id_reserve != oldId) { // si on a changé l'ID on fait la boucle
                	for (Client c : hotel.ListClient) {
                		for (Reservation r : c.ListReservation) {
                			// si l'id existe déjà, sans compter lui même
                			if (r.id_reserve == selected.id_reserve && r != selected) {
                				selected.id_reserve = oldId; // il reprend son ancienne valeur
                				JOptionPane.showMessageDialog(null, "ID réservation déjà existant");
                				return;
                			}
                		}
                	}
                }

                // Modifier client
                Client newClient = (Client) JOptionPane.showInputDialog(
                    null, "Nouveau client :", "Choix client",
                    JOptionPane.QUESTION_MESSAGE, null,
                    hotel.ListClient.toArray(), selected.client);
                if (newClient != null && newClient != selected.client) {
                    selected.client.ListReservation.remove(selected);
                    newClient.ajoutReservation(selected);
                    selected.client = newClient;
                }

                // Modifier chambre
                Chambre newChambre = (Chambre) JOptionPane.showInputDialog(
                    null, "Nouvelle chambre :", "Choix chambre",
                    JOptionPane.QUESTION_MESSAGE, null,
                    hotel.ListChambre.toArray(), selected.chambre);
                if (newChambre != null && newChambre != selected.chambre) {
                    selected.chambre.ListReservation.remove(selected);
                    newChambre.ajoutReservation(selected);
                    selected.chambre = newChambre;
                }

                // Modifier dates
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dateDeb = JOptionPane.showInputDialog("Nouvelle date de début (jj/mm/aaaa) :", sdf.format(selected.date_deb));
                String dateFin = JOptionPane.showInputDialog("Nouvelle date de fin (jj/mm/aaaa) :", sdf.format(selected.date_fin));

                Date newDeb = (dateDeb != null) ? sdf.parse(dateDeb) : selected.date_deb;
                Date newFin = (dateFin != null) ? sdf.parse(dateFin) : selected.date_fin;

                if (newFin.before(newDeb)) {
                    JOptionPane.showMessageDialog(null, "Erreur : la date de fin ne peut pas être avant la date de début.");
                    return;
                }
                
                if (!estDisponible(selected.chambre, newDeb, newFin, selected)) {
                    JOptionPane.showMessageDialog(null, "La chambre est déjà réservée à ces dates.");
                    return;
                }

                selected.date_deb = newDeb;
                selected.date_fin = newFin;

                // Modifier statut
                String[] statuts = {"en attente", "validée", "terminée"};
                String newStatut = (String) JOptionPane.showInputDialog(
                        null, "Nouveau statut :", "Choix statut",
                        JOptionPane.QUESTION_MESSAGE, null,
                        statuts, selected.statut);
                if (newStatut != null) selected.statut = newStatut;

                listeResMod.repaint(); // met à jour la barre déroulante
                JOptionPane.showMessageDialog(null, "Réservation modifiée !");
            } catch (NumberFormatException | ParseException a) {
                JOptionPane.showMessageDialog(null, "Erreur de saisie : vérifiez les valeurs.");
            }
        }
        }
    }
}