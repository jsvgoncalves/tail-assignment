/**
 * 
 */
package controller;

/**
 * @author joao
 *
 */
public class Airports extends TailContainer {
	
	private static final int IATA_CODE = 0;
	private static final int NB_LANDING_COST_PER_LANDING = 1;
	private static final int NB_DAILY_PARKING_COST = 2;
	private static final int WB_LANDING_COST_PER_LANDING = 3;
	private static final int WB_DAILY_PARKING_COST = 4;

	private static Airports instance;
	
	private Airports() {
		
	}
	
	public static Airports getAirports() {
		if (instance == null) {
			instance = new Airports();
		}
		return instance;
	}

	public String getIataCode(int index) {
		return records.get(index).get(IATA_CODE);
	}

	public String getNbLandingCostPerLanding(int index) {
		return records.get(index).get(NB_LANDING_COST_PER_LANDING);
	}

	public String getNbDailyParkingCost(int index) {
		return records.get(index).get(NB_DAILY_PARKING_COST);
	}

	public String getWbLandingCostPerLanding(int index) {
		return records.get(index).get(WB_LANDING_COST_PER_LANDING);
	}

	public String getWbDailyParkingCost(int index) {
		return records.get(index).get(WB_DAILY_PARKING_COST);
	}

}
