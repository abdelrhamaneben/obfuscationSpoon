package obfusc.obfusc;


import junit.framework.TestCase;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;

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
        assertNotNull(fn.getName("blabla"));
        
        // Test que la fonction retourne bien des noms différents si on lui fourni des noms différents
        String Nom1 = fn.getName("blabla");
        String Nom2 = fn.getName("blibli");
        assertNotSame(Nom1, Nom2);
        
        
        // Test quel retourne des noms identiques si les noms fournis le sont
	    Nom1 = fn.getName("blabla");
	    Nom2 = fn.getName("blabla");
	    assertSame(Nom1, Nom2);
    }
    
    public void testSaveString() {
    	factotyReference fn = new factotyReference();
    	
    	// Test que SaveString retourne bien une exception si il n'y a pas de class TOTOConstante instancié
    	try{
    		fn.SaveString("blabla");
    		fail("Must Throw Exception");
    	}catch (Exception e) {
    		assertTrue(true);
    	}
    	// Test que getConstanteClass retourne bien une exception si il n'y a pas de class TOTOConstante instancié
    	try{
    		fn.getContanteClass();
    		fail("Must Throw Exception");
    	}catch (Exception e) {
    		assertTrue(true);
    	}
    	
    	Launcher spoon = new Launcher(); 
    	CtClass<?> totoClass = spoon.getFactory().Class().create("TotoClass");
    	fn.setContanteClass(totoClass);
    	
    	try {
    		
    		// vérifie que la class retourné est identique 
        	assertSame(fn.getContanteClass(), totoClass);
        	
			String newString = fn.SaveString("blabla");
			// vérifie que la valeur retourné contient bien la reférence à la class TotoCLass
			assertTrue(newString.contains("TotoClass"));
			
		} catch (Exception e) {
			fail("Must not throw exception");
		}
    }
}
