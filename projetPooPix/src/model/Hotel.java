package model;
import java.util.*;

public class Hotel {
    public String nom;
    public String adr;
	
	public Vector <Chambre> ListChambre = new Vector <Chambre>();
	public Vector <Client> ListClient = new Vector <Client>();
	public Vector <Produit_mini_bar> ListProduit_mini_bar = new Vector <Produit_mini_bar>();
	
	public Hotel (String n, String a){
		nom = n ;
		adr = a;
	}
	
	public void ajoutChambre (Chambre x){
		ListChambre.add(x);
	}
	
	public void ajoutClient (Client x){
		ListClient.add(x);
	}
	
	public void ajoutProduit_mini_bar (Produit_mini_bar x){
		ListProduit_mini_bar.add(x);
	}
	
	public Vector<Produit_mini_bar> getListeProduitsMiniBar() {
	    return ListProduit_mini_bar;
	}

}