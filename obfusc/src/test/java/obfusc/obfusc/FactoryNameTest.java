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
    	// Test que la fonction retourne bien quelque chose
        this.assertNotNull(factotyName.get());
        
        // Test que le fonction retourne bien des noms différents
        ArrayList <String> list = new ArrayList<String>();
        String tmpName;
        for(int i = 0; i< 10;i++) {
        	tmpName = factotyName.get();
        	System.out.println(tmpName);
        	if(list.contains(tmpName)) {
        		this.fail("FactotyName.get() retourne deux noms identiques");
        	}
        	list.add(tmpName);
        }
    }
}
