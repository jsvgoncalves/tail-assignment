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
	public int oldExc;
	public int soldEco;

	@Override
	public int compareTo(Flight flight) {
		// TODO Auto-generated method stub
		return 0;
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
	public int getOldExc() {
		return oldExc;
	}

	/**
	 * @param oldExc the oldExc to set
	 */
	public void setOldExc(int oldExc) {
		this.oldExc = oldExc;
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
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
