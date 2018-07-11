package br.ufla.dcc.gcc110.s2017_01.trabalho1.Grupo9;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Class Booklist
* Catalogs all existing books in a list
* @author Group 9 - Control and Automation Engineering 22A
* @author Alex Juno Bocoli
* @author Carla Freitas Amaral
* @author Marcelo Piazzarollo Teixeira
* @author Lucas Rezende Montrezor Silva
*/

public class Booklist {
	ArrayList<Book> bList; 
	Scanner reader;

	public Booklist(){
		bList = new ArrayList<Book>();
		reader = new Scanner(System.in);
	}
	
	/**
	* Add book method
	* @param name name of the book
	* @return true if the book can be added; false otherwise
	*/
	public boolean addBook(String name){
		if(bList.isEmpty()){
			Book b = new Book(name);
			bList.add(b);
			return true;
		}
		else{
			for(Book a:bList){
				if(a.getName().equalsIgnoreCase(name)){
					return false;
				}
			}
			Book b = new Book(name);
			bList.add(b);
			return true;
		}
	}
	
	/**
	* Search book method
	* @param name name of the book
	* @return b if the book existis; null otherwise
	*/
	public Book searchBook(String name){
		if(bList.isEmpty()) return null;
		else{
			for(Book b:bList){
				if(b.getName().equalsIgnoreCase(name)){
					return b;
				}
			}
			return null;
		}
	}
	
	/**
	* Search book name method
	* @param name name of the book
	* @return false if the book exists; true otherwise
	*/
	public boolean searchName(String name){
		if(bList.isEmpty()) return false;
		else{
			for(Book b:bList){
				if(b.getName().equalsIgnoreCase(name)){
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	* Remove book method
	* @param name name of the book
	* @return true if the book can be removed; false otherwise 
	*/
	public boolean removeBook(String name){
		if(bList.isEmpty()) return false;
		else{
			for(Book b:bList){
				if(b.getName().equalsIgnoreCase(name)){
					bList.remove(b);
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	* Show books method
	* @return string with every book
	*/
	public String showBooks(){
		String booknames = "";
		for(Book b:bList){
			booknames = booknames + bList.indexOf(b) + ": " + b.getName();
		}
		return booknames;
	}
	
	/**
	* Empty book list check method 
	* @return true if list is not empty; false otherwise
	*/
	public boolean notEmpty(){
		if(bList.isEmpty()) return false;
		else return true;
	}
	
	/**
	* Get book ID method
	* @param b an object of Book class
	* @return the book index
	*/
	public int getBookId(Book b){
		return bList.indexOf(b);
	}
	
	/**
	* Get book list size method
	* @return the size of the list
	*/
	public int getSize(){
		return bList.size();
	}
	
	/**
	* Get book name method
	* @param booksequence the book index
	* @return string with the book name
	*/
	public String getBookName(int booksequence){
		Book reference = bList.get(booksequence);
		return reference.getName();
	}
	
	/**
	* Get recipes from book method
	* @param booksequence the book index
	* @return string with every recipe from the book
	*/
	public String getBookString(int booksequence){
		Book reference = bList.get(booksequence);
		return reference.getAllRecipe();			
	}
}
