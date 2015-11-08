package obfusc.obfusc;

import spoon.Launcher;
import spoon.reflect.declaration.CtClass;

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
    	factotyReference getterName = new factotyReference();
    	NameDeclarationChanger NDC = new NameDeclarationChanger(getterName);
    	NameReadChanger NRC = new NameReadChanger(getterName);
    	NameWriteChanger NWC = new NameWriteChanger(getterName);
    	StringReference SR = new StringReference(getterName);
    	spoon.addProcessor(NDC);
    	spoon.addProcessor(NRC);
    	spoon.addProcessor(NWC);
    	spoon.addProcessor(SR);
    	
    	// Lancement de SPOON
	    spoon.run();
	    /*System.out.println("after Run");
	    CtClass newClass =  spoon.getFactory().Core().createClass();
	    newClass.setSimpleName("TotoStringReference");*/
	    
	    
	    
    }
}
