package controller;

import java.util.ArrayList;

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
	private int duration;
	
//	private Flight() {
//	}
	
	public Flight(int flightNo, Airport dept, Airport arrv, 
			int planeType, int deptTime, int arrvTime,
			int seatsExc, int seatsEco, int soldExc, int soldEco) {
		this.number = flightNo;
		this.dept = dept;
		this.arrv = arrv;
		this.planeType = planeType;
		this.setDeptTime(deptTime);
		this.setArrvTime(arrvTime);
		this.seatsExc = seatsExc;
		this.seatsEco = seatsEco;
		this.soldExc = soldExc;
		this.soldEco = soldEco;
	}

	/**
	 * Voo
	 * Origem
	 * Destino
	 * Tipo_Aviao
	 * Partida
	 * Chegada
	 * Lugares_Executiva
	 * Lugares_Economica
	 * Lugares_Exec_Vendidos
	 * Lugares_Econ_Vendidos
	 * @param arr
	 */
	public Flight(ArrayList<String> arr, TailContainer<Airport> airports) {
		this.number = Integer.valueOf(arr.get(0));
		for (Airport airport: airports.getRecords()) {
			if (arr.get(1).equals(airport.getIataCode())) {
				this.dept = airport;
			} else if (arr.get(2).equals(airport.getIataCode())) {
				this.arrv = airport;
			}
		}
		this.planeType = Integer.valueOf(arr.get(3));
		setDeptTime(util.TimeHelper.getMinutes(arr.get(4)));
		setArrvTime(util.TimeHelper.getMinutes(arr.get(5)));
		this.seatsExc = Integer.valueOf(arr.get(6));
		this.seatsEco = Integer.valueOf(arr.get(7));
		this.soldExc = Integer.valueOf(arr.get(8));
		this.soldEco = Integer.valueOf(arr.get(9));
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
	 * @return Time in minutes
	 */
	public int getDeptTime() {
		return deptTime;
	}

	/**
	 * @param Time in minutes
	 */
	public void setDeptTime(int deptTime) {
		this.deptTime = deptTime;
		this.duration=  this.arrvTime - this.deptTime;
	}

	/**
	 * @return Time in minutes
	 */
	public int getArrvTime() {
		return arrvTime;
	}

	/**
	 * @param Time in minutes
	 */
	public void setArrvTime(int arrvTime) {
		this.arrvTime = arrvTime;
		this.duration=  this.arrvTime - this.deptTime;
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
	
	@Override public String toString() {
		return "" + this.number + "|" + this.dept.getIataCode() + "|" + this.deptTime + "|" +
				this.arrv.getIataCode() + "|" + this.arrvTime;
				
	}

	public int getDuration() {
		return this.duration;
	}
	
	
}
