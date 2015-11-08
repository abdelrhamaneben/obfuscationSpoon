package obfusc.obfusc;

import java.util.ArrayList;

import junit.framework.TestCase;

public class factotyReferenceTest extends TestCase {

	public factotyReferenceTest(String name) {
		super(name);
	}
	
	/**
	 * La fonction doit retourner des nom de variable unique
	 */
    public void testGetName()
    {
    	factotyReference fn = new factotyReference();
    	// Test que la fonction retourne bien quelque chose
        this.assertNotNull(fn.getName("blabla"));
        
        // Test que la fonction retourne bien des noms différents si on lui fourni des noms différents
        String Nom1 = fn.getName("blabla");
        String Nom2 = fn.getName("blibli");
        this.assertNotSame(Nom1, Nom2);
        
        
        // Test quel retourne des noms identiques si les noms fournis le sont
	    Nom1 = fn.getName("blabla");
	    Nom2 = fn.getName("blabla");
	    this.assertSame(Nom1, Nom2);
    }
}
