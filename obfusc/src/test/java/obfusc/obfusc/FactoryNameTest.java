package obfusc.obfusc;

import java.util.ArrayList;

import junit.framework.TestCase;

public class FactoryNameTest extends TestCase {

	public FactoryNameTest(String name) {
		super(name);
	}
	
	/**
	 * La fonction doit retourner des nom de variable unique
	 */
    public void testGet()
    {
    	factotyName fn = new factotyName();
    	// Test que la fonction retourne bien quelque chose
        this.assertNotNull(fn.get("blabla"));
        
    }
}
