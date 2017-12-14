package edu.pitt.is17.sdj25.menumanger;

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

	// Total Calories Method
	public int totalCalories() {

		int entreeCal;
		int sideCal;
		int appetizerCal;
		int beerCal;

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

		int totalCal = 	entreeCal + sideCal + appetizerCal + beerCal;
		return totalCal;
	}

	// Description Method
	public String description() {
		String appetizerDesc;
		String entreeDesc;
		String sideDesc;
		String beerDesc;

		if (appetizer != null) {
			appetizerDesc = "\tAppetizer: " + appetizer.getName() + ". " + appetizer.getDescription() + "\n";
		} else {
			appetizerDesc = "\tAppetizer: N/A\n";
		}

		if (entree != null) {
			entreeDesc = "\tEntree: " + entree.getName() + ". " + entree.getDescription() + "\n";
		} else {
			entreeDesc = "\tEntree: N/A\n";
		}

		if (side != null) {
			sideDesc = "\tSide: " + side.getName() + ". " + side.getDescription() + "\n";
		} else {
			sideDesc = "\tSide: N/A\n";	
		}

		if (beer != null) {
			beerDesc = "\tBeer: " + beer.getName() + ". " + beer.getDescription() + "\n";
		} else {
			beerDesc = "\tBeer: N/A\n";	
		}

		String menuDesc = appetizerDesc + entreeDesc + sideDesc + beerDesc;

		return menuDesc;
	}


}
