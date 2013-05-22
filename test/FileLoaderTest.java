package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import org.junit.Before;
import org.junit.Test;

import controller.Airport;
import controller.FileLoader;
import controller.Plane;
import controller.TailContainer;

public class FileLoaderTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testPlanes() {
		TailContainer<Plane> planes = new TailContainer<Plane>();
		
		// Load the file avioes.csv
		String fileName = "airplanes.csv";
		try {
			FileLoader.loadCSV(fileName, planes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check the singleton for records
		Plane first = planes.get(0);
		assertEquals("CSTNA", first.getName());
		//assertEquals("CSTNA", first.get(0));
	}
	
	@Test //(expected=Exception.class)
	public void testAirports() {
		TailContainer<Airport> airports = new TailContainer<Airport>();
		
		// Load the file airports.csv
		String fileName = "airports.csv";
		try {
			FileLoader.loadCSV(fileName, airports);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check the singleton for records
		Airport first = airports.get(0);
		assertEquals("AMS", first.getIataCode());
		//assertEquals("AMS", first.get(0));
	}
	
	@Test(expected=NoSuchFileException.class)
	public void testFileNotFound() throws IOException {
		TailContainer<Airport> airports = new TailContainer<Airport>();
		String fileName = "idonthinkthereforeidontexist.csv";
		FileLoader.loadCSV(fileName, airports);
	}
	

}
