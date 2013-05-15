package controller;

public class Flights extends TailContainer {
	
	private static final int NUMBER = 0;
	private static final int DEPT = 0;
	private static final int ARRV = 0;
	private static final int PLANE_TYPE = 0;
	private static final int DEPT_TIME = 0;
	private static final int ARRV_TIME = 0;
	private static final int SEATS_EXC = 0;
	private static final int SEATS_ECO = 0;
	private static final int OLD_EXC = 0;
	private static final int SOLD_ECO = 0;
	
	private static Flights instance;
	
	private Flights() {
		// TODO Auto-generated constructor stub
	}
	
	public static Flights getFlights() {
		if (instance == null) {
			instance = new Flights();
		}
		return instance;
	}

	public String getNumber(int index) {
		return records.get(index).get(NUMBER);
	}

	public String getDept(int index) {
		return records.get(index).get(DEPT);
	}

	public String getArrv(int index) {
		return records.get(index).get(ARRV);
	}

	public String getPlaneType(int index) {
		return records.get(index).get(PLANE_TYPE);
	}

	public String getDeptTime(int index) {
		return records.get(index).get(DEPT_TIME);
	}

	public String getArrvTime(int index) {
		return records.get(index).get(ARRV_TIME);
	}

	public String getSeatsExc(int index) {
		return records.get(index).get(SEATS_EXC);
	}

	public String getSeatsEco(int index) {
		return records.get(index).get(SEATS_ECO);
	}

	public String getOldExc(int index) {
		return records.get(index).get(OLD_EXC);
	}

	public String getSoldEco(int index) {
		return records.get(index).get(SOLD_ECO);
	}

}
