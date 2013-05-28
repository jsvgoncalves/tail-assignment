package controller;

public interface Recordible {
	
	public <T> boolean addRecord(T arr);
	
	public <T> T get(int index);
}
