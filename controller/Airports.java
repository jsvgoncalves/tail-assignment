/**
 * 
 */
package controller;

import java.util.ArrayList;

/**
 * @author joao
 *
 */
public class Airports implements Entity {

	private static Airports instance;
	ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
	
	
	private Airports() {
		
	}
	
	public static Airports getAirports() {
		if (instance == null) {
			instance = new Airports();
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see controller.Entity#addRecord(java.util.ArrayList)
	 */
	@Override
	public <T> boolean addRecord(ArrayList<T> arr) {
		records.add((ArrayList<String>)arr);
		return false;
	}

	/* (non-Javadoc)
	 * @see controller.Entity#getFirst()
	 */
	@Override
	public <T> T getFirst() {
		// TODO Auto-generated method stub
		return (T)records.get(0);
	}

}
