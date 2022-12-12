/**
 * @author: Opeyemi Ajisegiri
 * Class:	CMIS 242
 * Project: Assignment 2
 * File: 	FruitBasket Interface
 */
public interface FruitBasket {
	int getNumOfFruits();
	boolean hasCitrus();

	void setNumOfFruits(String size);
	void addCitrus(boolean citrus);
	
}
