package edu.pitt.is17.sdj25.menumanger;

/**
 * Class: Side
 * Author: Steve Johnston
 * Created: 2/21/2017
 */

public class Side {
	private String name;
	private String description;
	private int calories;


	// Side Constructor
	
	public Side(String name, String desc, int cal) {
		this.name = name;
		this.description = desc;
		this.calories = cal;
	}

	// Side Getter Methods
	public String getName(){
		return this.name;
	}	
	public String getDescription() {
		return this.description;
	}	
	public int getCalories() {
		return this.calories;
	}

	// Side Setter Methods
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
