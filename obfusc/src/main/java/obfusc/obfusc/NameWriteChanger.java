package obfusc.obfusc;


import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtVariable;
import spoon.support.reflect.code.CtVariableWriteImpl;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class NameWriteChanger  extends AbstractProcessor<CtVariableWriteImpl>{
	
	private factotyName fn;
	
	public NameWriteChanger (factotyName fn) {
		this.fn = fn;
	}
	
	public void process(CtVariableWriteImpl element) {
		element.getVariable().setSimpleName(fn.get(element.getVariable().getSimpleName()));
    }
	
	
}
