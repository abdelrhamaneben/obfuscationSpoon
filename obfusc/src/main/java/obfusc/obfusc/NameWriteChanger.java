package obfusc.obfusc;


import spoon.processing.AbstractProcessor;
import spoon.support.reflect.code.CtVariableWriteImpl;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class NameWriteChanger  extends AbstractProcessor<CtVariableWriteImpl>{
	
	private factotyReference fn;
	
	public NameWriteChanger (factotyReference fn) {
		this.fn = fn;
	}
	
	public void process(CtVariableWriteImpl element) {
		element.getVariable().setSimpleName(fn.getName(element.getVariable().getSimpleName()));
    }
	
	
}
