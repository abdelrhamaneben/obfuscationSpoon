package obfusc.obfusc.Controllers;

import obfusc.obfusc.processors.CreateContanteString;
import obfusc.obfusc.processors.NameAccessChanger;
import obfusc.obfusc.processors.NameDeclarationChanger;
import obfusc.obfusc.processors.StringReference;
import obfusc.obfusc.utils.factotyReference;
import spoon.Launcher;

public class App 
{
	/**
	 * l'application prend au moins deux parametres
	 * @param args
	 * args[1] premier input
	 * args[2] premier ouput
	 * args[3] deuxieme input
	 * ...
	 */
    public static void main( String[] args )
    {
    	Launcher spoon ;
    	NameDeclarationChanger NDC;
    	NameAccessChanger NAC;
    	CreateContanteString CCS;
    	StringReference SR;
    	// Ajout des processeurs
    	factotyReference getterName = new factotyReference();
    	
    	// vérification des entrées et sorties définition par défaut 
    	int nbParam = args.length;
    	if(nbParam <= 1) {
    		args = new String[2];
    		System.out.println("Pas d'entrée et sortie renseignées");
    		System.out.println("utilisation des parametres par défault");
    		args[0] = "/Users/abdelrhamanebenhammou/workspace/appliTest/src/appliTest/";
    		args[1] = "/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/output/";
    		
    		System.out.println("Input  : " + args[0]);
    		System.out.println("Output : " + args[1]);
    		nbParam = args.length;
    	}
    	
    	// index des entrées sorties
    	int input = -2;
    	int output = -1;
    	
    	// boucle sur les couples de paramètres
    	for(int i = 1; i <= nbParam/2; i++) {
    		input += 2;
    		output += 2;
    		spoon = new Launcher();
        	// Définition des chemins d'entrée et de sortie
        	// INPUT définition
        	//spoon.addInputResource("/home/m2iagl/benhammou/workspace/OPL/applicationbateau/src/applicationbateau");
        	spoon.addInputResource(args[input]);
        	// OUTPUT définition
        	spoon.setSourceOutputDirectory(args[output]);
     
        	// Définition des processeurs
        	NDC = new NameDeclarationChanger(getterName);
        	NAC = new NameAccessChanger(getterName);
        	CCS = new CreateContanteString(getterName);
        	SR = new StringReference(getterName);
        	
        	// Association à spoon des processeurs
        	spoon.addProcessor(NAC);
        	spoon.addProcessor(NDC);
        	spoon.addProcessor(CCS);
        	spoon.addProcessor(SR);

        	 // Lancement de SPOON
          	 spoon.run();
    	}
    	
    }
}
