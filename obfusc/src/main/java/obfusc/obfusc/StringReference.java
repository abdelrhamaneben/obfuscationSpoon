package obfusc.obfusc;


import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLiteral;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class StringReference  extends AbstractProcessor<CtLiteral>{
	
	private factotyReference fn;
	
	public StringReference (factotyReference fn) {
		this.fn = fn;
	}
	
	public void process(CtLiteral element) {
		if(element.getType().getSimpleName().equals("String")) {
			String newName = fn.SaveString(element.getSignature());
			CtExpression ce = this.getFactory().Code().createCodeSnippetExpression(newName);
			element.replace(ce);
			
		}
    }

}
