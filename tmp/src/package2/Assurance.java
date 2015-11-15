package package2;

import java.util.ArrayList;
import java.util.List;

public class Assurance {
	
	private String nom;
	private List<Conducteur> clients;
	
	public Assurance(){
		clients = new ArrayList<Conducteur>();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Conducteur> getClients() {
		return clients;
	}
	public void setClients(List<Conducteur> clients) {
		this.clients = clients;
	}
	
	public void addClient(Conducteur c){
		this.clients.add(c);
	}
	
	public List<String> getNomsClients(){
		List<String> noms = new ArrayList<String>();
		for(Conducteur c : clients){
			noms.add(c.getNom());
		}
		return noms;
	}
	
	public int NombrePietons(){
		int cpt = 0;
		for(Conducteur c : clients){
			if(c.isPieton()){
				cpt++;
			}
		}
		return cpt;
	}
}
