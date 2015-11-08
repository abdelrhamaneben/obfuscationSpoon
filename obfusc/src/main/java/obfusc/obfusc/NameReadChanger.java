package obfusc.obfusc;


import spoon.processing.AbstractProcessor;
import spoon.support.reflect.code.CtVariableReadImpl;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class NameReadChanger  extends AbstractProcessor<CtVariableReadImpl>{
	
	private factotyName fn;
	
	public NameReadChanger (factotyName fn) {
		this.fn = fn;
	}
	
	public void process(CtVariableReadImpl element) {
		element.getVariable().setSimpleName(fn.get(element.getVariable().getSimpleName()));
    }
	
	
}
