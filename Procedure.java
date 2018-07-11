package br.ufla.dcc.gcc110.s2017_01.trabalho1.Grupo9;

/** 
* Class Procedure 
* Manages the procedures of a recipe
* @author Group 9 - Control and Automation Engineering 22A
* @author Alex Juno Bocoli
* @author Carla Freitas Amaral
* @author Marcelo Piazzarollo Teixeira
* @author Lucas Rezende Montrezor Silva
*/

public class Procedure {
	/** Procedure
	* @param procedure name of the procedure
	*/
	private String procedure;

	public Procedure(String procedure){
		this.procedure = procedure;
	}
	
	/**
	* Get procedure method
	* @return procedure procedure from a recipe
	*/
	public String getProcedure(){
		return procedure;
	}
}
