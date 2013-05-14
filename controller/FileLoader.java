package controller;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileLoader {
	
	public static void main(String[] args){
		loadCSV("avioes.csv", null);
	}
	
	public static boolean loadCSV(String fileName, Object obj){
		System.out.println("Reading");
		Path path = Paths.get(fileName);
		try(Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()){
				System.out.println("Read: " + sc.nextLine());
			}
		} catch(Exception e){
			System.err.println("Won't read: " + e.getMessage());
		}
		
		return false;
	}

}
