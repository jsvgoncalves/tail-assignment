package logic;

import java.util.ArrayList;

import controller.Airports;
import controller.Flights;
import controller.Planes;

public class SimulatedAnnealing {

	private static ArrayList<String> representation;
	private Flights fligths;
	private Planes planes;
	private Airports airports;
	private ArrayList<String> params;
	
	public SimulatedAnnealing(
			Flights flights, Planes planes, Airports airports, ArrayList<String> params) {
		this.fligths = flights;
		this.planes = planes;
		this.airports = airports;
	}
	
	public static void run() {
		
	}
}
