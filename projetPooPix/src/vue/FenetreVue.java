package vue;

import javax.swing.*; 
import model.*;
import java.util.Vector;
import java.awt.*;

public class FenetreVue extends JFrame {
	
	Hotel hotel;

    // Barre de menu
    JMenuBar menu = new JMenuBar();

    // Menu principaux
    JMenu chambre = new JMenu("Chambre");
    JMenuItem ajoutCh = new JMenuItem("Ajouter une chambre");
    JMenuItem listeCh = new JMenuItem("Liste des chambres");

    JMenu client = new JMenu("Client");
    JMenuItem ajoutCl = new JMenuItem("Ajouter un client");
    JMenuItem listeCl = new JMenuItem("Liste des clients");

    JMenu reservation = new JMenu("Réservation");
    JMenuItem ajoutRes = new JMenuItem("Enregistrer une réservation");
    JMenuItem listeResCl = new JMenuItem("Historique des réservations des clients");

    JMenu sejour = new JMenu("Séjour");
    JMenuItem ajoutSej = new JMenuItem("Créer ou modifier un séjour");
    JMenuItem listeSej = new JMenuItem("Historique des séjours");
    
    JMenu produitMB = new JMenu("Produit mini bar");
    JMenuItem ajoutProdMB = new JMenuItem("Ajouter un produit mini bar");
    JMenuItem listeProdMB = new JMenuItem("Liste des produits mini bar");
    
    JMenu consommation = new JMenu("Consommation");
    JMenuItem ajoutConso = new JMenuItem("Enregistrer une consommation");
    JMenuItem listeConsoProdMB = new JMenuItem("Historique des consommations des produits mini bar");

    // Panel principal (zone centrale qui change selon l'action)
    JPanel mainPanel;

    public FenetreVue(int x, int y, Hotel h) {
    	hotel = h;
        setPreferredSize(new Dimension(x, y));
        setTitle("Gestion de l'hotel");
        
        // Style de la barre de menu
        menu.setBackground(Color.BLACK);
        menu.setForeground(Color.LIGHT_GRAY);

        // Appliquer les couleurs aux menus principaux
        for (JMenu m : new JMenu[]{chambre, client, reservation, sejour, produitMB,consommation}) {
            m.setForeground(Color.LIGHT_GRAY);
            m.setOpaque(true);
            m.setBackground(Color.BLACK);
        }

        // Appliquer les couleurs aux sous-menus
        for (JMenuItem item : new JMenuItem[]{
                ajoutCh, listeCh,
                ajoutCl, listeCl,
                ajoutRes, listeResCl,
                ajoutSej, listeSej,
                ajoutProdMB,listeProdMB,
                ajoutConso, listeConsoProdMB,
        }) {
            item.setForeground(Color.LIGHT_GRAY);
            item.setBackground(Color.BLACK);
            item.setOpaque(true);
        }


        // Initialisation du contenu central
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // menu
        setJMenuBar(menu);
        menu.add(chambre);
        menu.add(client);
        menu.add(reservation);
        menu.add(sejour);
        menu.add(produitMB);
        menu.add(consommation);

        // sous menu
        chambre.add(ajoutCh);
        chambre.add(listeCh);
        client.add(ajoutCl);
        client.add(listeCl);
        reservation.add(ajoutRes);
        reservation.add(listeResCl);
        sejour.add(ajoutSej);
        sejour.add(listeSej);
        produitMB.add(ajoutProdMB);
        produitMB.add(listeProdMB);
        consommation.add(ajoutConso);
        consommation.add(listeConsoProdMB);

        
        ajoutCh.addActionListener(e -> afficherFormulaireChambre()); // clic "Ajouter une chambre"        
        ajoutCl.addActionListener(e ->  afficherFormulaireClient()); // clic "Ajouter un client"
        ajoutRes.addActionListener(e -> afficherFormulaireReservation()); // clic "Enregistrer une reservation"
        ajoutSej.addActionListener(e -> afficherFormulaireSejour()); // clic "Créer ou modifier un séjour"
        ajoutProdMB.addActionListener(e -> afficherFormulaireProduitMB()); // clic "Ajouter un produit mini bar"     
        ajoutConso.addActionListener(e -> afficherFormulaireConsommation()); // clic "Ajouter une consommation"
        
        listeCh.addActionListener(e -> afficherFormulaireListeChambre()); // clic "Liste des chambres"        
        listeCl.addActionListener(e -> afficherFormulaireListeClient()); // clic "Liste des clients"
        listeResCl.addActionListener(e -> afficherFormulaireListeReservationClient()); // clic "Liste des reservations des clients"
        listeSej.addActionListener(e -> afficherFormulaireListeSejour()); // clic "Historique des séjours"
        listeProdMB.addActionListener(e -> afficherFormulaireListeProduitMB());// clic "Liste des produit mini bar"
        listeConsoProdMB.addActionListener(e -> afficherFormulaireListeConsommationProduitMB());// clic "Liste des consommations des produits mini bar"
        
        // Page d'accueil par défaut
        afficherAccueil();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void afficherAccueil() {
        mainPanel.removeAll();
        mainPanel.add(new afficherAccueil(), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }

    private void afficherFormulaireChambre() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherChambre(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireClient() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherClient(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireReservation() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherReservation(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireSejour() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherSejour(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireProduitMB() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherProduitMB(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireConsommation() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherConsommation(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireListeChambre() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherListeChambre(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireListeClient() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherListeClient(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireListeReservationClient() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherListeReservationClient(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireListeSejour() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherListeSejour(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireListeProduitMB() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherListeProduitMB(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }
    
    private void afficherFormulaireListeConsommationProduitMB() {
        mainPanel.removeAll(); // efface l'ancienne page si on change
        mainPanel.add(new afficherListeConsommationProduit(hotel), BorderLayout.CENTER); // affichage
        mainPanel.revalidate();
    }

}