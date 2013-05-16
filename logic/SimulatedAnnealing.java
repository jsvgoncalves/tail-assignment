package logic;

import java.util.ArrayList;

import controller.Airport;
import controller.Flight;
import controller.Plane;
import controller.TailContainer;

public class SimulatedAnnealing {

	private static ArrayList<String> representation;
	private TailContainer<Flight> fligths;
	private TailContainer<Plane> planes;
	private TailContainer<Airport> airports;
	private ArrayList<String> params;
	
	public SimulatedAnnealing(
			TailContainer<Flight> flights, TailContainer<Plane> planes, TailContainer<Airport> airports, ArrayList<String> params) {
		this.fligths = flights;
		this.planes = planes;
		this.airports = airports;
	}
	
	public static void run() {
		
	}
}
