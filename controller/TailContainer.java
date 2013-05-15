/**
 * 
 */
package controller;

import java.util.ArrayList;

/**
 * @author joao
 *
 */
public class TailContainer implements Recordible{
	
	ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> boolean addRecord(ArrayList<T> arr) {
		records.add((ArrayList<String>) arr);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getRecord(int index) {
		return (T)records.get(index);
	}
}
