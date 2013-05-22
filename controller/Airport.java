package controller;

public class Airport {
	
	private String iataCode;
	private double nbLandingCostPerLanding;
	private double nbDailyParkingCost;
	private double wbLandingCostPerLanding;
	private double wbDailyParkingCost;
	
	private Airport(){};
	
	public Airport(String iataCode, double nbLandingCostPerLanding,
			double nbDailyParkingCost, double wbLandingCostPerLanding,
			double wbDailyParkingCost) {
		this.iataCode = iataCode;
		this.nbLandingCostPerLanding = nbLandingCostPerLanding;
		this.nbDailyParkingCost = nbDailyParkingCost;
		this.wbLandingCostPerLanding = wbLandingCostPerLanding;
		this.wbDailyParkingCost = wbDailyParkingCost;
	}
	
	/**
	 * @return the iataCode
	 */
	public String getIataCode() {
		return iataCode;
	}
	/**
	 * @param iataCode the iataCode to set
	 */
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	/**
	 * @return the nbLandingCostPerLanding
	 */
	public double getNbLandingCostPerLanding() {
		return nbLandingCostPerLanding;
	}
	/**
	 * @param nbLandingCostPerLanding the nbLandingCostPerLanding to set
	 */
	public void setNbLandingCostPerLanding(String nbLandingCostPerLanding) {
		this.nbLandingCostPerLanding = Integer.valueOf(nbLandingCostPerLanding);
	}
	/**
	 * @return the nbDailyParkingCost
	 */
	public double getNbDailyParkingCost() {
		return nbDailyParkingCost;
	}
	/**
	 * @param nbDailyParkingCost the nbDailyParkingCost to set
	 */
	public void setNbDailyParkingCost(String nbDailyParkingCost) {
		this.nbDailyParkingCost = Integer.valueOf(nbDailyParkingCost);
	}
	/**
	 * @return the wbLandingCostPerLanding
	 */
	public double getWbLandingCostPerLanding() {
		return wbLandingCostPerLanding;
	}
	/**
	 * @param wbLandingCostPerLanding the wbLandingCostPerLanding to set
	 */
	public void setWbLandingCostPerLanding(String wbLandingCostPerLanding) {
		this.wbLandingCostPerLanding = Integer.valueOf(wbLandingCostPerLanding);
	}
	/**
	 * @return the wbDailyParkingCost
	 */
	public double getWbDailyParkingCost() {
		return wbDailyParkingCost;
	}
	/**
	 * @param wbDailyParkingCost the wbDailyParkingCost to set
	 */
	public void setWbDailyParkingCost(String wbDailyParkingCost) {
		this.wbDailyParkingCost = Integer.valueOf(wbDailyParkingCost);
	}
	
	
	
}
