package controller;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileLoader {
	
	public static void main(String[] args){
		TailContainer<Plane> planes = new TailContainer<Plane>();
		TailContainer<Airport> airports = new TailContainer<Airport>();
		TailContainer<Flight> flights = new TailContainer<Flight>();
		
		try {
			loadCSV("airplanes.csv", planes);
			loadCSV("airports.csv", airports);
		} catch (NoSuchFileException e1) {
			System.err.println("File not found: " + e1.getMessage());
		} catch (IOException e2) {
			System.err.println("Something really bad happened.");
		}
		
		
	}
	
	public static <T> boolean loadCSV(String fileName, TailContainer<T> entity) throws IOException{
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
				entity.add(arr);
			} else {
				//throw new FileNotFoundException("Error parsing CSV.");
			}
		}
		sc.close();
		return true;
	}

}
