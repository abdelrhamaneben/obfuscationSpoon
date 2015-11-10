package obfusc.obfusc;

import spoon.processing.AbstractManualProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtPackage;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class CreateContanteString  extends AbstractManualProcessor{
	
	private factotyReference fn;
	
	public CreateContanteString (factotyReference fn) {
		this.fn = fn;
	}

	public void process() {
		
		CtPackage root  = this.getFactory().Package().create(this.getFactory().Package().getRootPackage(), "toto");
		CtClass<?> c = this.getFactory().Class().create(root, "totoStringConstantes");
		fn.setContanteClass(c);
	}
}
