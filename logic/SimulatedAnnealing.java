package logic;

import java.util.ArrayList;
import java.util.Random;

import controller.Airport;
import controller.Flight;
import controller.Plane;
import controller.TailContainer;

public class SimulatedAnnealing {

	// private static ArrayList<String> representation;
//	private TailContainer<Flight> fligths;
//	private TailContainer<Plane> planes;
//	private TailContainer<Airport> airports;
//	private ArrayList<String> params;
//
//	public SimulatedAnnealing(
//			TailContainer<Flight> flights,
//			TailContainer<Plane> planes,
//			TailContainer<Airport> airports,
//			ArrayList<String> params) {
//		this.fligths = flights;
//		this.planes = planes;
//		this.airports = airports;
//	}

	public void run(TailContainer<Plane> firstSol, int iMax, double cMax) {
		TailContainer<Plane> sol = firstSol; // current solution
		double cost = cost(sol); //cost of the current solution
		System.err.println("imax = " + iMax + " cmax = " + cMax + "§ cost = " + cost);
		int i = 0;

		// Will stop after i_max iterations
		//  or after a solution with acceptable cost
		//	was found
		while (i < iMax && cost > cMax){
			// Swap some two planes' flights schedule to
			//  generate a new schedule:
			System.err.println("sa: " + i + " " + cost + "§");
			double t = temperature(i, iMax);
			swap(sol, t);

			i++;
		}
	}

	private static double probability(double t, double cost, double newCost) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Generates a new state from the previous one by searching
	 * for a possible swap of operation between two planes.
	 * @return
	 */
	public static double swap(TailContainer<Plane> sol, double temperature) {
		for (Plane pi : sol.getRecords()) {
			for (Plane pj : sol.getRecords()) {
				if (pi != pj){
					for (int i = 0; i < pi.getSchedule().size(); i++) {
						for (int j = 1; j < pj.getSchedule().size(); j++) {
							// Are these two swapable at this point?
							if (pi.compareTo(pj, i, j)) {
								// Try swap them and validate the result
								//  to see how it goes.
								ArrayList<Flight> li = (ArrayList<Flight>) pi.getSchedule().subList(0, i-1);
								li.addAll(pj.getSchedule().subList(i, pj.getSchedule().size()-1));

								ArrayList<Flight> lj = (ArrayList<Flight>) pj.getSchedule().subList(0, j-1);
								lj.addAll(pi.getSchedule().subList(i, pi.getSchedule().size()-1));
								// FIXME: is swap always a one-way operation?
								// or is the algorithm actually doing them both?
								
								if(validateSchedule(li) && validateSchedule(lj)){
									// This swap was approved.
									// Calculate cost. If i not better, randomly accept it
									
									double cost = pi.getCost() + pj.getCost();
									Plane piTemp = new Plane(pi, li);
									Plane pjTemp = new Plane(pi, li);
									double newCost = piTemp.getCost() + pjTemp.getCost();

									// The temperature value depends on the
									//  progression of the algorithm.
									Random r = new Random();

									// Probability of accepting new_sol. p is directly
									//  proportional to the value of t and inversely proportional
									//  to the value of the ratio cost/new_cost, thus:
									//  new_cost < cost => p > 100%
									double p = probability(temperature, cost, newCost);

									if (p > r.nextDouble()){
										// accept solution
										pi.setSchedule(li);
										pi.setSchedule(lj);
										pi = piTemp;
										pj = pjTemp;
										cost = newCost;
										return cost;
									}
								}
							}
						}
					}
				}
			}
		}

		return -1.0;
	}

	/**
	 * Given a sequence of flights, evaluates if the schedule
	 * complies with all constraints.
	 * @param li
	 * @return
	 */
	private static boolean validateSchedule(ArrayList<Flight> li) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * The value of temperature return is inversely
	 * proportional to the current progression of the 
	 * algorithm, given by i.
	 * @param i
	 * @param iMax
	 * @return
	 */
	private static double temperature(int i, int iMax) {
		return iMax/i;
	}

	private static double cost(TailContainer<Plane> sol) {
		double cost = 0;

		for (int i = 0; i < sol.size(); i++) {
			((Plane)sol.get(i)).getCost();
		}

		return cost;
	}
}
