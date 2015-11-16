package obfusc.obfusc.processors;


import obfusc.obfusc.utils.factotyReference;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLiteral;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class StringReference  extends AbstractProcessor<CtLiteral<?>>{
	
	private factotyReference fn;
	
	public StringReference (factotyReference fn) {
		this.fn = fn;
	}
	
	public void process(CtLiteral<?> element) {
		if(element.getPosition() != null && element.isParentInitialized() && element.getType().getSimpleName().equals("String")) {
			try {
				String newName = fn.SaveString(element.getSignature());
				CtExpression ce = this.getFactory().Code().createCodeSnippetExpression(newName);
				element.replace(ce);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
    }

}
