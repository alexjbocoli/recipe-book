package br.ufla.dcc.gcc110.s2017_01.trabalho1.Grupo9;
import java.util.ArrayList;
import java.util.Scanner;

/** 
*Class Book
*Manages a recipe book
* @author Group 9 - Control and Automation Engineering 22A
* @author Alex Juno Bocoli
* @author Carla Freitas Amaral
* @author Marcelo Piazzarollo Teixeira
* @author Lucas Rezende Montrezor Silva
*/

public class Book {
	/** 
	*@param name name of the book
	*/
	private String name;
	ArrayList<Recipe> rList;
	Scanner reader;
	
	public Book(String name){
		this.name = name;
		rList = new ArrayList<Recipe>();
		reader = new Scanner(System.in);
	}
	
	/** 
	*Add recipe method
	*@param name name of the recipe
	*@param cat category of the recipe
	*@return r an object of the Recipe class
	*/
	public Recipe addRecipe(String name, String cat){
		Recipe r = new Recipe(name,cat);
		rList.add(r);
		return r;
	}
	
	/** 
	*Search recipe method
	*@param  name name of the recipe
	*@return boolean true if a recipe with that name is found; false otherwise
	*/
	public boolean searchRecipe(String name){
		if(rList.isEmpty()) return true;
		else{
			for(Recipe r:rList){
				if(r.getName().equalsIgnoreCase(name)){
					return false;
				}
			}
			return true;
		}
	}
	
	/**Get recipe method
	*@param name name of the recipe
	*@return r an object of the Recipe class
	*/
	public Recipe getRecipe(String name){
		if(rList.isEmpty()) return null;
		else{
			for(Recipe r:rList){
				if(r.getName().equalsIgnoreCase(name)){
					return r;
				}
			}
			return null;
		}
	}
	
	/** 
	*Show recipes method
	*@return boolean false if recipe list is empty; true otherwise
	*/
	public boolean showRecipes(){
		if(rList.isEmpty()) return false;
		else return true;
	}
	
	/** 
	*Remove recipe method
	@param name name of the recipe
	@return boolean true if recipe can be removed; false otherwise
	*/
	public boolean removeRecipe(String name){
		if(rList.isEmpty()) return false;
		else{
			for(Recipe r:rList){
				if(r.getName().equalsIgnoreCase(name)){
					rList.remove(r);
					return true;
				}
			}
			return false;
		}
	}
	
	/** 
	*Get recipe ID method
	*@param r an object of the recipe class
	*@return the recipe index
	*/
	public int getRecipeId(Recipe r){
		return rList.indexOf(r);
	}
	
	/**
	*Set book name method
	*@param name name of the book
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	*Get book name method
	*@return name name of the book
	*/
	public String getName(){
		return name;
	}
	
	/**
	*Print recipes method
	*@return savedbook string with every recipe from a book
	*/
	public String getAllRecipe(){
		String savedbook = "";
		for(Recipe r:rList){
		savedbook = savedbook + r.writeRecipe() + "\n*----------*\n\n";
		}
		return savedbook;
	}
}
