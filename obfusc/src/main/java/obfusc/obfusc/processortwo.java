package obfusc.obfusc;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.AnnotationFactory;
import spoon.support.reflect.declaration.CtAnnotationImpl;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class processortwo  extends AbstractProcessor<CtMethod>{
	
	public void process(CtMethod element) {
		
		System.out.println(" method : " + element.getSignature());
		ArrayList<CtStatement> list = (ArrayList<CtStatement>) element.getBody().getStatements();
		for(CtStatement c : list) {
			System.out.println("-------");
		}
    }
	
	
}
