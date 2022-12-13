/**
 * Author: Opeyemi Ajisegiri
 * Class: CMIS 242, Intermediate Programming
 * Project: Assignment 3: GUI & Polymorphism
 * Date: April 25th, 2021
 * File: Converter Class
 * Purpose: Base Class
 */

public class Converter {
	/*	Class Attributes[Parameters]	*/
	private double input;
	
	/*	Constructors	*/
	public Converter() { this.input = Double.NaN; }
	
	public Converter(double Input) { this.input = Input; }
	
	/*	Getters and Setters	*/
	public double getInput() { return this.input; }
	public void setInput(double Input) { this.input = Input; }
	
	
	/*	Primitive Conversion method	*/
	public double Convert() { return this.input; }
}