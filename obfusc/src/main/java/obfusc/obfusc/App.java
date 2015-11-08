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
    	spoon.addInputResource("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/applicationbateau/src/applicationbateau");
    	// OUTPUT
    	spoon.setSourceOutputDirectory("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/output");
    	
    	// Ajout des processeurs
    	factotyName getterName = new factotyName();
    	NameDeclarationChanger NDC = new NameDeclarationChanger(getterName);
    	NameReadChanger NRC = new NameReadChanger(getterName);
    	NameWriteChanger NWC = new NameWriteChanger(getterName);
    	spoon.addProcessor(NDC);
    	spoon.addProcessor(NRC);
    	spoon.addProcessor(NWC);
    	
    	// Lancement de SPOON
	    spoon.run();
    }
}
