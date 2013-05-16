package controller;

public interface Recordible {
	
	public <T> boolean addRecord(T arr);
	
	public <T> T getRecord(int index);
	

}
