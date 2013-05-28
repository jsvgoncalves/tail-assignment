package controller;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileLoader {
	
	public static void loadFiles(TailContainer<Plane> planes,
							TailContainer<Airport> airports,
							TailContainer<Flight> flights){
		try {
			planes = loadPlanes("airplanes.csv");
			airports = loadAirpors("airports.csv");
			flights = loadFlights("flights.csv", airports);
		} catch (NoSuchFileException e1) {
			System.err.println("File not found: " + e1.getMessage());
			System.exit(1);
		} catch (IOException e2) {
			e2.printStackTrace();
			System.exit(2);
		}
	}
	
//	public static <T> boolean loadCSV(String fileName, TailContainer<T> entity, Class<T> cl) throws IOException{
//		Path path = Paths.get(fileName);
//		Scanner sc = new Scanner(path);
//		if(sc.hasNextLine()) {
//			sc.nextLine();
//		}
//		while(sc.hasNextLine()){
//			// Use split to get the values into an array
//			String[] fields = sc.nextLine().split(",");
//			// TODO Check for consistency
//			if (fields.length > 1) {
//				// Convert to ArrayList<String> to use Entity interface
//				ArrayList<String> arr = new ArrayList<String>(Arrays.asList(fields));
//				entity.addRecord(parseArray(arr, cl));
//			} else {
//				//throw new FileNotFoundException("Error parsing CSV.");
//			}
//		}
//		sc.close();
//		return true;
//	}
	
	public static TailContainer<Flight> loadFlights(String fileName, TailContainer<Airport> airports) throws IOException{
		Path path = Paths.get(fileName);
		Scanner sc = new Scanner(path);
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		
		 TailContainer<Flight> flights = new TailContainer<Flight>();
		
		while(sc.hasNextLine()){
			// Use split to get the values into an array
			String[] fields = sc.nextLine().split(",");
			// TODO Check for consistency
			if (fields.length > 1) {
				// Convert to ArrayList<String> to use Entity interface
				ArrayList<String> arr = new ArrayList<String>(Arrays.asList(fields));
				flights.addRecord(new Flight(arr, airports));
			} else {
				//throw new FileNotFoundException("Error parsing CSV.");
			}
		}
		sc.close();
		return flights;
	}
	
	public static TailContainer<Plane> loadPlanes(String fileName) throws IOException{
		Path path = Paths.get(fileName);
		Scanner sc = new Scanner(path);
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		
		 TailContainer<Plane> planes = new TailContainer<Plane>();
		
		while(sc.hasNextLine()){
			// Use split to get the values into an array
			String[] fields = sc.nextLine().split(",");
			// TODO Check for consistency
			if (fields.length > 1) {
				// Convert to ArrayList<String> to use Entity interface
				ArrayList<String> arr = new ArrayList<String>(Arrays.asList(fields));
				planes.addRecord(new Plane(arr));
			} else {
				//throw new FileNotFoundException("Error parsing CSV.");
			}
		}
		sc.close();
		return planes;
	}
	
	public static TailContainer<Airport> loadAirpors(String fileName) throws IOException{
		Path path = Paths.get(fileName);
		Scanner sc = new Scanner(path);
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		
		TailContainer<Airport> airports = new TailContainer<Airport>();
		
		while(sc.hasNextLine()){
			// Use split to get the values into an array
			String[] fields = sc.nextLine().split(",");
			// TODO Check for consistency
			if (fields.length > 1) {
				// Convert to ArrayList<String> to use Entity interface
				ArrayList<String> arr = new ArrayList<String>(Arrays.asList(fields));
				airports.addRecord(new Airport(arr));
			} else {
				//throw new FileNotFoundException("Error parsing CSV.");
			}
		}
		sc.close();
		return airports;
	}

}
