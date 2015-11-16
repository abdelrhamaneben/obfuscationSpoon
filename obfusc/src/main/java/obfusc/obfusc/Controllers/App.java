package obfusc.obfusc.Controllers;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import obfusc.obfusc.processors.CreateContanteString;
import obfusc.obfusc.processors.NameAccessChanger;
import obfusc.obfusc.processors.NameDeclarationChanger;
import obfusc.obfusc.processors.NameMethodProcessor;
import obfusc.obfusc.processors.StringReference;
import obfusc.obfusc.utils.factotyReference;
import spoon.Launcher;
import spoon.reflect.factory.Factory;

public class App 
{

    public static void main( String[] args ) throws ParseException
    {
	
    	
    	// create Options object
    	Options options = new Options();
    	// add t option
    	options.addOption("inputMain", true, "List of path to sources files");
    	options.addOption("inputTest", true, "List of path to tests files");
    	options.addOption("sourceClasspath", true, " An optional classpath to be passed to the internal Java compiler when building or compiling the input sources.");
    	
    	CommandLineParser parser = new DefaultParser();
    	try {
    		CommandLine cmd = parser.parse( options, args);
        	if(!cmd.hasOption("-inputMain")) {
        		HelpFormatter formatter = new HelpFormatter();
        		formatter.printHelp( "list des parametres", options );
        		System.exit(0);
        	}
        	obfuscation(cmd.getOptionValue("inputMain"),cmd.getOptionValue("inputTest"),cmd.getOptionValue("sourceClasspath"));
        	
        }
        catch( ParseException exp ) {
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
        }
    	
  
    	
    	
    	
        /*
    	// Ajout des processeurs
    	factotyReference getterName = new factotyReference();
    	
    	NameDeclarationChanger NDC = new NameDeclarationChanger(getterName);
    	NameReadChanger NRC = new NameReadChanger(getterName);
    	NameWriteChanger NWC = new NameWriteChanger(getterName);
    	//StringReference SR = new StringReference(getterName);
    	
    	spoon.addProcessor(NDC);
    	spoon.addProcessor(NRC);
    	spoon.addProcessor(NWC);
    	//spoon.addProcessor(SR);
    	
    	BooleanExpressionProcessor boolExpProc = new BooleanExpressionProcessor(getterName);
    	spoon.addProcessor(boolExpProc);
    	
    	 // Lancement de SPOON
      	 spoon.run();
      	 System.out.println("run fini");
      	 
      	// Création de la classe Contenant les String en constante
	    CtClass ConstanteClass =  spoon.getFactory().Core().createClass();
	    ConstanteClass.setSimpleName("TotoStringReference");
	   
	    CtField field ;
	    CtExpression ce;
	    // Ajout d'une variable dans la classe pour chaque string trouvées
	    for(String VariableValue : getterName.strings.keySet()) {
	    	field = spoon.getFactory().Core().createField();
	    	field.setSimpleName(getterName.strings.get(VariableValue));
		    ce = spoon.getFactory().Code().createCodeSnippetExpression(VariableValue);
		    field.setAssignment(ce);
		    field.addModifier(ModifierKind.PUBLIC);
		    field.addModifier(ModifierKind.STATIC);
		    ConstanteClass.addField(field);
	    }
	    
	    System.out.println(ConstanteClass.toString());*/
	   // CtPackage rootPackage = spoon.getFactory().Package().getRootPackage();
	    
    }
    
    
    
    
    public static void obfuscation(String inputMain, String inputTest, String sourceClasspath){
    	
    	//inputMain = "../tmp2";
    	//inputMain = "../tmp/src";
    	inputMain =  "../commons-io/src/main/java:../commons-io/src/test/java";
    			
    			
    	System.out.printf("inputMain = "+inputMain+" %ninputTest = "+inputTest+" %nsourceClasspath = "+sourceClasspath+" %n");
    	
        
    	System.out.printf("Start of obfuscation for %s %n", inputMain);
    	
        Launcher spoon = new Launcher(); 
        Factory factory = spoon.getFactory();
        
        
    	//spoon.addInputResource("/Users/abdelrhamanebenhammou/workspace/appliTest/src/appliTest/");
    	//spoon.setSourceOutputDirectory("/Users/abdelrhamanebenhammou/Desktop/obfuscationSpoon/output/");

    
    	// Ajout des processeurs
    	factotyReference getterName = new factotyReference();
 
    	// Définition des processeurs
    	/*NameDeclarationChanger NDC = new NameDeclarationChanger(getterName);
    	NameAccessChanger NAC = new NameAccessChanger(getterName);
    	CreateContanteString CCS = new CreateContanteString(getterName);
    	//StringReference SR = new StringReference(getterName);
    	
    	spoon.addProcessor(NAC);
    	spoon.addProcessor(NDC);
    	spoon.addProcessor(CCS);
    	//spoon.addProcessor(SR);*/
    	spoon.addProcessor(new NameMethodProcessor());
    	
    	spoon.setSourceOutputDirectory("../output/src/main/java");
    	spoon.run(new String[]{"-i",inputMain,"--source-classpath",sourceClasspath});
        
    	System.out.printf("End of obfuscation for %s %n", inputMain);
    	
        /* TO DO 
         * Launcher pour les tests?
         */
/*
    	System.out.printf("Start of obfuscation for %s %n", inputTest);
    	
    	Launcher spoon2 = new Launcher(); 
    	spoon2.run(new String[]{"-i",inputTest,"--noclasspath"});
    	spoon2.setSourceOutputDirectory("../output/src/test/java");
        
    	System.out.printf("End of obfuscation for %s %n", inputTest);*/

    }
    
}
