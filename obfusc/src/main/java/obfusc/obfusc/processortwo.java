package obfusc.obfusc;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.AnnotationFactory;
import spoon.support.reflect.declaration.CtAnnotationImpl;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class processortwo  extends AbstractProcessor<CtNamedElement>{
	
	public void process(CtNamedElement element) {
		
		System.out.println(" String : " + element.getSignature());
		System.out.println(" Reference : " + element.getClass().getSimpleName());
		
		
    }
	
	
}
