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
		try {
			planes = FileLoader.loadPlanes("airplanes.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Plane first = planes.get(0);
		assertEquals("CSTNA", first.getPlate());
		//assertEquals("CSTNA", first.get(0));
	}
	
	@Test //(expected=Exception.class)
	public void testAirports() {
		TailContainer<Airport> airports = new TailContainer<Airport>();
		
		// Load the file airports.csv
		try {
			airports = FileLoader.loadAirpors("airports.csv");
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
		airports = FileLoader.loadAirpors(fileName);
	}
	

}
