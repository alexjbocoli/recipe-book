package br.ufla.dcc.gcc110.s2017_01.trabalho1.Grupo9;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
* Class BookArchive
* Saves the books and its recipes in a .txt file
* @author Group 9 - Control and Automation Engineering 22A
* @author Alex Juno Bocoli
* @author Carla Freitas Amaral
* @author Marcelo Piazzarollo Teixeira
* @author Lucas Rezende Montrezor Silva
*/

public class BookArchive {
	/**
	* @param bList variável que contém todos os dados que devem ser escritos e guardar última gravação feita 
	*/
	private Booklist bList;
	public BookArchive(Booklist bList){
		this.bList = bList;
	}
	
	/**
	* Set book list method
	* @param bList the book list to save
	*/
	public void setNewSave(Booklist bList){
		this.bList = bList;
	}
	
	/**
	* Get last saved method
	* @return bList Returns the last saved book list
	*/
	public Booklist getOldBooklist(){
		return bList;
	}
	
	/**
	* Book saving method
	* @param booksequence the book sequence code
	*/
	public void bookSave(int booksequence){
		/**
		* @param filename and file extension according to book name
		* @param file variable from FileWriter package to write
		*/
		String filename = bList.getBookName(booksequence) + ".txt";;
		FileWriter file;
		
		try{
			file = new FileWriter(new File(filename));
			file.write(bList.getBookName(booksequence) +"\n\n" + bList.getBookString(booksequence));
			file.close();
			} 
		catch (IOException e) {
			e.printStackTrace();
			} 
		catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	/**
	* Save books method
	*/
	public void bookSave(){
		for (int i = 0; i < bList.getSize(); i++){
			bookSave(i);
		}
	}
}
