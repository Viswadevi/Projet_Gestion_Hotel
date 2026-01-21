package controleur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class boutonAjouterChambre implements ActionListener {
    JTextField txtNumCh;
    JTextField txtEtage;
    JTextField txtTarif;
    ButtonGroup groupeType;
    Hotel hotel;
    
    // constructeur
    public boutonAjouterChambre(JTextField numCh, JTextField etageCh, JTextField tarifCh,
                                  ButtonGroup typeCh, Hotel h) {
        txtNumCh = numCh;
        txtEtage = etageCh;
        txtTarif = tarifCh;
        groupeType = typeCh;
        hotel = h;
    }

    public void actionPerformed(ActionEvent e) {
    	try {
        int num = Integer.parseInt(txtNumCh.getText());
        for (Chambre c : hotel.ListChambre) {
        	if (c.numero == num) {
        		JOptionPane.showMessageDialog(null, "Numéro de chambre déjà existant");
        		return;
        	}
    	}
        int etage = Integer.parseInt(txtEtage.getText());
        float tarif = Float.parseFloat(txtTarif.getText());
        
        String type = null;
        for (var btn : java.util.Collections.list(groupeType.getElements())) { // parcours les types
            if (btn.isSelected()) { // est ce tel bouton selectionné ?
                type = btn.getText(); // on recupere celui qui est coché
                break;
            }
        }
        
        if (type == null) {
            JOptionPane.showMessageDialog(null, "Sélectionnez un type de chambre.");
            return;
        }
        
        // crée nouvelle chambre avec valeur qu'on recupère
        Chambre newCh = new Chambre(num, etage, type, tarif, hotel);
        hotel.ajoutChambre(newCh); // ajoute dans l'hotel
        JOptionPane.showMessageDialog(null, "Chambre ajoutée !");
    	} 
    	catch (NumberFormatException a) {
    		JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides.");
    	}
    }        
}