package model;
import java.util.*;


public class Produit_mini_bar {
    public int id_produit;
    public String nom;
    public float prix_unitaire;	
	Hotel hotel;
	public Vector <Consommation> ListConsommation = new Vector <Consommation>();
	
	public Produit_mini_bar(int id, String n, float p){
		id_produit = id ;
		nom = n ;
		prix_unitaire = p ;
	}
	
	public void ajoutConsommation (Consommation x){
		ListConsommation.add(x);
	}
	
	public Produit_mini_bar(int id, String n, float p, Hotel h){
		id_produit = id ;
		nom = n ;
		prix_unitaire = p ;
		hotel = h ;
	}
	
	public String toString() {
	    return nom; // afficher juste le nom du produit
	}
}