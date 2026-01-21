package model;

public class Main {
	public static void main (String[] args){
		Hotel hotel = new Hotel ("Love", "5 avenue du love");
		
		Chambre chambre1 = new Chambre (1, 2, "luxe", 400, hotel); // chambre associé à l'hotel
		Chambre chambre2 = new Chambre (3, 13, "grand", 300, hotel);
		hotel.ajoutChambre(chambre1);
		hotel.ajoutChambre(chambre2);
		
		Client c1 = new Client (001,"UNG", "Roland", "cambodge@gmail.com", "07XXXXXXXXX", hotel);
		hotel.ajoutClient(c1);
 
		
		Produit_mini_bar oasis = new Produit_mini_bar (001, "oasis", 2, hotel);
		hotel.ajoutProduit_mini_bar(oasis);
		
		//Consommation con1 = new Consommation(3, 6, 1.0,s,NULL);
		//s.ajoutConsommation(con1);
		//oasis.ajoutConsommation(con1);
		
		
	}
}