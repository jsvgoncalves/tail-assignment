package util;

import java.io.IOException;
import java.io.PrintWriter;
import controller.Plane;
import controller.TailContainer;

public class FileExporter {
	
	public static boolean saveFile(String fileName, TailContainer<Plane> planes){
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			for (Plane plane : planes.getRecords()) {
				writer.println(plane.toString());
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
//	Path path = Paths.get(fileName);
//	Scanner sc = new Scanner(path);
//	if(sc.hasNextLine()) {
//		sc.nextLine();
//	}
//	
//	
//	while(sc.hasNextLine()){
//		// Use split to get the values into an array
//		String[] fields = sc.nextLine().split(",");
//		// TODO Check for consistency
//		if (fields.length > 1) {
//			// Convert to ArrayList<String> to use Entity interface
//			ArrayList<String> arr = new ArrayList<String>(Arrays.asList(fields));
//			flights.addRecord(new Flight(arr, airports));
//		} else {
//			//throw new FileNotFoundException("Error parsing CSV.");
//		}
//	}
//	sc.close();
//	return true;
	
	

}
