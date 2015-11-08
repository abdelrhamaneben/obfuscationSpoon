package obfusc.obfusc;

import spoon.Launcher;

public class App 
{
    public static void main( String[] args )
    {
    	Launcher spoon = new Launcher(); 
    	//spoon.addInputResource("/home/m2iagl/benhammou/workspace/OPL/applicationbateau/src/applicationbateau");
    	spoon.addInputResource("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/applicationbateau/src/applicationbateau");
    	factotyName getterName = new factotyName();
    	NameDeclarationChanger NDC = new NameDeclarationChanger(getterName);
    	NameReadChanger NRC = new NameReadChanger(getterName);
    	
    	spoon.addProcessor(NDC);
    	spoon.addProcessor(NRC);
    	
    	spoon.setSourceOutputDirectory("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/output");
	    spoon.run();
    }
}
