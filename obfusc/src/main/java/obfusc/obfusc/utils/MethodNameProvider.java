package obfusc.obfusc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.Filter;
import spoon.reflect.visitor.Query;
import spoon.reflect.visitor.QueryVisitor;
import spoon.reflect.visitor.ReferenceFilter;
import spoon.reflect.visitor.filter.InvocationFilter;
import spoon.reflect.visitor.filter.ReferenceTypeFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.reference.SpoonClassNotFoundException;

public class MethodNameProvider implements NameProvider<CtMethod>{
	
	private Map<String,List<List<CtTypeReference>>> methodsNames;
	private int nextNameToGenerate;
	private CtType currentClass;
	private Factory factory;
	//List<CtType<?>> allClasses;
	
	
	
	public MethodNameProvider(Factory factory, CtType classe){
		System.out.println("NEW METHODNAMEPROVIDER");
		methodsNames = new HashMap<String,List<List<CtTypeReference>>>();
		nextNameToGenerate = 1;
		currentClass = classe;
		this.factory = factory;
		//this.allClasses = factory.Class().getAll(true);
		initMap();
	}

	public String getNewName(CtMethod element){
		
		/*String name = getAlpha(nextNameToGenerate);
		nextNameToGenerate++;
		return name;*/
		
		nextNameToGenerate = 1;
		
		List<CtTypeReference> paramsRefs = getTypesReferences(element);
		
		
		//cherche le prochain nom
		String name = getAlpha(nextNameToGenerate);
		while((methodsNames.containsKey(name) && listContainRefs(methodsNames.get(name),paramsRefs)) || isJavaKeyword(getAlpha(nextNameToGenerate))){
			nextNameToGenerate++;
			name = getAlpha(nextNameToGenerate);
		}
		
		
		
		if(methodsNames.containsKey(name)){
			List<List<CtTypeReference>> list = methodsNames.get(name);
			list.add(paramsRefs);
			return name;
		}
		
	    List<List<CtTypeReference>> newList = new ArrayList<List<CtTypeReference>>();
	    newList.add(paramsRefs);
	    methodsNames.put(name,newList);
	    //incrementNextNameToGenerate();
	    return name;
		
			
		/*List<CtTypeReference> paramsRefs = getTypesReferences(element);
		
		Iterator<Entry<String, List<List<CtTypeReference>>>> iteratorMethodsNames = methodsNames.entrySet().iterator();
	    while (iteratorMethodsNames.hasNext()) {
	        Map.Entry<String, List<List<CtTypeReference>>> pair = (Map.Entry)iteratorMethodsNames.next();
	        String key = pair.getKey();
	        List<List<CtTypeReference>> value = pair.getValue();
	        
	        if(! value.contains(paramsRefs)){
	        	value.add(paramsRefs);
	        	return key;
	        }

	    }*/
	    
	}

	
	/*private void incrementNextNameToGenerate(){
	    do{
		    nextNameToGenerate++;
	    }
	    while(methodsNames.containsKey(getAlpha(nextNameToGenerate)) || isJavaKeyword(getAlpha(nextNameToGenerate)));
	}*/
	
	private List<CtTypeReference> getTypesReferences(CtMethod method){
		List<CtParameter<?>> params = method.getParameters();
		List<CtTypeReference> paramsTypes = new ArrayList<CtTypeReference>();
		for(CtParameter<?> param : params){
			paramsTypes.add(param.getType());
		}
		return paramsTypes;
	}
	
	private boolean listContainRefs(List<List<CtTypeReference>> list, List<CtTypeReference> paramsRefs){
		boolean flag;
		
		if(list.contains(paramsRefs)){
			return true;
		}
		
		//verifie que les types ne sont pas tous des sous types
		for(List<CtTypeReference> refs : list){
			if(refs.size() == paramsRefs.size()){
				flag = true;
				for(int i = 0; i<refs.size();i++){
					try{
						if(! (paramsRefs.get(i).isSubtypeOf(refs.get(i)) || refs.get(i).isSubtypeOf(paramsRefs.get(i)))){
							flag = false;
						}
					}catch(SpoonClassNotFoundException e){
						System.out.println("SpoonClassNotFoundException : by default, return true");
						return true;
					}
				}
				if(flag){
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	private void initMap(){
		/*System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println("init Map for "+currentClass.getSimpleName());*/
		
		addMethodsFromSuperClass(currentClass.getSuperclass());
		addMethodsFromSuperInterfaces(currentClass.getSuperInterfaces());
		addMethodsFromSubClasses(currentClass);
		
		
	}
	
	private void addMethodsFromSuperClass(CtTypeReference<?> refSuperClass){
		CtType superclass;
		if(refSuperClass != null){
			superclass = refSuperClass.getDeclaration();
			if(superclass != null){
				//System.out.println("SUPER CLASS = "+refSuperClass.getSimpleName());
				addMethodsFromSuperClass(superclass.getSuperclass());
				addMethods(superclass.getAllMethods());
			}
		}
	}
	
	
	private void addMethodsFromSuperInterfaces(Set<CtTypeReference<?>> refs){
		CtType currentItf;
		
		if(refs != null){
			for(CtTypeReference ref : refs){
				addMethodsFromSuperInterfaces(ref.getSuperInterfaces());
				currentItf = ref.getDeclaration();
				//System.out.println("SUPER INTF = "+ref.getSimpleName());
				if(currentItf != null){
					addMethods(currentItf.getAllMethods());
				}
			}
		}
	}
	
	private void addMethodsFromSubClasses(CtType<?> currentClass){
		
		Filter filter = new TypeFilter(CtType.class);
		
		List<CtType<?>> subclasses = factory.Class().getAll(true);
		//List<CtReference> subclasses = Query.getReferences(factory, filterRef);
		
		
		
		for(CtType<?> c : subclasses){
			
			//si c hérite ou implemente la currentClass
			/*if(currentClass.getReference().equals(c.getSuperclass())
			|| c.getSuperInterfaces().contains(currentClass.getReference())){*/
			if(c.isSubtypeOf(currentClass.getReference())){
				
			System.out.println("SUB CLASS = "+c.getSimpleName());
			//addMethodsFromSubClasses(c);
			//System.out.println(c.getMethods().size());
			addMethods(c.getMethods());
			//}
			}
		}
		
	}
	
	
	
	private void addMethods(Set<CtMethod<?>>  allMethods) {
		for(CtMethod method : allMethods){
			String name = method.getSimpleName();
			List<CtTypeReference> paramsRefs = getTypesReferences(method);
			if(methodsNames.containsKey(name)){
				methodsNames.get(name).add(paramsRefs);
			}
			else{
				List<List<CtTypeReference>> newList = new ArrayList<List<CtTypeReference>>();
				newList.add(paramsRefs);
				methodsNames.put(name,newList);
			}	
		}
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
	

	public String getNewStaticName() {
		return UUID.randomUUID().toString().replaceAll("[^A-Za-z]+", "");
	}
	

	static final String keywords[] = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };

    public static boolean isJavaKeyword(String keyword) {
        return (Arrays.binarySearch(keywords, keyword) >= 0);
    }

	

}
