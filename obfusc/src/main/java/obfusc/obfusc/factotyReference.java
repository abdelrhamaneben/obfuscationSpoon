package obfusc.obfusc;

import java.util.HashMap;
import java.util.UUID;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class factotyReference {
	public HashMap<String,String> names ;
	public HashMap<String,String> strings ;
	
	public factotyReference() {
		names = new HashMap<String,String>();
		strings = new HashMap<String,String>();
	}
	
	public String getName(String old) {
		String newName = "v" + UUID.randomUUID().toString().replace("-", "_");
		if(!names.containsKey(old)) {
			
			names.put(old, newName);
		}
		return names.get(old);
	}
	
	
	public String SaveString(String old) {
		String newName = "v" + UUID.randomUUID().toString().replace("-", "_");
		if(!strings.containsKey(old)) {
			
			strings.put(old, newName);
		}
		return "totoStringConstantes." + strings.get(old);
	}
}
