package model;
import java.util.*;


public class Sejour {
    public int id_sejour;
    public boolean est_payee;	
    public Reservation reservation;
	public Vector <Consommation> ListConsommation = new Vector <Consommation>();
	
	public Sejour (int id, boolean p){
		id_sejour = id ;
		est_payee = p ;
	}
	
	public void ajoutConsommation (Consommation x){
		ListConsommation.add(x);
	}
	
	public Sejour (int id, boolean p, Reservation r){
		id_sejour = id ;
		est_payee = p ;
		reservation = r ;
	}
	
	public String toString() {
		return "ID :" + id_sejour;
	}
}