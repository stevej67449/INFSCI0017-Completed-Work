package edu.pitt.is17.sdj25.menumanger;

/**
 * Class: MenuTest
 * Author: Steve Johnston
 * Created: 2/21/2017
 */

public class MenuTest {

	public static void main(String[] args) {

		//Entree Test
		Entree veggieBurger = new Entree("Veggie Burger", "A Gardein burger patty topped with loads of fresh veggies.", 225);
		Entree baconCheesburger = new Entree("Bacon Cheeseburger", "It has two meats so it's twice as good!", 450);

		//Appetizer test
		Appetizer friedPickles = new Appetizer("Fried Pickles", "Deep fried pickle medalions served with ranch dip.", 200);

		//Sides test
		Side seasonedFries = new Side("Seasoned Fries", "Signature homemade fries featuring 412 BBQ's Steel City Seasoning.", 250);
		Side coleslaw = new Side("Coleslaw", "Creamy coleslaw made from scratch.", 275); 

		//1 beer
		Beer whiteSky = new Beer("White Sky", "A chai wheat beer made by Brew Gentlemen in Braddock, PA.", 175);

		//2 menus 
		Menu menu1 = new Menu("Vegan Menu", veggieBurger, seasonedFries);
		Menu menu2 = new Menu("Belly Buster Menu", baconCheesburger, coleslaw, friedPickles, whiteSky);


		System.out.println("Menu Name: " + menu1.getName() + "\nTotal Calories: " + menu1.totalCalories() + "\nDescription:\n" + menu1.description());
		System.out.println("Menu Name: " + menu2.getName() + "\nTotal Calories: " + menu2.totalCalories() + "\nDescription:\n" + menu2.description());

	}

}
