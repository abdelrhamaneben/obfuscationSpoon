package obfusc.obfusc;

import java.util.UUID;

/**
 * 
 * @author abdelrhamanebenhammou
 *
 */
public class factotyName {
	public static String get() {
		return "v" + UUID.randomUUID().toString().replace("-", "_");
	}
}
