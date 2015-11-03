package obfusc.obfusc;


import org.apache.log4j.Level;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

public class processorFirst  extends AbstractProcessor<CtClass>{
	public void process(CtClass element) {
		CtTypeReference stringRef = this.getFactory().Code().createCtTypeReference(String.class);
		CtField field = getFactory().Code().createCtField("toto", stringRef, "null", ModifierKind.PUBLIC);
		element.addField(field);
    }

}
