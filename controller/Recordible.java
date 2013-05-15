package controller;

import java.util.ArrayList;

public interface Recordible {
	
	public <T> boolean addRecord(ArrayList<T> arr);
	
	public <T> T getRecord(int index);

}
