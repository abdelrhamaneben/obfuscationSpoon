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
    	
    }
    
    
    
    
    public static void obfuscation(String inputMain, String inputTest, String sourceClasspath){
    	
    	//inputMain = "../tmp2";
    	//inputMain = "../tmp/src";
    	//inputMain =  "../commons-csv/src/main/java:../commons-csv/src/test/java";
    	//inputMain = "../jsoup/src/main/java";
    	
    	/*sourceClasspath += ":../commons-csv/target:../jars/commons-io-2.4.jar:../jars/commons-lang3-3.4.jar"
    					+":../jars/csv-1.0.jar:../jars/gj-csv-1.0.jar:../jars/javacsv-2.0.jar:../jars/jmh-core-1.11.2.jar"
    					+":../jars/jmh-generator-annprocess-1.11.2.jar:../jars/opencsv-3.6.jar:../jars/super-csv-2.4.0.jar";*/
    	
    	//inputMain = "../tmp/src";
    	//sourceClasspath += ":../jsoup-1.8.4-SNAPSHOT.jar";
    	
    	
    			
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
