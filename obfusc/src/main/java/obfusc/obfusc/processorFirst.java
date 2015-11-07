package obfusc.obfusc;


import java.util.HashMap;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtField;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class processorFirst  extends AbstractProcessor<CtField>{
	
	static HashMap<String,String> names = new HashMap<String,String>();
	
	public void process(CtField element) {
		String oldName = element.getSimpleName();
		if(!names.containsKey(oldName)) {
			String newName = factotyName.get();
			names.put(oldName, newName);
		}
		element.setSimpleName(names.get(oldName));
    }

}
