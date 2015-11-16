import java.util.ArrayList;
import java.util.List;

import package1.AbstractVoiture;
import package1.Voiture;
import package2.Assurance;
import package2.Conducteur;

public class main {

	public static void main(String[] args) {
		
		Assurance a = new Assurance();
		Conducteur c1 = new Conducteur();
		Conducteur c2 = new Conducteur();
		Voiture v1 = new Voiture();
		AbstractVoiture v2 = new Voiture();
		
		
		System.out.println(v2.getKilometrage());
		
		a.addClient(c1);
		a.addClient(c2);
		
		v1.setMarque("Volvo");
		a.setNom("MMA");
		c1.setAge(22);
		c1.setNom("Jean");
		c1.addVoiture(v1);
		
		System.out.println(c1.getNom()+" a une voiture de marque "+v1.getMarque()+" et est assuré chez "+a.getNom()+" qui a "+a.NombrePietons()+" pietons.");
		
	}
}
