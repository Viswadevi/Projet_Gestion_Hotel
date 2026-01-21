package model;
import java.util.*;


public class Chambre {
    public int numero;
    public int etage;
    public String type;
    public float tarif;	
	public Vector <Reservation> ListReservation = new Vector <Reservation>();
	Hotel hotel;
	
	public Chambre (int n, int e, String ty, float ta){ 
		numero = n ;
		etage = e ;
		type = ty ;
		tarif = ta ;
	}
	
	public void ajoutReservation (Reservation x){
		ListReservation.add(x) ;
	}
		
	public Chambre (int n, int e, String ty, float ta, Hotel h){ 
		numero = n ;
		etage = e ;
		type = ty ;
		tarif = ta ;
		hotel = h ;
	}
	
	public String toString() {
	    return "Chambre " + numero; // afficher juste le numéro de la chambre
	}

}