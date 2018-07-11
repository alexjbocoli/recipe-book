package br.ufla.dcc.gcc110.s2017_01.trabalho1.Grupo9;

/**
* Class Ingredient
* Manages the ingredients of the recipe
* @author Group 9 - Control and Automation Engineering 22A
* @author Alex Juno Bocoli
* @author Carla Freitas Amaral
* @author Marcelo Piazzarollo Teixeira
* @author Lucas Rezende Montrezor Silva
*/

public class Ingredient {
	/** Ingredient
	* @param ingredient name of the ingredient
	* @param container unit of measurement of the ingredient
	* @param amount amount of the ingredient
	*/
	private String ingredient;
	private String container;
	private float amount;
	
	public Ingredient(String ingredient, String container, float amount){
		this.ingredient = ingredient;
		this.container = container;
		this.amount = amount;
	}
	
	/**
	* Get ingredient method
	* @return ingredient name of the ingredient
	*/
	public String getIngredient(){
		return ingredient;
	}
	
	/**
	* Get unit of measurement method
	* @return container name of the unit
	*/
	public String getContainer(){
		return container;
	}
	
	/**
	* Get amount method
	* @return amount amount of the ingredient
	*/
	public float getAmount(){
		return amount;
	}
}
