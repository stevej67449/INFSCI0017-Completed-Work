package edu.pitt.is17.sdj25.menumanger;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class MenuRandomize
 * @author Steven Johnston
 *	@created 03/12/2017
 */

public class MenuRandomize {

	// Declare and initialize arraylists for every menu item
	private ArrayList<Appetizer> appetizers = new ArrayList<Appetizer>();	
	private ArrayList<Entree> entrees = new ArrayList<Entree>();
	private ArrayList<Side> sides = new ArrayList<Side>();
	private ArrayList<Beer> beers = new ArrayList<Beer>();	

	/**
	 * Constructor MenuRandomize
	 * @param appetizerFile a String specifying the appetizers file location
	 * @param entreeFile a String specifying the entrees file location
	 * @param sideFile a String specifying the sides file location
	 * @param beerFile a String specifying the beers file location
	 * @return an MenuRandomize object containing arraylists for all menu items
	 */

	public MenuRandomize(String appetizerFile,String entreeFile, String sideFile, String beerFile) {

		// Load the MenuRandomize properties with data using the FileManager's readAppetizers method
		try {
			appetizers = FileManager.readAppetizers(appetizerFile);	
			entrees = FileManager.readEntrees(entreeFile);	
			sides = FileManager.readSides(sideFile);	
			beers = FileManager.readBeers(beerFile);

		} catch (FileNotFoundException e) {
			System.out.println("Uh-oh, we couldnt find your file.");
			e.printStackTrace();
		}
	} // End of MenuRandomize constructor 

	/**
	 * Method randomMenu
	 * @return a Menu built from randomly selected items in each menu category stored within a MenuRandomize object
	 */

	public Menu randomMenu(){

		// Variable to be used to access specific elements within the arraylists 
		int appetizerRandom;
		int entreeRandom;
		int sideRandom;
		int beerRandom;

		// Random class used so an upperbound can be set and the random number
		// will not exceed the number of elements within an arraylist
		Random randomNumber = new Random();

		// Appetizer randomizer, if the arraylist only contains one item randomization is not possible
		if (appetizers.size() == 1) {
			appetizerRandom = 0;
		} else {
			appetizerRandom = (Integer) randomNumber.nextInt(appetizers.size());
		}

		// Entree randomizer
		if (entrees.size() == 1) {
			entreeRandom = 0;
		} else {
			entreeRandom = (Integer) randomNumber.nextInt(entrees.size());
		}

		// Side randomizer
		if (sides.size() == 1) {
			sideRandom = 0;
		} else {
			sideRandom = (Integer) randomNumber.nextInt(sides.size());
		}

		// Beer randomizer 
		if (beers.size() == 1) {
			beerRandom = 0;
		} else {
			beerRandom = (Integer) randomNumber.nextInt(beers.size());
		}

		// Build a new Menu object using random values for the arraylist's get method
		Menu newMenu = new Menu("Random Menu",entrees.get(entreeRandom),sides.get(sideRandom),appetizers.get(appetizerRandom),beers.get(beerRandom));
		return newMenu;


	} // End of randomMenu method



} // End of MenuRandomize class
