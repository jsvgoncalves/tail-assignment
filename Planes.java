
public class Planes {
	
	private static Planes instance;
	
	
	private Planes() {
		
	}
	
	public Planes getPlanes() {
		if (instance == null) {
			instance = new Planes();
		}
		return instance;
	}
	
	
}
