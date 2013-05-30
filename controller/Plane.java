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

	public Plane(String plate, String name, String type, double fuelAvgCostMin, double maintAvgCostMin) {
		this.plate = plate;
		this.name = name;
		this.type = type;
		this.setFuelAvgCostMin(fuelAvgCostMin);
		this.setMaintAvgCostMin(maintAvgCostMin);
		schedule = new ArrayList<Flight>();
	}
	
	/**
	 * Matricula
	 * Nome
	 * Tipo_Aviao
	 * ATC_AVG_COST_DAY
	 * MAINT_AVG_COST_MIN
	 * FUEL_AVG_COST_MIN
	 * @param arr
	 */
	public Plane(ArrayList<String> arr) {
		this.plate = arr.get(0);
		this.name = arr.get(1);
		this.type = arr.get(2);
		this.maintAvgCostMin = Double.valueOf(arr.get(4));
		this.fuelAvgCostMin = Double.valueOf(arr.get(5));
		schedule = new ArrayList<Flight>();
	}

	public Plane(Plane clone, ArrayList<Flight> schedule) {
		this.plate = clone.plate;
		this.name = clone.name;
		this.type = clone.type;
		this.maintAvgCostMin = clone.maintAvgCostMin;
		this.fuelAvgCostMin = clone.fuelAvgCostMin;
		this.schedule = schedule;
		this.totalFlyingTime = clone.totalFlyingTime;
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
		setMaintAvgCostMin(Double.valueOf(maintAvgCostMin));
	}
	public void setMaintAvgCostMin(double maintAvgCostMin) {
		this.maintAvgCostMin = maintAvgCostMin;
	}
	/**
	 * @return the fuelAvgCostMin
	 */
	public double getFuelCost() {
		return fuelAvgCostMin;
	}
	/**
	 * @param fuelAvgCostMin the fuelAvgCostMin to set
	 */
	public void setFuelAvgCostMin(String fuelAvgCostMin) {
		setFuelAvgCostMin(Integer.valueOf(fuelAvgCostMin));
	}
	
	public void setFuelAvgCostMin(double fuelAvgCostMin) {
		this.fuelAvgCostMin = fuelAvgCostMin;
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
			totalFlyingTime += f.getArrvTime() - f.getDeptTime();		
		} else {
			int addedMinutes = f.getArrvTime() - schedule.get(schedule.size()-1).getArrvTime();
			timeSinceLastMaint += addedMinutes;
			totalFlyingTime += f.getArrvTime() - f.getDeptTime();
		}
		schedule.add(f);
	}
	
	public double getCost() {
		double cost = 0;
		for (Flight flight : schedule) {
			cost += flight.getDuration()*getFuelCost();
		}
		
		return cost + getMaintCost() + getAirportCosts();
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
		return schedule.isEmpty() ||  
		(schedule.get(schedule.size()-1).arrvTime + Constraints.MIN_PARKING_TIME < flight.deptTime
		&& schedule.get(schedule.size()-1).arrv == flight.dept);
//		&& timeSinceLastMaint < Constraints.MAX_TIME_NO_MAINT * MINUTES_IN_A_DAY;
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


	public void removeFlight(Flight flight) {
		int lastIndex = this.schedule.size() - 1;
		this.schedule.remove(lastIndex); 
		
		// Verificar se havia uma manutenção e
		// Verificar o tempo desde manutenções
	}
	
	@Override public String toString() {
		//Voo,Origem,Destino,Tipo_Aviao,Partida,Chegada,Lugares_Executiva,Lugares_Economica,Lugares_Exec_Vendidos,Lugares_Econ_Vendidos
		//208,DKR,LIS,319,9/1/2009 0:35,9/1/2009 4:40,15,110,6,107
		
		//Matricula,Nome,Tipo_Aviao,ATC_AVG_COST_DAY,MAINT_AVG_COST_MIN,FUEL_AVG_COST_MIN
		//CSTNA,GRAO VASCO,320,8570,10.3,16.52
//		String string = this.plate + "," + this.name + "," + this.type;
		String string = this.plate;
		for (Flight flight : schedule) {
			string += "," + flight.number + "," + flight.deptTime;
		}
		return string;
	}

}
