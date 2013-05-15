package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.Airports;
import controller.FileLoader;
import controller.Planes;

public class FileLoaderTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testPlanes() {
		Planes planes = Planes.getPlanes();
		
		// Load the file avioes.csv
		String fileName = "airplanes.csv";
		try {
			FileLoader.loadCSV(fileName, planes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check the singleton for records
		ArrayList<String> first = planes.getRecord(0);
		assertEquals("CSTNA", first.get(0));
	}
	
	@Test //(expected=Exception.class)
	public void testAirports() {
		Airports airports = Airports.getAirports();
		
		// Load the file airports.csv
		String fileName = "airports.csv";
		try {
			FileLoader.loadCSV(fileName, airports);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check the singleton for records
		ArrayList<String> first = airports.getRecord(0);
		assertEquals("AMS", first.get(0));
	}
	
	@Test(expected=NoSuchFileException.class)
	public void testFileNotFound() throws IOException {
		Airports airports = Airports.getAirports();
		String fileName = "idonthinkthereforeidontexist.csv";
		FileLoader.loadCSV(fileName, airports);
	}
	

}
