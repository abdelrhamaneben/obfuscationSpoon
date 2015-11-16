package package1;

public class Voiture extends AbstractVoiture implements Vehicule{

	private int taille;
	private String marque;
	
	
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public int getKilometrage(){
		return 33;
	}
	
	public String toString(){
		return "vroum";
	}
	
	@Override
	public String klaxon() {
		return "tutut";
	}
	
}
