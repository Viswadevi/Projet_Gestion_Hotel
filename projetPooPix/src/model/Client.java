package model;
import java.util.*;

public class Client {
    public int id_client;
    public String nom;
    public String prenom;
    public String email;
    public String num_tel;
	
	Hotel hotel;
	public Vector <Reservation> ListReservation = new Vector <Reservation>();
	
	public Client (int id, String n, String p, String m, String t){
		id_client = id ;
		nom = n ;
		prenom = p ;
		email = m ;
		num_tel = t ;
	}
	
	public void ajoutReservation (Reservation x){
		ListReservation.add(x) ;
	}
	
	public Client (int id, String n, String p, String m, String t, Hotel h){
		id_client = id ;
		nom = n ;
		prenom = p ;
		email = m ;
		num_tel = t ;
		hotel = h ;
	}
	
	public String toString() {
	    return nom + " " + prenom; // afficher juste le nom et prenom d'un client
	}
}