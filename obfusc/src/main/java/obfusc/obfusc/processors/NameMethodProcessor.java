package obfusc.obfusc.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import obfusc.obfusc.utils.MethodNameProvider;
import obfusc.obfusc.utils.NameProvider;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypedElement;
import spoon.reflect.factory.Factory;
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


	
	public NameMethodProcessor(){
	}
	@Override
	public void process(CtType element) {

		NameProvider nameProvider = new MethodNameProvider(getFactory(),element);
		
		Set<CtMethod> methods = element.getMethods();
		for(CtMethod method : methods){
			
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
			InvocationFilter filterInvoc = new InvocationFilter(method.getReference());
			NameFilter filterName = new NameFilter(method.getSimpleName());

			method.setSimpleName(newName);
			changeAllInvocationExecutable(filterInvoc,method);
			changeAllSubClass(filterName,method,element);
		}
		
	}
	
	public void changeAllInvocationExecutable(InvocationFilter filter, CtMethod method){
		//System.out.println("....Change all invocations of the method:");
		
		QueryVisitor visiteur = new QueryVisitor(filter);
		
		List<CtInvocation<?>> invocationList = visiteur.getResult();
		for(CtInvocation<?> invoc : invocationList){
			/*System.out.println("......Invocation Executable");
			System.out.println("......Position ="+invoc.getPosition());
			System.out.println("......Old = "+invoc.getExecutable());*/
			
			invoc.setExecutable(method.getReference());

			/*System.out.println("------ New = "+invoc.getExecutable());*/
		}
	}
	
	
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
					m.setSimpleName(method.getSimpleName());
					
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
		
		if(isOverride(method)){
			return false;
		}
		
		return true;
	}
	
	public boolean isOverride(CtMethod method){
		return (method.getAnnotation(Override.class) != null);
	}

	/**
	 * chercher si une super class ou super interface. (p-e recursivement?)
	 * si oui, alors verifier qu'il est dans le package. 
	 */
}
