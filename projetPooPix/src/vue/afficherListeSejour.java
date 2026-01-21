package vue;

import javax.swing.*;
import controleur.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.*;

public class afficherListeSejour extends JPanel {
	Hotel hotel;
	
	public afficherListeSejour(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout());
        
        setBackground(Color.LIGHT_GRAY); // COULEUR
        
        JLabel titre = new JLabel("Historique des séjours", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 24));
        titre.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0)); // bas: 30px d’espace
        add(titre, BorderLayout.NORTH);
        
        ArrayList<Sejour> toutSejours = new ArrayList<>();
        for (Client c : hotel.ListClient) {
        	for (Reservation r : c.ListReservation) {
        		toutSejours.add(r.sejour);
        	}
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String[] colonnes = {"ID du séjour", "date", "client", "chambre",
        		"montant total chambre", "montant total consommation",
        		"montant total séjour", "statut de paiement"};
        Object[][] donnees = new Object[toutSejours.size()][8];
        
        int i = 0;
        for (Sejour sej : toutSejours) {
        	if (sej != null) {
        	donnees[i][0] = sej.id_sejour;
        	donnees[i][1] = "Du " + sdf.format(sej.reservation.date_deb) + 
        					" au " + sdf.format(sej.reservation.date_fin);
        	donnees[i][2] = sej.reservation.client;
        	donnees[i][3] = sej.reservation.chambre + " " + sej.reservation.chambre.type;
        	long diff = sej.reservation.date_fin.getTime() - sej.reservation.date_deb.getTime();
        	int nbNuits = (int) (diff / (1000 * 60 * 60 * 24)); // conversion ms -> jours
        	float montantChambre = nbNuits * sej.reservation.chambre.tarif;
        	donnees[i][4] = montantChambre;
        	
            float somme = 0;
            for (Consommation co : sej.ListConsommation ) {
               somme += co.total;
            }
        	donnees[i][5] = somme;
        	donnees[i][6] = montantChambre + somme;
        	if (sej.est_payee) {
        		donnees[i][7] = "payé";
        	} else donnees[i][7] = "non payé";
        	i++;}
        }
        
        JTable tableau = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableau);
        add(scrollPane, BorderLayout.CENTER);
	}
}