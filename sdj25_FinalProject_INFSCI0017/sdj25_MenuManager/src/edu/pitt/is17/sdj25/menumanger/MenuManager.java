package edu.pitt.is17.sdj25.menumanger;

import java.util.ArrayList;
import java.util.Random;

public class MenuManager {
	
	// Declare and initialize arraylists for every menu item
	private ArrayList<Appetizer> appetizers = new ArrayList<Appetizer>();	
	private ArrayList<Entree> entrees = new ArrayList<Entree>();
	private ArrayList<Side> sides = new ArrayList<Side>();
	private ArrayList<Beer> beers = new ArrayList<Beer>();	
	
	public MenuManager(String dishesFile) {
		ArrayList<MenuItem> newMenu = FileManager.readItems(dishesFile);
		
		for (int i = 0; i < newMenu.size(); i++) {
			if (newMenu.get(i) instanceof Appetizer) {
				appetizers.add((Appetizer) newMenu.get(i));
			} else if (newMenu.get(i) instanceof Entree) {
				entrees.add((Entree) newMenu.get(i));
			} else if (newMenu.get(i) instanceof Side) {
				sides.add((Side) newMenu.get(i));
			} else if (newMenu.get(i) instanceof Beer) {
				beers.add((Beer) newMenu.get(i));
			}
		}
	} // End of constructor method
	
	public Menu randomMenu(String name){

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
		Menu newMenu = new Menu(name,entrees.get(entreeRandom),sides.get(sideRandom),appetizers.get(appetizerRandom),beers.get(beerRandom));
		return newMenu;


	} // End of randomMenu method
	
	public Menu minCaloriesMenu (String name){
		Appetizer minAppetizer = appetizers.get(0);
		Entree minEntree = entrees.get(0);
		Side minSide = sides.get(0);
		Beer minBeer = beers.get(0);
		
		// Appetizer minCal finder
		for (int i = 1; i < appetizers.size(); i++) {
			if (appetizers.get(i).getCalories() < minAppetizer.getCalories()){
				minAppetizer = appetizers.get(i);
			}
		}
		
		//Entree minCal finder
		for (int i = 1; i < entrees.size(); i++) {
			if (entrees.get(i).getCalories() < minEntree.getCalories()){
				minEntree = entrees.get(i);
			}
		}
		
		//Side minCal finder
		for (int i = 1; i < sides.size(); i++) {
			if (sides.get(i).getCalories() < minSide.getCalories()){
				minSide = sides.get(i);
			}
		}
		
		//Beer minCal finder
		for (int i = 1; i < beers.size(); i++) {
			if (beers.get(i).getCalories() < minBeer.getCalories()){
				minBeer = beers.get(i);
			}
		}
		
		Menu minCal = new Menu(name, minEntree, minSide, minAppetizer, minBeer);
		return minCal;
			
	} // End minCaloriesMenu method
	
	public Menu maxCaloriesMenu (String name){
			Appetizer maxAppetizer = appetizers.get(0);
			Entree maxEntree = entrees.get(0);
			Side maxSide = sides.get(0);
			Beer maxBeer = beers.get(0);
			
			// Appetizer maxCal finder
			for (int i = 1; i < appetizers.size(); i++) {
				if (appetizers.get(i).getCalories() > maxAppetizer.getCalories()){
					maxAppetizer = appetizers.get(i);
				}
			}
			
			//Entree maxCal finder
			for (int i = 1; i < entrees.size(); i++) {
				if (entrees.get(i).getCalories() > maxEntree.getCalories()){
					maxEntree = entrees.get(i);
				}
			}
			
			//Side maxCal finder
			for (int i = 1; i < sides.size(); i++) {
				if (sides.get(i).getCalories() > maxSide.getCalories()){
					maxSide = sides.get(i);
				}
			}
			
			//Beer maxCal finder
			for (int i = 1; i < beers.size(); i++) {
				if (beers.get(i).getCalories() > maxBeer.getCalories()){
					maxBeer = beers.get(i);
				}
			}
			
			Menu maxCal = new Menu(name, maxEntree, maxSide, maxAppetizer, maxBeer);
			return maxCal;
					
	} // End maxCalorieMenu method
	
	public Menu leastExpMenu (String name){
		Appetizer minAppetizer = appetizers.get(0);
		Entree minEntree = entrees.get(0);
		Side minSide = sides.get(0);
		Beer minBeer = beers.get(0);
		
		// Appetizer minCal finder
		for (int i = 1; i < appetizers.size(); i++) {
			if (appetizers.get(i).getPrice() < minAppetizer.getPrice()){
				minAppetizer = appetizers.get(i);
			}
		}
		
		//Entree minCal finder
		for (int i = 1; i < entrees.size(); i++) {
			if (entrees.get(i).getPrice() < minEntree.getPrice()){
				minEntree = entrees.get(i);
			}
		}
		
		//Side minCal finder
		for (int i = 1; i < sides.size(); i++) {
			if (sides.get(i).getPrice() < minSide.getPrice()){
				minSide = sides.get(i);
			}
		}
		
		//Beer minCal finder
		for (int i = 1; i < beers.size(); i++) {
			if (beers.get(i).getPrice() < minBeer.getPrice()){
				minBeer = beers.get(i);
			}
		}
		
		Menu minPrice = new Menu(name, minEntree, minSide, minAppetizer, minBeer);
		return minPrice;
			
	} // End leastExpMenu method

	public Menu mostExpMenu (String name){
		Appetizer maxAppetizer = appetizers.get(0);
		Entree maxEntree = entrees.get(0);
		Side maxSide = sides.get(0);
		Beer maxBeer = beers.get(0);
		
		// Appetizer maxPrice finder
		for (int i = 1; i < appetizers.size(); i++) {
			if (appetizers.get(i).getPrice() > maxAppetizer.getPrice()){
				maxAppetizer = appetizers.get(i);
			}
		}
		
		//Entree maxPrice finder
		for (int i = 1; i < entrees.size(); i++) {
			if (entrees.get(i).getPrice() > maxEntree.getPrice()){
				maxEntree = entrees.get(i);
			}
		}
		
		//Side maxPrice finder
		for (int i = 1; i < sides.size(); i++) {
			if (sides.get(i).getPrice() < maxSide.getPrice()){
				maxSide = sides.get(i);
			}
		}
		
		//Beer maxPrice finder
		for (int i = 1; i < beers.size(); i++) {
			if (beers.get(i).getPrice() < maxBeer.getPrice()){
				maxBeer = beers.get(i);
			}
		}
		
		Menu maxPrice = new Menu(name, maxEntree, maxSide, maxAppetizer, maxBeer);
		return maxPrice;
			
	} // End mostExpMenu method
	
	public ArrayList<Appetizer> getAppetizers() {
		return appetizers;
	}

	public void setAppetizers(ArrayList<Appetizer> appetizers) {
		this.appetizers = appetizers;
	}

	public ArrayList<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}

	public ArrayList<Side> getSides() {
		return sides;
	}

	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}

	public ArrayList<Beer> getBeers() {
		return beers;
	}

	public void setBeers(ArrayList<Beer> beers) {
		this.beers = beers;
	}
	
	
	
}
