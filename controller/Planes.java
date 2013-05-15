package controller;

import java.util.ArrayList;

public class Planes implements Entity {
	
	private static Planes instance;
	ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
	
	
	private Planes() {
		
	}
	
	public static Planes getPlanes() {
		if (instance == null) {
			instance = new Planes();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> boolean addRecord(ArrayList<T> arr) {
		records.add((ArrayList<String>) arr);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getFirst() {
		// TODO Auto-generated method stub
		return (T)records.get(0);
	}
	
}
