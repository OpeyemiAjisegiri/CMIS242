/*
 *Author:     Opeyemi Ajisegiri
 *Class:	  Intermediate programming, CMIS 242
 *Assignment: Assignment 1	
 *File:		  Book.java
 *Date: 	  March 30th, 2021
 *Purpose:	  The program sorts through a book inventory, adding, removing, finding and displaying
 *			  the inventory at the command of the program's user.
 *	*/

/*	Book class and attributes: id, title and price	*/
public class Book {
	private int id;
	private String title;
	private double price;
	
	/*	Constructor	*/
	public Book(int id, String title, double price){
		this.id = id;
		this.title = title; 
		this.price = price;
	}
	
	/*	GET Functions	*/
	public int getID() {
		return this.id;
	}
	
	public String getTITLE() {return this.title;}
	
	public double getPRICE() {return this.price;}

}