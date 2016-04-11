package com.abstractfactory;

public interface PizzaIngredientFactory {

	Dough createDough();

	Sauce createSauce();

	Cheese createCheese();

	Veggies[] createVeggies();

	Clams createClam();
 
	Pepperoni createPepperoni();
	// TODO - add method signatures
 
}
