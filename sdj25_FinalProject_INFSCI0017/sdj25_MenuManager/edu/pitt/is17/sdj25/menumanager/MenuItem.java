package edu.pitt.is17.sdj25.menumanager;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Class: Entree
 * Author: Steve Johnston
 * Created: 4/08/2017
 */

public class MenuItem {

	private String name;
	private String description;
	private int calories;
	private double price;


	/**
	 * Method menuItem constructor
	 * @param item name, description, calorie count, and price
	 * @return a new MeunItem object
	 */

	public MenuItem(String name, String desc, int cal, double price) {
		this.name = name;
		this.description = desc;
		this.calories = cal;
		this.price = price;
	}

	//Override toString method to return the name of item
	@Override
	public String toString(){
		return this.name;
	}

	//MenuItem getters
	public String getName() {
		return name;
	}
	public String getDescription() {
		String fullDesc = name + "\n" + description +
				"\nCalories: " + calories + "\tPrice: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(price);;

				return fullDesc;
	}
	public int getCalories() {
		return calories;
	}
	public double getPrice() {
		return price;
	}

	//MenuItem setters
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setPrice(double price) {
		this.price = price;
	}


} //End of MenuItem class
