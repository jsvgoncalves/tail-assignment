package controller;

import java.util.ArrayList;

import util.Constraints;

public class Plane {
	
	private static final int MINUTES_IN_A_DAY = 1440;

	/**  License plate number */
	private String plate; 
	private String name;
	private String type;
	
	/** Average overflight fees per day. Only relevant when
	 * the aircraft performs any flight. */
	private int atcAvgCostDay;
	
	/** Maintenance cost of the airplane per minute. */
	private double maintAvgCostMin;

	/** Average fuel spending per minute */
	private double fuelAvgCostMin;

	/**
	 * The sequence of flights that this plane will
	 * perform, ordered by flight departure time.
	 * The restrictions of the algorithms should assure
	 * that the flights' times never overlap.
	 */
	private ArrayList<Flight> schedule;

	/** Counts the time since last maintenance was scheduled for this plane */
	private int timeSinceLastMaint = 0;
	
	/** Sum of total flight time. Does not take into account
	 * the period between flights */
	private int totalFlyingTime = 0;

	public Plane(String plate, String name, String type) {
		this.plate = plate;
		this.name = name;
		this.type = type;
		schedule = new ArrayList<Flight>();
	}

	private double maintCostTotal;

	
//	private Plane() {
//		schedule = new ArrayList<Flight>(0);
//	}
	
	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}
	
	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/** Average overflight fees per day.
	 * Only relevant when the aircraft
	 * performs any flight in each day.
	 * @return the atcAvgCostDay
	 */
	public int getAtcAvgCostDay() {
		return atcAvgCostDay;
		// return (schedule.isEmpty()) ? 0 : atcAvgCostDay;
	}
	public void setAtcAvgCostDay(int atcAvgCostDay) {
		this.atcAvgCostDay = atcAvgCostDay;
	}
	/**
	 * @param atcAvgCostDay the atcAvgCostDay to set
	 */
	public void setAtcAvgCostDay(String atcAvgCostDay) {
		this.atcAvgCostDay = Integer.valueOf(atcAvgCostDay);
	}
	/**
	 * @return the maintAvgCostMin
	 */
	public double getMaintAvgCostMin() {
		return maintAvgCostMin;
	}
	/**
	 * @param maintAvgCostMin the maintAvgCostMin to set
	 */
	public void setMaintAvgCostMin(String maintAvgCostMin) {
		this.maintAvgCostMin = Integer.valueOf(maintAvgCostMin);
	}
	/**
	 * @return the fuelAvgCostMin
	 */
	public double getFuelCost() {
		return fuelAvgCostMin * totalFlyingTime;
	}
	/**
	 * @param fuelAvgCostMin the fuelAvgCostMin to set
	 */
	public void setFuelAvgCostMin(String fuelAvgCostMin) {
		this.fuelAvgCostMin = Integer.valueOf(fuelAvgCostMin);
	}
	
	public ArrayList<Flight> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Flight> schedule) {
		this.schedule = schedule;
	}
//	/**
//	 * @return the location
//	 */
//	public String getLocation() {
//		return location;
//	}
//	/**
//	 * @param location the location to set
//	 */
//	public void setLocation(String location) {
//		this.location = location;
//	}
	
	/**
	 * Updates the time-space location of the instance
	 * of this plane in the algorithm.
	 * @param f
	 */
	public void update(Flight f) {
		// The following LOC obtains the time added
		//  to the schedule, including the period
		//  between flights.
		if(f.isMaintenance()){
			timeSinceLastMaint = 0;
//			maintAvgCostTotal += f.getArrvTime() - f.getDeptTime();
			maintCostTotal += f.getArrvTime() - f.getDeptTime();
		} else if(schedule.isEmpty()){
			int addedMinutes = f.getArrvTime() - f.getArrvTime();
			timeSinceLastMaint += addedMinutes;
			totalFlyingTime += f.getArrvTime() - f.getDeptTime();		} else {
			int addedMinutes = f.getArrvTime() - schedule.get(schedule.size()-1).getArrvTime();
			timeSinceLastMaint += addedMinutes;
			totalFlyingTime += f.getArrvTime() - f.getDeptTime();
		}
		schedule.add(f);
	}
	
	public double getCost() {
		for (Flight scFlight : schedule) {
			
		}
		
		return getFuelCost() + getMaintCost() + getAirportCosts();
	}
	
	/**
	 * @return The total cost of airport fees (parking, landing, overflight)
	 * from the schedule of this airplane.
	 */
	private double getAirportCosts() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private double getMaintCost() {
		return maintAvgCostMin * maintCostTotal;
	}
	
	public boolean canPerform(Flight flight) {
		return 
		schedule.get(schedule.size()).arrvTime + Constraints.MIN_PARKING_TIME < flight.deptTime
		&& schedule.get(schedule.size()).arrv.equals(flight.arrv)
		&& timeSinceLastMaint < Constraints.MAX_TIME_NO_MAINT * MINUTES_IN_A_DAY;
	}

	/**
	 * Compares flight with Index1 of this plane and flight with Index2
	 * of plane "p" and returns whether they are interchangeable, i.e.
	 * is both planes are on the same airport at the same time and can swap
	 * schedules at that time.
	 * @param p
	 * @param flightIndex1
	 * @param flightIndex2
	 * @return True if schedules are interchangeable at index1
	 * of this.schedule and index2 of p.schedule
	 */
	public boolean compareTo(Plane p, int flightIndex1, int flightIndex2) {
		return schedule.get(flightIndex1).getDept()
				== p.schedule.get(flightIndex2).getDept()
			&& schedule.get(flightIndex1).getDeptTime() - Constraints.MIN_PARKING_TIME
				> p.schedule.get(flightIndex2 - 1).getDeptTime();
	}
	
	

}
