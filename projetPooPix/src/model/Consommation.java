package model;

public class Consommation {
	public int id_conso;
    public int quantite;
    public float total;
	
	public Sejour sejour;
	public Produit_mini_bar produit_mini_bar;
	
	public Consommation (int id, int q, float t){
		id_conso = id;
		quantite = q ;
		total = t ;
	}
	
	public Consommation (int id, int q, float t, Sejour s, Produit_mini_bar pmb){
		id_conso = id;
		quantite = q ;
		total = t ;
		sejour = s ;
		produit_mini_bar = pmb ;
	}
	
	public String toString() {
		return "ID: " + id_conso + " --- " + quantite + " " + produit_mini_bar.nom;
	}
}