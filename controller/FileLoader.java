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
			boolean planes_loaded = loadPlanes("airplanes.csv", planes);
			boolean airports_loaded = loadAirports("airports.csv", airports);
			boolean flights_loaded = loadFlights("flights-treated.csv", flights, airports);
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
	
	public static boolean loadFlights(String fileName, TailContainer<Flight> flights, TailContainer<Airport> airports) throws IOException{
		Path path = Paths.get(fileName);
		Scanner sc = new Scanner(path);
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		
		
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
		return true;
	}
	
	public static boolean loadPlanes(String fileName, TailContainer<Plane> planes) throws IOException{
		Path path = Paths.get(fileName);
		Scanner sc = new Scanner(path);
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		
		
		while(sc.hasNextLine()){
			// Use split to get the values into an array
			String[] fields = sc.nextLine().split(",");
			// TODO Check for consistency
			if (fields.length > 1) {
				// Convert to ArrayList<String> to use Entity interface
				ArrayList<String> arr = new ArrayList<String>(Arrays.asList(fields));
				Plane plane = new Plane(arr);
//				System.out.println(plane.getName());
				planes.addRecord(plane);
			} else {
				//throw new FileNotFoundException("Error parsing CSV.");
			}
		}
		sc.close();
//		System.out.println("size " + planes.size());
		return true;
	}
	
	public static boolean loadAirports(String fileName, TailContainer<Airport> airports) throws IOException{
		Path path = Paths.get(fileName);
		Scanner sc = new Scanner(path);
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		
		
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
		return true;
	}

}
