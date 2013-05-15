package controller;

public class Planes extends TailContainer {
	
	private static final int PLATE = 0;
	private static final int NAME = 1;
	private static final int TYPE = 2;
	private static final int ATC_AVG_COST_DAY = 3;
	private static final int MAINT_AVG_COST_MIN = 4;
	private static final int FUEL_AVG_COST_MIN = 5;
	
	private static Planes instance;
	
	
	
	private Planes() {
		
	}
	
	public static Planes getPlanes() {
		if (instance == null) {
			instance = new Planes();
		}
		return instance;
	}
	
	public String getPlate(int index) {
		return records.get(index).get(PLATE);
	}
	
	public String getName(int index) {
		return records.get(index).get(NAME);
	}
	
	public String getType(int index) {
		return records.get(index).get(TYPE);
	}
	
	public String getATC(int index) {
		return records.get(index).get(ATC_AVG_COST_DAY);
	}
	
	public String getMAINT(int index) {
		return records.get(index).get(MAINT_AVG_COST_MIN);
	}
	
	public String getFuel(int index) {
		return records.get(index).get(FUEL_AVG_COST_MIN);
	}

	
}
