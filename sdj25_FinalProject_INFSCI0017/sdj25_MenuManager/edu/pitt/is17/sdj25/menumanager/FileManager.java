package edu.pitt.is17.sdj25.menumanager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Class: FileManager
 * @author: Steven Johnston
 * @created: 03/12/2017
 */

public class FileManager {

	/**
	 * Method readItems
	 * @param fileName of a textfile holding the menu to be processed
	 * @return an Array List of MenuItems objects
	 */

	public static ArrayList<MenuItem> readItems(String fileName){

		// Create and initialize itemArray List 
		ArrayList<MenuItem> itemArray = new ArrayList<MenuItem>();

		try {
			// Take in and scan text file
			Scanner s = new Scanner(new File(fileName));

			// Begin iterating through scanned file
			while(s.hasNextLine()){
				String line = s.nextLine();
				String[] lineParts = line.split("@@");

				String name = lineParts[0];
				String desc = lineParts[2];
				int cal = Integer.parseInt(lineParts[3]);
				double price = Double.parseDouble(lineParts[4]);


				// Build new item and add it to itemArray
				if(lineParts[1].equalsIgnoreCase("appetizer")){
					Appetizer newAppetizer = new Appetizer(name, desc, cal,price);
					itemArray.add(newAppetizer);
				} else if (lineParts[1].equalsIgnoreCase("entree")) {
					Entree newEntree = new Entree(name, desc, cal,price);
					itemArray.add(newEntree);
				} else if (lineParts[1].equalsIgnoreCase("side")) {
					Side newSide = new Side(name, desc, cal,price);
					itemArray.add(newSide);
				} else if (lineParts[1].equalsIgnoreCase("beer")) {
					Beer newBeer = new Beer(name, desc, cal,price);
					itemArray.add(newBeer);
				} //End conditional statements		
			} // End While loop
			//Close scanner
			s.close();

		} catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}

		return itemArray;

	} // End of readItems Method

	/**
	 * Method writeMenu
	 * @param fileName String and ArrayList of type Menu
	 * @return void, but writes the input Array to file
	 */

	public static void writeMenu(String fileName, ArrayList<Menu> menus) throws FileNotFoundException {
		// Open a new PrintWriter and use the fileName parameter as the saving location
		PrintWriter out = new PrintWriter(fileName);
		// Iterate through each menu in the array and print the relevant details
		for (int i = 0; i < menus.size(); i++) {
			out.println("\nMenu Name: " + menus.get(i).toString());
			out.println("Total Price: " + menus.get(i).totalPrice());
			out.println("Total Calories: " + menus.get(i).totalCalories() +"\n");
			out.println("Entree: " + menus.get(i).getEntree().getDescription()+"\n");
			out.println("Side: " + menus.get(i).getSide().getDescription()+"\n");
			out.println("Appetizer: " + menus.get(i).getAppetizer().getDescription()+"\n");
			out.println("Beer: " + menus.get(i).getBeer().getDescription() + "\n");
			out.println("************************************************************");	
		} // End of for loop
		// Close PrintWriter	
		out.close();
	} // End of writeMenus method

} // End of FileManager class