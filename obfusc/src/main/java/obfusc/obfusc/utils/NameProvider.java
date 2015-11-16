package obfusc.obfusc.utils;

import spoon.reflect.declaration.CtElement;


public interface NameProvider <T extends CtElement>{
	
	public String getNewName(T element);

	public String getNewStaticName();
	

}
