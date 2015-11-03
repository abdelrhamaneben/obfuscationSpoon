package obfusc.obfusc;

import spoon.Launcher;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.factory.Factory;

public class App 
{
    public static void main( String[] args )
    {
    	Launcher spoon = new Launcher(); 
    	spoon.addInputResource("/home/m2iagl/benhammou/workspace/OPL/applicationbateau/src/applicationbateau");
    	spoon.addProcessor(new processorFirst());
    	spoon.setSourceOutputDirectory("/home/m2iagl/benhammou/Bureau");
	    spoon.run();
	    
	    /*Factory factory = spoon.getFactory();
	    // list all packages of the model
	    
	    for(CtPackage p : factory.Package().getAll()) { 
	    	
	    	System.out.println("package: "+p.getQualifiedName());
	    } */
	    
	   
    }
}
