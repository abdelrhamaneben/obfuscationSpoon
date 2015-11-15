package obfusc.obfusc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtTypedElement;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.InvocationFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.code.CtInvocationImpl;

public class NameMethodProcessor extends AbstractProcessor<CtClass>{

	private Factory factory;
	private Map<String,List<List<CtTypeReference>>> methodsNames;
	private int nextNameToGenerate;
	
	public NameMethodProcessor(Factory factory){
		this.factory = factory;
		methodsNames = new HashMap<String,List<List<CtTypeReference>>>();
		nextNameToGenerate = 1;
	}
	@Override
	public void process(CtClass element) {

		/* Reinitialise les variables globales qui servent à chaque classe*/
		methodsNames = new HashMap<String,List<List<CtTypeReference>>>();
		nextNameToGenerate = 1;
		
		
		Set<CtMethod> methods = element.getAllMethods();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Class name = "+element.getSimpleName());
		System.out.println("package = "+element.getPackage());
		System.out.println("--------------------------------------------------------------------------------");
		for(CtMethod method : methods){
			String newNom = getNewShortestMethodName(method);
			
			System.out.println("Ancien nom ==== "+method.getSimpleName()+" <->"+newNom);
			/*System.out.println("_________________________");
			System.out.println("method.getSimpleName() ==== " + method.getSimpleName());
			System.out.println("method.getSignature() ===== " + method.getSignature());
			System.out.println("method.getPosition() ====== " + method.getPosition());
			System.out.println("method.getParameters() ==== " + method.getParameters());*/	
			
			/*List<CtParameter<?>> params = method.getParameters();
			for(CtParameter<?> param : params){
				System.out.println("--- param = "+param);
				System.out.println("--- param.getType() = "+param.getType());
			}*/
			
			InvocationFilter filter = new InvocationFilter(method.getReference());
			
			method.setSimpleName(newNom);
			
			CtPackage p = getFactory().Package().getRootPackage();
			
			List<CtInvocation<?>> invocationList = p.getElements(filter);
			for(CtInvocation<?> invoc : invocationList){
				
				invoc.setExecutable(method.getReference());
				
				System.out.println("##########");
				//System.out.println("invoc.getExecutable().getDeclaration() ===== " + invoc.getExecutable().getDeclaration());
				/*System.out.println("invoc.getParent() ===== " + invoc.getParent());
				System.out.println("invoc.getLabel() ===== " + invoc.getLabel());
				System.out.println("invoc.getSignature() ===== " + invoc.getSignature());*/

				System.out.println(method.getSimpleName()+" <--------------->"+invoc.getExecutable());
			}
		}
		
	}
	
	
	public String getNewShortestMethodName(CtMethod m){

		List<CtTypeReference> paramsRefs = getTypesReferences(m.getParameters());
		
		Iterator<Entry<String, List<List<CtTypeReference>>>> iteratorMethodsNames = methodsNames.entrySet().iterator();
	    while (iteratorMethodsNames.hasNext()) {
	        Map.Entry<String, List<List<CtTypeReference>>> pair = (Map.Entry)iteratorMethodsNames.next();
	        
	        for(List<CtTypeReference> currentTypesRefs : pair.getValue()){
		        if(! paramsRefs.equals(currentTypesRefs)){
		        	return pair.getKey();
		        }	
	        }
	    }
	    List<List<CtTypeReference>> newList = new ArrayList<List<CtTypeReference>>();
	    newList.add(paramsRefs);
	    String name = getAlpha(nextNameToGenerate);
	    methodsNames.put(name,newList);
	    nextNameToGenerate++;
	    
	    return name;
	    
	}
	
	
	public List<CtTypeReference> getTypesReferences(List<CtParameter<?>> params){
		List<CtTypeReference> paramsTypes = new ArrayList<CtTypeReference>();
		for(CtParameter<?> param : params){
			paramsTypes.add(param.getType());
		}
		return paramsTypes;
	}
	
	public boolean SameParameters(CtMethod m1, CtMethod m2){
		List<CtParameter<?>> paramsMethod1 = m1.getParameters();
		List<CtParameter<?>> paramsMethod2 = m2.getParameters();
		
		return getTypesReferences(paramsMethod1).equals(getTypesReferences(paramsMethod2));
	}
	
	
	
	public static String getAlpha(int num) {

	    String result = "";
	    while (num > 0) {
	      num--; // 1 => a, not 0 => a
	      int remainder = num % 26;
	      char digit = (char) (remainder + 97);
	      result = digit + result;
	      num = (num - remainder) / 26;
	    }

	    return result;
	  }
	/*
	 * to do pseudo algo:
	 * pour chaque methode, new nom = getNewNom(CtMethod)
	 * on a une map de nom <String,List<ctMethod>>
	 * pour
	 */

}
