package obfusc.obfusc;


import java.util.ArrayList;
import java.util.HashMap;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtNamedElement;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class NameDeclarationChanger  extends AbstractProcessor<CtNamedElement>{
	
	private factotyReference fn;
	
	public NameDeclarationChanger (factotyReference fn) {
		this.fn = fn;
	}
	
	public void process(CtNamedElement element) {
		
		ArrayList<String> elementChangable = new ArrayList<String>();
		elementChangable.add("CtLocalVariableImpl");
		elementChangable.add("CtFieldImpl");
		
		if(elementChangable.contains(element.getClass().getSimpleName())) {
			String oldName = element.getSimpleName();
			element.setSimpleName(fn.getName(oldName));
		}
    }

}
