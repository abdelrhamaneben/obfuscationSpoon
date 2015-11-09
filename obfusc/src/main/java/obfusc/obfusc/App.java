package obfusc.obfusc;

import spoon.Launcher;

public class App 
{
    public static void main( String[] args )
    {
    	Launcher spoon = new Launcher(); 
    	
    	
    	// Définition des chemins d'entrée et de sortie
    	// INPUT
    	//spoon.addInputResource("/home/m2iagl/benhammou/workspace/OPL/applicationbateau/src/applicationbateau");
    	spoon.addInputResource("/Users/abdelrhamanebenhammou/workspace/appliTest/");
    	// OUTPUT
    	spoon.setSourceOutputDirectory("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/output/");
    	
    	// Ajout des processeurs
    	factotyReference getterName = new factotyReference();
    	NameDeclarationChanger NDC = new NameDeclarationChanger(getterName);
    	NameReadChanger NRC = new NameReadChanger(getterName);
    	NameWriteChanger NWC = new NameWriteChanger(getterName);
    	StringReference SR = new StringReference(getterName);
    	CreateContanteString CCS = new CreateContanteString(getterName);
    	
    	spoon.addProcessor(CCS);
    	spoon.addProcessor(NDC);
    	spoon.addProcessor(NRC);
    	spoon.addProcessor(NWC);
    	spoon.addProcessor(SR);
    	
    	 // Lancement de SPOON
      	 spoon.run();
    }
}
