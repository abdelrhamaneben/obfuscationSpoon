package obfusc.obfusc.processors;

import obfusc.obfusc.utils.factotyReference;
import spoon.processing.AbstractManualProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.ModifierKind;

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
		c.setVisibility(ModifierKind.PUBLIC);
		fn.setContanteClass(c);
	}
}
