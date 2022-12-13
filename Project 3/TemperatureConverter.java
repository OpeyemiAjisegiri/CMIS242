/**
 * Author: Opeyemi Ajisegiri
 * Class: CMIS 242, Intermediate Programming
 * Project: Assignment 3: GUI & Polymorphism
 * Date: April 25th, 2021
 * File: TemperatureConverter Class
 * Purpose: Inherits from the base class[Converter] and converts the temperature input
 * 			from Farenheit to Celsius.
 */
public class TemperatureConverter extends Converter{
	/*	Class Attributes[Parameters]	*/
	

	/*	Constructors	*/
	public TemperatureConverter() {
		super();
	}
	
	public TemperatureConverter(double Input) {
		super(Input);
	}
	
	/** Temperature Conversion from Farenheit to Celsius 
	 * 	Using the Formular: C = ((F-32)*5)/9	*/
	@Override
	public double Convert() {
		if(this.getInput() == Double.NaN)
			return Double.NaN;
		double Celsius = (((this.getInput() - 32) * 5) / 9);
		return Celsius;
	}
}