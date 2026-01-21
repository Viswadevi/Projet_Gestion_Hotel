package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import java.util.Date;
import java.time.format.DateTimeParseException;

public class boutonAjouterReservation implements ActionListener {
	JTextField txtIdRes;
	JComboBox<String> jourDebBox;
	JComboBox<String> moisDebBox;
	JComboBox<String> anneeDebBox;
	JComboBox<String> jourFinBox;
	JComboBox<String> moisFinBox;
	JComboBox<String> anneeFinBox;
	ButtonGroup groupeStatut;
	JComboBox<Client> clientBox;
	JComboBox<Chambre> chambreBox;
	Hotel hotel;
	
	// constructeur
	public boutonAjouterReservation(JTextField idRes, JComboBox<String> jdb, JComboBox<String> mdb, 
					JComboBox<String> adb, JComboBox<String> jfb, JComboBox<String> mfb, JComboBox<String> afb, 
					ButtonGroup statutRes, JComboBox<Client> clBox, JComboBox<Chambre> chBox, Hotel h) {
		txtIdRes = idRes;
		jourDebBox = jdb;
		moisDebBox = mdb;
		anneeDebBox = adb;
		jourFinBox = jfb;
		moisFinBox = mfb;
		anneeFinBox = afb;
		groupeStatut = statutRes;
		clientBox = clBox;
		chambreBox = chBox;
		hotel = h;
	}
	
	private boolean estDisponible(Chambre chambre, Date debut, Date fin) {
	    for (Reservation res : chambre.ListReservation) {
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
		try {
		int id = Integer.parseInt(txtIdRes.getText());
		for (Client c : hotel.ListClient) {
			for (Reservation r : c.ListReservation) {
				if (r.id_reserve == id) {
					JOptionPane.showMessageDialog(null, "ID réservation déjà existant");
					return;
				}
			}
		}
		Client newCl = (Client)clientBox.getSelectedItem();
		Chambre newCh = (Chambre)chambreBox.getSelectedItem();
		
	    // Récupérer les dates
	    int jourDeb = Integer.parseInt((String) jourDebBox.getSelectedItem());
	    int moisDeb = Integer.parseInt((String) moisDebBox.getSelectedItem());
	    int anneeDeb = Integer.parseInt((String) anneeDebBox.getSelectedItem());

	    int jourFin = Integer.parseInt((String) jourFinBox.getSelectedItem());
	    int moisFin = Integer.parseInt((String) moisFinBox.getSelectedItem());
	    int anneeFin = Integer.parseInt((String) anneeFinBox.getSelectedItem());

	    Date dateDeb = new Date(anneeDeb - 1900, moisDeb - 1, jourDeb);
	    Date dateFin = new Date(anneeFin - 1900, moisFin - 1, jourFin);

	    if (dateFin.before(dateDeb)) {
	        JOptionPane.showMessageDialog(null, "La date de fin ne peut pas être avant la date de début.");
	        return;
	    }
	    
        if (!estDisponible(newCh, dateDeb, dateFin)) {
            JOptionPane.showMessageDialog(null, "La chambre est déjà réservée à ces dates.");
            return;
        }
	    
		// statut
        String statut = null;
        for (var btn : java.util.Collections.list(groupeStatut.getElements())) { // parcours les types
            if (btn.isSelected()) { // est ce tel bouton selectionné ?
                statut = btn.getText(); // on recupere celui qui est coché
                break;
            }
        }
        
        if (statut == null) {
            JOptionPane.showMessageDialog(null, "Sélectionnez un statut.");
            return;
	    
		}
        
        Reservation newRes = new Reservation(id, dateDeb, dateFin, statut, newCl, newCh);
        newCl.ajoutReservation(newRes);
        newCh.ajoutReservation(newRes);
        JOptionPane.showMessageDialog(null, "Réservation enregistrée !");	
				
		} catch (NumberFormatException a) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides.");
		} catch (DateTimeParseException a) {
    	    JOptionPane.showMessageDialog(null, "Date invalide.");
    	}
	}
}