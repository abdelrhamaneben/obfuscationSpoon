package obfusc.obfusc;


import spoon.processing.AbstractProcessor;
import spoon.support.reflect.code.CtVariableReadImpl;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class NameReadChanger  extends AbstractProcessor<CtVariableReadImpl>{
	
	private factotyReference fn;
	
	public NameReadChanger (factotyReference fn) {
		this.fn = fn;
	}
	
	public void process(CtVariableReadImpl element) {
		element.getVariable().setSimpleName(fn.getName(element.getVariable().getSimpleName()));
    }
	
	
}
