package edu.pitt.is17.sdj25.menumanger;

/**
 * Class: Entree
 * Author: Steve Johnston
 * Created: 2/21/2017
 */

public class Entree {
	private String name;
	private String description;
	private int calories;

	// Entree Constructor
	
	public Entree(String name, String desc, int cal) {
		this.name = name;
		this.description = desc;
		this.calories = cal;
	}

	// Entree Getter Methods
	public String getName(){
		return this.name;
	}	
	public String getDescription() {
		return this.description;
	}	
	public int getCalories() {
		return this.calories;
	}

	// Entree Setter Methods
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String desc){
		this.description = desc;
	}
	public void setCalories(int cal){
		this.calories = cal; 
	}
}
