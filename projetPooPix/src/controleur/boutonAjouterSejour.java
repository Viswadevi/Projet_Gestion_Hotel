package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class boutonAjouterSejour implements ActionListener {
	JTextField txtIdSej;
	JComboBox<Reservation> reservationBox;
	JCheckBox boxPayee;
	Hotel hotel;
	
	public boutonAjouterSejour(JTextField idSej, JComboBox<Reservation> resBox, JCheckBox p, Hotel h) {
		txtIdSej = idSej;
		reservationBox = resBox;
		boxPayee = p;
		hotel = h;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtIdSej.getText());
			Reservation newRes = (Reservation)reservationBox.getSelectedItem();
			for (Client c : hotel.ListClient) {
				for (Reservation r : c.ListReservation) {
					// si l'id existe déjà alors que c'est pas la même réservation
					if (r.sejour != null && r.sejour.id_sejour == id && r != newRes) {
		        		JOptionPane.showMessageDialog(null, "ID séjour déjà existant");
		        		return;
					}
				}
			}
			boolean payee = boxPayee.isSelected();			
        	
        	Sejour newSej = new Sejour(id, payee, newRes);
        	newRes.setSejour(newSej);
            JOptionPane.showMessageDialog(null, "Séjour validé !");	
			
		} catch (NumberFormatException a) {
			JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides.");
		}
	}
}