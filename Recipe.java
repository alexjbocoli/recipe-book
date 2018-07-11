package br.ufla.dcc.gcc110.s2017_01.trabalho1.Grupo9;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Class Recipe
* Manages a recipe
* @author Group 9 - Control and Automation Engineering 22A
* @author Alex Juno Bocoli
* @author Carla Freitas Amaral
* @author Marcelo Piazzarollo Teixeira
* @author Lucas Rezende Montrezor Silva
*/

public class Recipe {
	/** Recipe
	* @param name name of the recipe
	* @param category category of the recipe
	*/
	private String name;
	private String category;
	ArrayList<Ingredient> iList;
	ArrayList<Procedure> pList;
	Scanner reader;
	
	public Recipe(String name, String category){
		this.name = name;
		this.category = category;
		iList = new ArrayList<Ingredient>();
		pList = new ArrayList<Procedure>();
		reader = new Scanner(System.in);
	}
	
	/**
	* Add ingredient to recipe method
	* @param i name of the ingredient
	* @param c unit of measurement of the ingredient
	* @param a amount of the ingredient
	*/
	public void addIngredient(String i, String c, float a){
		Ingredient ing = new Ingredient(i,c,a);
		iList.add(ing);
	}
	
	/**
	* Add procedure to recipe method
	* @param p procedure explanation
	*/
	public void addProcedure(String p){
		Procedure pro = new Procedure(p);
		pList.add(pro);
	}
	
	/**
	* Remove ingredient from recipe method
	* @param ing ingredient index
	* @return boolean true if ingredient can be removed; false otherwise
	*/
	public boolean removeIngredient(String ing){
		if(iList.isEmpty()) return false;
		for(Ingredient i:iList){
			if(i.getIngredient().equals(ing)){
				iList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	* Remove procedure from recipe method
	* @param id procedure index
	* @return boolean true if procedure can be removed; false otherwise
	*/	
	public boolean removeProcedure(int id){
		if(pList.isEmpty()) return false;
		for(Procedure p:pList){
			if(pList.indexOf(p) == id){
				pList.remove(p);
				return true;
			}
		}
		return false;
	}
	
	/**
	* Show ingredients of recipe method
	* @return ingredients string with every ingredient from a recipe
	*/
	public String showIngredients(){
		String ingredients = "";
		for(Ingredient i:iList){
			ingredients = ingredients + iList.indexOf(i) + ": " + i.getAmount() + " " + i.getContainer() + " de " + i.getIngredient();
		}
		return ingredients;
	}
	
	/**
	* Show procedures of recipe method
	* @return procedures string with every procedure from a recipe
	*/
	public String showProcedures(){
		String procedures = "";
		for(Procedure p:pList){
			procedures = procedures + pList.indexOf(p) + ": " + p.getProcedure();
		}
		return procedures;
	}
	
	/**
	* Set recipe name method
	* @param name name of the recipe
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* Get recipe name method
	* @return name name of the recipe
	*/	
	public String getName(){
		return name;
	}
	
	/**
	* Set recipe category method
	* @param category category of the recipe
	*/
	public void setCategory(String category){
		this.category = category;
	}
	
	/**
	* Get recipe category method
	* @return category category of the recipe
	*/	
	public String getCategory(){
		return category;
	}
	
	/**
	* Method to write all recipes in a .txt file
	* @return savestring string with all recipes
	*/
	public String writeRecipe(){
		String savestring;
		savestring = "Nome da Receita: " + name + "\nCategoria: " + category + "\n\nIngrediente(s): \n\n";
		int counter = 1;
		for(Ingredient i:iList){ 
			savestring = savestring + counter + ": " + i.getAmount() + " " + i.getContainer() + " de " + i.getIngredient() + "\n";
			counter = counter + 1;
		}
		counter = 1;
		savestring = savestring + "\nProcedimento(s):\n\n";
		for(Procedure p:pList){
			savestring = savestring + counter + ": " + p.getProcedure() + "\n";
			counter = counter + 1;
		}
		return savestring;
	}
}
