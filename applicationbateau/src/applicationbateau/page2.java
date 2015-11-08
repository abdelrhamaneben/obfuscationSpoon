package applicationbateau;

public class page2 {

	private String hello;

	public void process() {
		String helloBoy = "helloBoy";
		helloBoy = "helloBoy" +  " , how are you ?";
		int blabla = 1;
		
        if (helloBoy.contains("how are you ?")) {
           System.out.println(helloBoy + " : ");
           System.out.println("Fine and you ?");
        }
        else {
        	System.out.println("What ?");
        }

        switch(helloBoy) {
        	default: 
        		helloBoy = helloBoy;
        }
    }
}
