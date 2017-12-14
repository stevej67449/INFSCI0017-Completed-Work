package edu.pitt.is17.sdj25.menumanger;

/**
 * Class: MenuTest
 * Author: Steve Johnston
 * Created: 3/16/2017
 */

public class MenuTester{
	public static void main(String[] args) {
		MenuManager randomize = new MenuManager("data/dishes.txt");

		
		Menu myMenu = randomize.randomMenu();
		Menu myMenu2 = randomize.minCaloriesMenu("little bits");
		Menu myMenu3 = randomize.maxCaloriesMenu("lotta bits");
		
		System.out.println(myMenu.description()+"\nTotal Calories: "+
							myMenu.totalCalories() +"\nTotal Price: " + myMenu.totalPrice());
		
		System.out.println(myMenu2.description()+"\nTotal Calories: "+
				myMenu2.totalCalories() +"\nTotal Price: " + myMenu2.totalPrice());
		
		System.out.println(myMenu3.description()+"\nTotal Calories: "+
				myMenu3.totalCalories() +"\nTotal Price: " + myMenu3.totalPrice());
	}
}
