/**
 * Author: Opeyemi Ajisegiri
 * Class: CMIS 242, Intermediate Programming
 * Project: Assignment 3: GUI & Polymorphism
 * Date: April 25th, 2021
 * File: DistanceConverter Class
 * Purpose: Inherits from the base class[Converter] and converts the Distance input
 * 			from Miles to kilometers.
 */
public class DistanceConverter extends Converter{
	/*	Class Attributes[Parameters]	*/

	/*	Constructors	*/
	public DistanceConverter() { super(); }
	
	public DistanceConverter(double Input) { super(Input); }
	
	/** Distance Conversion from Miles to Kilometers 
	 * 	Using the Formular: KM = Miles * 1.609	*/
	@Override
	public double Convert() {
		if(this.getInput() == Double.NaN)
			return Double.NaN;
		double KiloMeters = (this.getInput() * 1.609);
		return KiloMeters;
	}
}
