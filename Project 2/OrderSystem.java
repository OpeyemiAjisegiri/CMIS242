import java.util.Scanner;

/**
 * @author: Opeyemi Ajisegiri
 * Class: 	CMIS 242
 * Project: Assignment 2
 * File: 	OrderSystem
 */
public class OrderSystem {

	public static void main(String[] args) {
		/*Author Details*/
		System.out.println("Name:    Opeyemi Ajisegiri");
		System.out.println("Class:   Intermediate Programming [CMIS 242]");
		System.out.println("Project: Assignment 2 ");
		System.out.println("TItle: 	 Hierachy and Encapsulation");
		System.out.println("\n\n\n");

		/*	Beginning Program User Prompt*/
		Scanner inPUT = new Scanner(System.in);
		int orderOption = 0;
		System.out.println("This is a gift basket ordering platform.");
		System.out.println("Please use the menu guide to order a gift "
				+ "basket entering the number before the option. \n\n");
		
		/*	Actions taken based on User Prompt	*/
        Gift basket = new Gift();	
		 while(orderOption != 9) {
		        switch(orderOption) {
		        case 1:
		        	System.out.println("Do you want Fruit Basket (1) or Sweets Basket (2):");
		        	int a = inPUT.nextInt();
			        System.out.println("What size do you want: S, M, or L:");
			        String size = inPUT.next();
			         basket.setSize(size); 
			        if(a == 1) {
			        	System.out.println("Do you want citrus fruits included? true/false:");
				        boolean fruit = inPUT.nextBoolean();
			        	basket.addCitrus(fruit);
			        }
			        else if(a == 2) {
			        	System.out.println("Do you want citrus fruits included? true/false:");
				        boolean nuts = inPUT.nextBoolean();
			        	basket.addNuts(nuts);
			        }
		        	System.out.println("Your order has been created");
		        	break;
		        case 2:
		        	System.out.println("Current gift size is: "+ basket.getSize());
		        	System.out.println("What size do you want? ");
		        	String tempS = inPUT.next();
		        	basket.change(tempS);
		        	break;
		        case 3:
		        	basket.display();
		        	break;
		        default:
		        }
		        /*	User Menu Prompt	*/
			System.out.println("\t Menu\t");
			System.out.println("1:	Order a Gift Basket\t");
			System.out.println("2:  Change Gift Basket \t");
			System.out.println("3:	Display Gift \t");
			System.out.println("9:	Exit Program \t");
			System.out.println("Enter your selection: ");
	        orderOption = inPUT.nextInt();
	        }
		 inPUT.close();
	    System.out.println("Thanks for using the program, Goodbye.");
	}
}

