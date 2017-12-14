package edu.pitt.is17.sdj25.menumanager;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Class: Menu
 * Author: Steve Johnston
 * Created: 2/21/2017
 */

public class Menu {
	private String name;
	private Appetizer appetizer;
	private Entree entree;
	private Side side;
	private Beer beer;


	// Menu Constructors	
	public Menu(String name) {
		this.name = name;
		this.entree = null;
		this.side = null;
		this.appetizer = null;
		this.beer = null;
	}
	public Menu(String name, Entree entree, Side side) {	
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.appetizer = null;
		this.beer = null;
	}
	public Menu(String name, Entree entree, Side side, Appetizer appetizer, Beer beer) {	
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.appetizer = appetizer;
		this.beer = beer;
	}

	// Menu Getter Methods
	public String getName() {
		return this.name;
	}
	public Appetizer getAppetizer() {
		return this.appetizer;
	}
	public Entree getEntree() {
		return this.entree;
	}
	public Side getSide() {
		return this.side;
	}
	public Beer getBeer() {
		return this.beer;
	}

	// Menu Setter Methods
	public void setName(String name) {
		this.name = name;
	}
	public void setAppetizer(Appetizer appetizer) {
		this.appetizer = appetizer;
	}
	public void setEntree(Entree entree) {
		this.entree = entree;
	}
	public void setSide(Side side) {
		this.side = side;
	}
	public void setBeer(Beer beer) {
		this.beer = beer;
	}

	/* Method totalCalories
	 * @return an int of total menu calories
	 */

	public int totalCalories() {
		// Variables to hold item calorie counts
		int entreeCal;
		int sideCal;
		int appetizerCal;
		int beerCal;

		//For each item, get it's calories and save them in the respective variables
		if (entree != null) {
			entreeCal = entree.getCalories();
		} else {
			entreeCal = 0;
		}
		if (side != null) {
			sideCal = side.getCalories();
		} else {
			sideCal = 0;
		}
		if (appetizer != null) {
			appetizerCal = appetizer.getCalories();
		} else {
			appetizerCal = 0;
		}
		if (beer != null) {
			beerCal = beer.getCalories();
		} else {
			beerCal = 0;
		}
		// Add all items individual calorie counts together
		int totalCal = 	entreeCal + sideCal + appetizerCal + beerCal;
		return totalCal;
	} // End totalCal Method

	/* Method totalCalories
	 * @return an String formated for US currency 
	 */
	public String totalPrice() {
		// Variables for holding item price
		double entreePrice;
		double sidePrice;
		double appetizerPrice;
		double beerPrice;

		//For each item, get it's price and save them in the respective variables
		if (entree != null) {
			entreePrice = entree.getPrice();
		} else {
			entreePrice = 0;
		}
		if (side != null) {
			sidePrice = side.getPrice();
		} else {
			sidePrice = 0;
		}
		if (appetizer != null) {
			appetizerPrice = appetizer.getPrice();
		} else {
			appetizerPrice = 0;
		}
		if (beer != null) {
			beerPrice = beer.getPrice();
		} else {
			beerPrice = 0;
		}


		// Add all items individual calorie counts together
		double totalPrice = entreePrice + sidePrice + appetizerPrice + beerPrice;
		// Format the double totalPrice into a string that manages signs and decimal places			
		return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(totalPrice);
	}

	// Description Method constructs a full description of each item including calorie counts and prices
	public String description() {
		String appetizerDesc;
		String entreeDesc;
		String sideDesc;
		String beerDesc;

		if (appetizer != null) {
			appetizerDesc = "\tAppetizer: " + appetizer.getName() + ". " + appetizer.getDescription() + 
					"\tCalories: " + appetizer.getCalories() + "\tPrice: " 
					+ NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(appetizer.getPrice())+ "\n";
		} else {
			appetizerDesc = "\tAppetizer: N/A\n";
		}

		if (entree != null) {
			entreeDesc = "\tEntree: " + entree.getName() + ". " + entree.getDescription() + 
					"\tCalories: " + entree.getCalories() + "\tPrice: " 
					+ NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(entree.getPrice())+ "\n";
		} else {
			entreeDesc = "\tEntree: N/A\n";
		}

		if (side != null) {
			sideDesc = "\tSide: " + side.getName() + ". " + side.getDescription() + 
					"\tCalories: " + side.getCalories() + "\tPrice: " 
					+ NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(side.getPrice())+ "\n";
		} else {
			sideDesc = "\tSide: N/A\n";	
		}

		if (beer != null) {
			beerDesc = "\tBeer: " + beer.getName() + ". " + beer.getDescription() + 
					"\tCalories: " + beer.getCalories() + "\tPrice: " 
					+ NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(beer.getPrice())+ "\n";
		} else {
			beerDesc = "\tBeer: N/A\n";	
		}

		String menuDesc = appetizerDesc + entreeDesc + sideDesc + beerDesc;

		return menuDesc;
	}

	//Override toString method to return the name of menu
	@Override
	public String toString() {
		return this.name;
	}


} //End of Menu class
