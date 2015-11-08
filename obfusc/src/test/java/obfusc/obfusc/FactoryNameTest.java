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
        
        // Test que la fonction retourne bien des noms différents si on lui fourni des noms différents
        String Nom1 = fn.get("blabla");
        String Nom2 = fn.get("blibli");
        this.assertNotSame(Nom1, Nom2);
        
        
        // Test quel retourne des noms identiques si les noms fournis le sont
	    Nom1 = fn.get("blabla");
	    Nom2 = fn.get("blabla");
	    this.assertSame(Nom1, Nom2);
    }
}
