package obfusc.obfusc;




import java.lang.annotation.Annotation;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.factory.AnnotationFactory;
import spoon.support.reflect.declaration.CtAnnotationImpl;

public class processortwo  extends AbstractProcessor<CtMethod>{
	
	public void process(CtMethod element) {
		AnnotationFactory af = new AnnotationFactory(this.getFactory());
		element.addAnnotation((CtAnnotation<? extends Annotation>) af.create("sdg"));
		System.out.println(element.getSignature());
		
    }
}
