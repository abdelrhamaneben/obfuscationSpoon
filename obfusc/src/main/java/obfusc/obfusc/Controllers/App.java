package obfusc.obfusc.Controllers;

import obfusc.obfusc.processors.CreateContanteString;
import obfusc.obfusc.processors.NameAccessChanger;
import obfusc.obfusc.processors.NameDeclarationChanger;
import obfusc.obfusc.processors.StringReference;
import obfusc.obfusc.utils.factotyReference;
import spoon.Launcher;

public class App 
{
    public static void main( String[] args )
    {
    	Launcher spoon = new Launcher();
    	// Définition des chemins d'entrée et de sortie
    	// INPUT définition
    	//spoon.addInputResource("/home/m2iagl/benhammou/workspace/OPL/applicationbateau/src/applicationbateau");
    	spoon.addInputResource("/Users/abdelrhamanebenhammou/workspace/appliTest/src/appliTest/");
    	// OUTPUT définition
    	spoon.setSourceOutputDirectory("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/output/");
    	
    	// Ajout des processeurs
    	factotyReference getterName = new factotyReference();
 
    	// Définition des processeurs
    	NameDeclarationChanger NDC = new NameDeclarationChanger(getterName);
    	NameAccessChanger NAC = new NameAccessChanger(getterName);
    	CreateContanteString CCS = new CreateContanteString(getterName);
    	StringReference SR = new StringReference(getterName);
    	
    	// Association à spoon
    	spoon.addProcessor(NAC);
    	spoon.addProcessor(NDC);
    	spoon.addProcessor(CCS);
    	spoon.addProcessor(SR);

    	 // Lancement de SPOON
      	 spoon.run();
    }
}
