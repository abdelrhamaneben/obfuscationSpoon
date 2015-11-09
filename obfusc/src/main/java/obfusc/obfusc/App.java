package obfusc.obfusc;

import spoon.Launcher;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;

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
	    
	    System.out.println(ConstanteClass.toString());
	   // CtPackage rootPackage = spoon.getFactory().Package().getRootPackage();
	    
    }
}
