package obfusc.obfusc;

import java.util.HashMap;
import java.util.UUID;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class factotyName {
	static HashMap<String,String> names ;
	
	public factotyName() {
		names = new HashMap<String,String>();
	}
	
	public String get(String old) {
		String newName = "v" + UUID.randomUUID().toString().replace("-", "_");
		if(!names.containsKey(old)) {
			
			names.put(old, newName);
		}
		return names.get(old);
	}
}
