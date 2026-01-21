package model;
import java.util.*;

public class Reservation {
    public int id_reserve;
    public Date date_deb;
    public Date date_fin;
    public String statut;
	public Chambre chambre;
	public Client client; //1
	public Sejour sejour; // 0.1
	
	public Reservation (int id, Date deb, Date fin, String s){
		id_reserve = id ;
		date_deb = deb ;
		date_fin = fin ;
		statut = s ;
	}
	
	public void setSejour (Sejour s){
		sejour = s ;
	}
	
	public Reservation (int id, Date deb, Date fin, String s, Client cl, Chambre ch){
		id_reserve = id ;
		date_deb = deb ;
		date_fin = fin ;
		statut = s ;
		client = cl ;
		chambre = ch;
	}
	
	public String toString() {
		return "ID: " + id_reserve;
	}
}