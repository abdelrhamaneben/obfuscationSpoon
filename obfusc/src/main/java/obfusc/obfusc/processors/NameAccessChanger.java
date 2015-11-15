package obfusc.obfusc.processors;


import obfusc.obfusc.utils.factotyReference;
import spoon.processing.AbstractProcessor;
import spoon.support.reflect.code.CtVariableAccessImpl;

/**
 * CLASS NameWriteChanger
 * @author abdelrhamanebenhammou
 *
 */
public class NameAccessChanger  extends AbstractProcessor<CtVariableAccessImpl>{
	
	private factotyReference fn;
	
	/**
	 * NameWriteChanger::NameWriteChanger()
	 * @param fn : représente la classe permettant de générer les noms
	 */
	public NameAccessChanger (factotyReference fn) {
		this.fn = fn;
	}
	
	/**
	 * NameWriteChanger::process()
	 * Cette Parcour tous les varibles d'accès (FieldRead/Write , VariableRead/Write) et modifies leur nom
	 */
	public void process(CtVariableAccessImpl element) {
			if(element.getVariable().getDeclaration() != null){
				element.getVariable().setSimpleName(fn.getName(element.getVariable().getSimpleName()));
			}
    }
}
