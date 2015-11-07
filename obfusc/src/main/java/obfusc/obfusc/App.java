package obfusc.obfusc;

import spoon.Launcher;

public class App 
{
    public static void main( String[] args )
    {
    	Launcher spoon = new Launcher(); 
    	//spoon.addInputResource("/home/m2iagl/benhammou/workspace/OPL/applicationbateau/src/applicationbateau");
    	spoon.addInputResource("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/applicationbateau/src/applicationbateau");
    	
    	spoon.addProcessor(new processorFirst());
    	//spoon.addProcessor(new processortwo());
    	spoon.setSourceOutputDirectory("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/output");
	    spoon.run();
	    
	  /*  Factory factory = spoon.getFactory();
	    // list all packages of the model
	    
	    for(CtPackage p : factory.Package().getAll()) { 
	    	
	    	System.out.println("package: "+p.getQualifiedName());
	    }*/
    }
}
