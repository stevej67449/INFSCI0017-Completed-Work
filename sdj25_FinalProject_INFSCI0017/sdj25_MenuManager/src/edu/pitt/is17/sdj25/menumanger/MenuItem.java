package edu.pitt.is17.sdj25.menumanger;

import java.text.NumberFormat;
import java.util.Locale;

public class MenuItem {
	
	private String name;
	private String description;
	private int calories;
	private double price;
	
	
	/*
	 * constructor  
	 */
	public MenuItem(String name, String desc, int cal, double price) {
		this.name = name;
		this.description = desc;
		this.calories = cal;
		this.price = price;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	/*
	 * getters 
	 */
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
	
	
	/*
	 * setters 
	 */
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
	
	
}
