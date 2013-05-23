package controller;

public class Flight implements Comparable<Flight>{
	public int number;
	/**
	 * Departure airport.
	 */
	public Airport dept;
	/**
	 * Destination airport.
	 */
	public Airport arrv;
	public int planeType;
	public int deptTime;
	public int arrvTime;
	public int seatsExc;
	public int seatsEco;
	public int soldExc;
	public int soldEco;
	
	public boolean isMaintenance = false;
	
//	private Flight() {
//	}
	
	public Flight(int flightNo, Airport dept, Airport arrv, 
			int planeType, int deptTime, int arrvTime,
			int seatsExc, int seatsEco, int soldExc, int soldEco) {
		this.number = flightNo;
		this.dept = dept;
		this.arrv = arrv;
		this.planeType = planeType;
		this.deptTime = deptTime;
		this.arrvTime = arrvTime;
		this.seatsExc = seatsExc;
		this.seatsEco = seatsEco;
		this.soldExc = soldExc;
		this.soldEco = soldEco;
	}

	@Override
	public int compareTo(Flight flight) {
		if (this.deptTime == flight.deptTime){
			return this.arrvTime - flight.arrvTime;
		}
		return this.deptTime - flight.deptTime;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the dept
	 */
	public Airport getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(Airport dept) {
		this.dept = dept;
	}

	/**
	 * @return the arrv
	 */
	public Airport getArrv() {
		return arrv;
	}

	/**
	 * @param arrv the arrv to set
	 */
	public void setArrv(Airport arrv) {
		this.arrv = arrv;
	}

	/**
	 * @return the planeType
	 */
	public int getPlaneType() {
		return planeType;
	}

	/**
	 * @param planeType the planeType to set
	 */
	public void setPlaneType(int planeType) {
		this.planeType = planeType;
	}

	/**
	 * @return the deptTime
	 */
	public int getDeptTime() {
		return deptTime;
	}

	/**
	 * @param deptTime the deptTime to set
	 */
	public void setDeptTime(int deptTime) {
		this.deptTime = deptTime;
	}

	/**
	 * @return the arrvTime
	 */
	public int getArrvTime() {
		return arrvTime;
	}

	/**
	 * @param arrvTime the arrvTime to set
	 */
	public void setArrvTime(int arrvTime) {
		this.arrvTime = arrvTime;
	}

	/**
	 * @return the seatsExc
	 */
	public int getSeatsExc() {
		return seatsExc;
	}

	/**
	 * @param seatsExc the seatsExc to set
	 */
	public void setSeatsExc(int seatsExc) {
		this.seatsExc = seatsExc;
	}

	/**
	 * @return the seatsEco
	 */
	public int getSeatsEco() {
		return seatsEco;
	}

	/**
	 * @param seatsEco the seatsEco to set
	 */
	public void setSeatsEco(int seatsEco) {
		this.seatsEco = seatsEco;
	}

	/**
	 * @return the oldExc
	 */
	public int getSoldExc() {
		return soldExc;
	}

	/**
	 * @param oldExc the oldExc to set
	 */
	public void setSoldExc(int oldExc) {
		this.soldExc = oldExc;
	}

	/**
	 * @return the soldEco
	 */
	public int getSoldEco() {
		return soldEco;
	}

	/**
	 * @param soldEco the soldEco to set
	 */
	public void setSoldEco(int soldEco) {
		this.soldEco = soldEco;
	}

	public boolean isMaintenance() {
		return isMaintenance;
	}
	
	
}
