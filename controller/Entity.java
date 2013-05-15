package controller;

import java.util.ArrayList;

public interface Entity {
	
	public <T> boolean addRecord(ArrayList<T> arr);
	
	public <T> T getFirst();

}
