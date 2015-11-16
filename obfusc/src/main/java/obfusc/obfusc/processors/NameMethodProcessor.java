package obfusc.obfusc.processors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Test;

import java.util.Set;

import obfusc.obfusc.utils.MethodNameProvider;
import obfusc.obfusc.utils.NameProvider;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypedElement;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.Filter;
import spoon.reflect.visitor.Query;
import spoon.reflect.visitor.QueryVisitor;
import spoon.reflect.visitor.filter.CompositeFilter;
import spoon.reflect.visitor.filter.FilteringOperator;
import spoon.reflect.visitor.filter.InvocationFilter;
import spoon.reflect.visitor.filter.NameFilter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.reflect.code.CtInvocationImpl;

public class NameMethodProcessor extends AbstractProcessor<CtType>{

	public Map<CtExecutableReference<?>,CtExecutableReference<?>> mapReferences;
	
	public NameMethodProcessor(){
		mapReferences = new HashMap<CtExecutableReference<?>,CtExecutableReference<?>>();
	}
	
	//@Override
	public void process(CtType element) {
		
		//getEnvironment().setAutoImports(true);
		
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_- CHANGE METHODS OF "+element.getSimpleName()+" -_-_-_-_-_-_-_-_-_-_-_-_-_-");
		NameProvider nameProvider = new MethodNameProvider(getFactory(),element);
		
		Set<CtMethod> methods = element.getMethods();
		for(CtMethod method : methods){
			
			if(isStatic(method)){
				/*String newName = nameProvider.getNewStaticName();
				changeMethodName(method, newName);*/
				continue;
			}
			
			
			System.out.println("ABCDEFGHIJKLMNOP = "+method.getSignature());
			System.out.println("ABCDEFGHIJKLMNOP = "+isStatic(method));
			//Don't touch to the mains methods
			if(! isModifiable(method)){
				continue;
			}
			
			String newName = nameProvider.getNewName(method);
			System.out.println(" ");
			//System.out.println(method.getPosition()+" === "+method.getSimpleName());
			System.out.println("Change method "+method.getReference());
			System.out.println("..Old = "+method.getSimpleName());
			System.out.println("..New = "+newName);
			
			// creation des filtres avant de changer le nom de la methode (pour l'ancienne reference). 
			NameFilter filterName = new NameFilter(method.getSimpleName());
			
			changeMethodName(method, newName);
			//changeAllInvocationExecutable(filterInvoc,method);
			
			
			changeAllSubClass(filterName,method,element);
		}
		
	}
	
	/*
	 * Pour chaque invocation, on met à jour sa reference.
	 */
	@Override
	public void processingDone(){
		CtPackage p = getFactory().Package().getRootPackage();
		List<CtInvocation<?>> invocationList = p.getElements(new TypeFilter<CtInvocation<?>>(CtInvocation.class));
		
		for(CtInvocation<?> invoc : invocationList){
			
			Iterator<Entry<CtExecutableReference<?>, CtExecutableReference<?>>> iteratorMethodsNames = mapReferences.entrySet().iterator();
			while (iteratorMethodsNames.hasNext()) {
				 Map.Entry<CtExecutableReference<?>, CtExecutableReference<?>> pair = (Map.Entry<CtExecutableReference<?>, CtExecutableReference<?>>)iteratorMethodsNames.next();
				 CtExecutableReference oldRef = pair.getKey();
				 CtExecutableReference newRef = pair.getValue();
				 
				 // TO DO: ajout du cast si pas bon (passer dans la map le type de parametre attendu...?)
				 if(invoc.getExecutable().equals(pair.getKey())){
					System.out.println("..Change invocations:");
					System.out.println("...."+invoc.getPosition()+"  "+invoc.getSignature());
					System.out.println(".... old ref = "+oldRef);
					System.out.println(".... new ref = "+newRef);
					invoc.setExecutable(newRef);
					continue;
				 }
			}
		}
	}
	
	public void changeMethodName(CtMethod method, String newName){
		CtExecutableReference<?> oldRef = method.getReference();
		method.setSimpleName(newName);
		CtExecutableReference<?> newRef = method.getReference();
		
		mapReferences.put(oldRef,  newRef);
	}
	
	public void changeAllInvocationExecutable(InvocationFilter filter, CtMethod method){
		//System.out.println("....Change all invocations of the method:");
		
		CtPackage p = getFactory().Package().getRootPackage();
		List<CtInvocation<?>> invocationList = p.getElements(filter);
		
		/*QueryVisitor visiteur = new QueryVisitor(filter);
		List<CtInvocation<?>> invocationList = visiteur.getResult();*/
		
		for(CtInvocation<?> invoc : invocationList){
			System.out.println("....QQQQQQQQQQQQQQQQQQQQQq "+invoc.getExecutable());
			System.out.println("....Change invocations:");
			System.out.println("......"+invoc.getPosition()+"  "+invoc.getSignature());
			System.out.println("...... new ref = "+method.getReference());
			/*System.out.println("......Invocation Executable");
			System.out.println("......Position ="+invoc.getPosition());
			System.out.println("......Old = "+invoc.getExecutable());*/
			
			invoc.setExecutable(method.getReference());

			/*System.out.println("------ New = "+invoc.getExecutable());*/
		}
	}
	
	
	/*
	 * TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO TO DO
	 * probleme, le nameFilter va comparer juste le nom de la fonction. Si on herite 2 fonctions sort par ex: sort(String) sort(int)
	 * alors on renommera dans les sous classes les deux fonctions quand on voudra renommer que la premiere.
	 */
	
	/* need to change all subclass */
	public void changeAllSubClass(NameFilter nameFilter, CtMethod method, CtType type){
		CompositeFilter filter = new CompositeFilter(FilteringOperator.INTERSECTION,nameFilter,new TypeFilter(CtMethod.class));
		
		List<CtType<?>> subclasses = getFactory().Class().getAll(true);

		for(CtType<?> c : subclasses){
			
			//si c hérite ou implemente la currentClass
			if(type.getReference().equals(c.getSuperclass())
			|| c.getSuperInterfaces().contains(type.getReference())){
				System.out.println("....Change SubClass "+c.getSimpleName());
				List<CtMethod> methods = c.getElements(filter);
				for(CtMethod m : methods){
					System.out.println("......"+m.getSimpleName()+" become "+method.getSimpleName());
					changeMethodName(m,method.getSimpleName());
					
					
					//System.out.println(method.getPosition()+" === "+method.getSimpleName());
				}
			}
		}
		
	}
	
	public void changeAllSubInterface(CtMethod method){
		
	}
	
	public boolean isModifiable(CtMethod method){
		if(method.getSimpleName().equals("main")){
			return false;
		}
		if(method.getAnnotation(org.junit.Test.class) != null){
			return false;
		}
		if(isOverride(method)){
			System.out.println("METHOD NOT OVERRIDE "+method.getSimpleName());
			return false;
		}
		
		return true;
	}
	
	public boolean isOverride(CtMethod method){
		
		/*final List<CtAnnotation<? extends Annotation>> methodAnnotations = method.getAnnotations();
		for (final CtAnnotation<? extends Annotation> annotation : methodAnnotations) {
			if (annotation.getAnnotationType().getActualClass().equals(Override.class)) {
				return true;
			}
		}*/
		return (method.getAnnotation(Override.class) != null);

	}
	
	public boolean isStatic(CtMethod method){
		return method.toString().split("\\s+")[1].equals("static");
	}
}
