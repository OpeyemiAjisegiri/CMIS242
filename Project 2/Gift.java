import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Opeyemi Ajisegiri
 * Class:	CMIS 242
 * Project: Assignment 2
 * File: 	Gift Class
 */
public class Gift implements FruitBasket, SweetsBasket{ 
	protected int id;
	private int min = 4;
	private int max = 6;
	private String size; 
	protected double price;
	protected int numOfFruits; 
	private boolean citrus;
	private boolean nuts;
 
	/*	Constructor	*/
	Gift(){
		this.id = ThreadLocalRandom.current().nextInt(min, max + 1);
		//this.size = size; 
		this.price = 0.0;
	}
	
	Gift(String size){
		this.id = ThreadLocalRandom.current().nextInt(min, max + 1);
		this.size = size; 
		this.price = 0.0;
	}
		
	/*	Get and Set Functions	*/
	int getID() {return this.id;}
	String getSize() {return this.size;}
	double getPrice() {return this.price;}
	
	@Override
	public int getNumOfFruits() {
		return this.numOfFruits;
	}
	
	@Override
	public boolean hasNuts() {
		return this.nuts;
	}
	
	void setSize(String size) {this.size = size;}
	
	@Override
	public void addNuts(boolean nuts) {
		this.nuts = nuts;
	}

	@Override
	public boolean hasCitrus() {
		return this.citrus;
	}

	@Override
	public void setNumOfFruits(String size) {
		switch(size) {
		case "S":
			this.numOfFruits = 6;
			break;
		case "M":
			this.numOfFruits = 9;
			break;
		case "L":
			this.numOfFruits = 15;
			break;
		default:
			System.out.println("The size you entered is not offered. ");	
		}
	}

	@Override
	public void addCitrus(boolean citrus) {
		this.citrus = citrus;
		
	}
	
	double calculatePrice(String size) {
		switch(size){
		case "S": 
			this.price = 19.99;
			break;
		case "M":
			this.price = 29.99;
			break;
		case "L":
			this.price = 39.99;
			break;
		default:
		 System.out.println("The size you entered is not offered.");
		}
		if(this.citrus) {
			this.price += 5.99;
		}
		return this.price;
	}

	
	public void display() {
		System.out.println("Gift Basket Details");
		System.out.println("The id is: " + this.id);
		System.out.println("The size is: " + this.size);
		//System.out.println("The gift basket contains "+this.numOfFruits + " of fruits");
		if(this.citrus)
			System.out.println("The gift basket contains citrus fruits");
		else if(!this.citrus)
			System.out.println("The gift basket doesn't contain any citrus fruits");
		else if(this.nuts)
			System.out.println("The gift basket contains nut products");
		else
			System.out.println("The gift basket doesn't contain any nut products");
		System.out.println("\n\n");
	}
	
    public void change(String temp) {
    	this.setSize(temp);
    	this.display();
    }
  }

