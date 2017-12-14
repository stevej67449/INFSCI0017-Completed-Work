package edu.pitt.is17.sdj25.menumanger;

/** 
 * Class FileManager
 * @author Steven Johnston
 * @created: 03/12/2017
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class FileManager {

	/**
	 * Method readAppetizers
	 * @param fileName a String specifying the file location
	 * @return an Array List of Appetizer objects
	 */

	public static ArrayList<Appetizer> readAppetizers(String fileName) throws FileNotFoundException{

		// Take in and scan Appetizer text file
		Scanner s = new Scanner(new File(fileName));

		// Create and initialize Appetizer Array List 
		ArrayList<Appetizer> appArray = new ArrayList<Appetizer>();

		// Begin iterating through scanned file
		while(s.hasNextLine()){
			// Construct an array using "@@" as a delimiter
			String[] words = s.nextLine().split("@@");

			// Start at beginning of array and advance by 3 to reach start of the following item's data
			for (int i = 0; i < words.length; i+= 3){

				// Identify Appetizer Name, Desc, and Cal elements 
				String appName = words[i];
				String appDesc = words[i + 1];
				int appCal = Integer.parseInt(words[i + 2]); 

				// Build new Appetizer	
				Appetizer fullApp = new Appetizer(appName, appDesc, appCal);

				// Add new Appetizer to appArray	
				appArray.add(fullApp);

			} // End For loop
		} // End While loop

		s.close();
		return appArray;

	} // End of readAppetizers Method

	/**
	 * Method readEntrees
	 * @param fileName a String specifying the file location
	 * @return an Array List of Entrees objects
	 */

	public static ArrayList<Entree> readEntrees(String fileName) {

		try {
			// Take in and scan Entree text file
			Scanner s = new Scanner(new File(fileName));

			// Create and initialize Entree Array List 
			ArrayList<Entree> entreeArray = new ArrayList<Entree>();

			// Begin iterating through scanned file
			while(s.hasNextLine()){
				// Construct an array using "@@" as a delimiter
				String[] words = s.nextLine().split("@@");

				// Start at beginning of array and advance by 3 to reach start of the following items data
				for (int i = 0; i < words.length; i+= 3){

					// Identify Entree Name, Desc, and Cal elements 
					String entreeName = words[i];
					String entreeDesc = words[i + 1];
					int entreeCal = Integer.parseInt(words[i + 2]); 

					// Build new Entree using name, desc, and cal elements
					Entree fullEntree = new Entree(entreeName, entreeDesc, entreeCal);

					// Add new Entree to entreeArray	
					entreeArray.add(fullEntree);

				} // End For loop
			} // End While loop

			s.close();
			return entreeArray;

		} catch (FileNotFoundException e) {
			System.out.println("Uh-oh, we couldnt find your file.");
			e.printStackTrace();
			return null;
		}


	} // End of readEntrees Method

	/**
	 * Method readSides
	 * @param fileName a String specifying the file location
	 * @return an Array List of Side objects
	 */

	public static ArrayList<Side> readSides(String fileName) throws FileNotFoundException{

		// Take in and scan Side text file
		Scanner s = new Scanner(new File(fileName));

		// Create and initialize Side Array List 
		ArrayList<Side> sideArray = new ArrayList<Side>();

		// Begin iterating through scanned file
		while(s.hasNextLine()){
			// Construct an array using "@@" as a delimiter
			String[] words = s.nextLine().split("@@");

			// Start at beginning of array and advance by 3 to reach start of the following items data
			for (int i = 0; i < words.length; i+= 3){

				// Identify Side Name, Desc, and Cal elements 
				String sideName = words[i];
				String sideDesc = words[i + 1];
				int sideCal = Integer.parseInt(words[i + 2]); 

				// Build new Side using name, desc, and cal elements
				Side fullSide = new Side(sideName, sideDesc, sideCal);

				// Add new Side to sideArray	
				sideArray.add(fullSide);

			} // End For loop
		} // End While loop

		s.close();
		return sideArray;
	} // End of readSides Method

	/**
	 * Method readBeers
	 * @param fileName a String specifying the file location
	 * @return an Array List of Beer objects
	 */	

	public static ArrayList<Beer> readBeers(String fileName) throws FileNotFoundException{

		// Take in and scan Beer text file
		Scanner s = new Scanner(new File(fileName));

		// Create and initialize Beer Array List 
		ArrayList<Beer> beerArray = new ArrayList<Beer>();

		// Begin iterating through scanned file
		while(s.hasNextLine()){
			// Construct an array using "@@" as a delimiter
			String[] words = s.nextLine().split("@@");

			// Start at beginning of array and advance by 3 to reach start of the following items data
			for (int i = 0; i < words.length; i+= 3){

				// Identify Beer Name, Desc, and Cal elements 
				String beerName = words[i];
				String beerDesc = words[i + 1];
				int sideCal = Integer.parseInt(words[i + 2]); 

				// Build new Beer using name, desc, and cal elements
				Beer fullBeer = new Beer(beerName, beerDesc, sideCal);

				// Add new Beer to beerArray	
				beerArray.add(fullBeer);

			} // End For loop
		} // End While loop

		s.close();
		return beerArray;
	} // End of readBeers Method



} // End of FileManager class


