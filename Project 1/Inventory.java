/*
 *Author:     Opeyemi Ajisegiri
 *Class:	  Intermediate programming, CMIS 242
 *Assignment: Assignment 1	
 *File:		  Inventory.java
 *Date: 	  March 30th, 2021
 *Purpose:	  The program sorts through a book inventory, adding, removing, finding and displaying
 *			  the inventory at the command of the program's user.
 *	*/

import java.util.*;

/*	Inventory Class and attribute: inventoryList	*/
public class Inventory {
	private List<Book> inventoryList = new ArrayList<Book>();
	
	/*  Add Function: Prompts user for book data. If the book already exists (based on id value),
	 *  the add request fails and an error message is be printed to the console		*/
	public void Add() {
		System.out.println("Please enter the details of the book you want to add.");
        Scanner strinput = new Scanner(System.in);
		System.out.println("What is the book id(integer value)?\t");
		int newID = strinput.nextInt();
		strinput = new Scanner(System.in);
		System.out.println("What is the title of the book?\t");
		String newTITLE = strinput.nextLine();
		System.out.println("What is the price of the book(double value)?\t");
		double newPRICE = strinput.nextDouble();
		Book temp = new Book(newID,newTITLE,newPRICE);
		for(int i = 0; i <inventoryList.size(); i++) {
			if(inventoryList.get(i).getID() == temp.getID()) {
				System.out.println("The inventory already contains book you are trying to add.");
				return;
			}
		}
		inventoryList.add(temp);
		System.out.println("The book (Book id: "+ temp.getID()+", Book title: "+temp.getTITLE()+ ", ook price: "+ temp.getPRICE()+") has been added to the inventory.\n");

	}
	
	/* Remove Function:	Prompts user for book id, then finds the id in the inventory list and removes 
	 * it. If the book isn't found in the inventory, the remove request fails and an error message is 
	 * printed to the console	*/
	public void Remove() {
		System.out.println("Please enter the id of the book you are trying to delete");
        Scanner strinput = new Scanner(System.in);
        int nID = strinput.nextInt();
        if(inventoryList.isEmpty()) {
        	System.out.println("The inventory is empty");
        }
        else {
			for(Book list:inventoryList) {
				if( list.getID() == nID) {
					inventoryList.remove(list);
					System.out.println("The book, (Book id: "+ list.getID()+", Book title: "+ list.getTITLE() +") has been deleted.");
					break;
				}
				else {
					System.out.println("The book you are trying to delete is not in the inventory");
					break;
				}
			}
        }
	}
	
	/* Find Function:	Prompts user for book id, and finds the id in the inventory list, print all the
	 * book data (id, title, and price). If the book matching the id is not in the inventory, find 
	 * request fails and an error message is be printed to the console	 */
	public void Find() {
		System.out.println("Please enter the id of the book you are looking for");
        Scanner strinput = new Scanner(System.in);
        int nID = strinput.nextInt();
        if(inventoryList.isEmpty()) {
        	System.out.println("The inventory is empty.");
        }
        else {
			for(Book list:inventoryList) {
				if( list.getID() == nID) {
					System.out.println("The deatils of the book is: ");
					System.out.println("\t Book id: " + list.getID());
					System.out.println("\t Book title: " + list.getTITLE());
					System.out.println("\t Book price: " + list.getPRICE() + "\n");
					break;
				}
				else {
					System.out.println("The book you are looking for is not in the inventory.\n");
					break;
				}
			}
        }
	}
	
	/*	Display Function: Print all the book information for each book to the console	*/
	public void display() {
		if(inventoryList.isEmpty()) {
			System.out.println("The inventory has no books.");
		}
		else {
			System.out.println("\nBelow is the list of books in the inventory.");
			for(int i = 0; i < inventoryList.size(); i++){
				System.out.println("The deatils of the book is: ");
				System.out.println("\t Book id: " + inventoryList.get(i).getID());
				System.out.println("\t Book title: " + inventoryList.get(i).getTITLE());
				System.out.println("\t Book price: " + inventoryList.get(i).getPRICE() + "\n");
			}
		}
	}

	/*	Main Function	*/
	public static void main(String[] args) {
		/*	Author and Class Details	*/
		System.out.println("Author: Opeyemi Ajisegiri");
		System.out.println("Date: March 30th, 2021");
		System.out.println("Class: Intermediate Programming, CMIS 242\n");
		
		/*	Main Program	*/
		int MenuInput = 0; 
		Inventory newList = new Inventory();
			/*	Input options	*/
		System.out.println("Please choice an option from the options below using the preceding integers.\n"); 
		System.out.println("1: Add book"); 
		System.out.println("2: Remove book"); 
		System.out.println("3: Find book"); 
		System.out.println("4: Display all books"); 
		System.out.println("9: Exit program\n"); 
			/*	Input	*/
        Scanner strinput = new Scanner(System.in);
        MenuInput = strinput.nextInt();
        	/*	Accessing Inventory Class based on inputed option	*/
        while(MenuInput != 9) {
	        switch(MenuInput) {
	        case 1:
	        	newList.Add();
	        	break;
	        case 2:
	        	newList.Remove();
	        	break;
	        case 3:
	        	newList.Find();
	        	break;
	        case 4:
	        	newList.display();
	        	break;
	        case 9:  /*	Case 9 is a bit redundant due to the while loop*/
	        	System.out.println("Thanks for using the program, Goodbye.");
	        	break;
	        default:
	        	System.out.println("Please enter a menu option.");
	        }
			System.out.println("Please choice an option from the options below using the preceding integers.\n"); 
			System.out.println("1: Add book"); 
			System.out.println("2: Remove book"); 
			System.out.println("3: Find book"); 
			System.out.println("4: Display all books"); 
			System.out.println("9: Exit program\n"); 
	        MenuInput = strinput.nextInt();
	        }
	    	System.out.println("Thanks for using the program, Goodbye.");
	}

}
