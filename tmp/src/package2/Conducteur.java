package package2;

import java.util.List;

import package1.Voiture;

public class Conducteur {
	
	enum Civilite {MADAME, MADEMOISELLE, MONSIEUR} ;  
    private Civilite civilite = Civilite.MADAME ;
	private String nom;
	private int age;
	private List<Voiture> voitures;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	
	public List<Voiture> getVoitures() {
		return voitures;
	}
	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	
	public boolean isPieton(){
		if(voitures.size() == 0){
			return true;
		}
		return false;
	}
	
	public boolean voitureUnique(){
		if(voitures.size() == 1){
			return true;
		}
		return false;
	}

	@Override
	public String toString(){
		return this.nom;
	}
	
	
	public void setMarqueVoituresEtAge(String marque, int age){
		this.age = age;
		for(Voiture v : voitures){
			v.setMarque(marque);
		}
	}
}

