import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaRentalSystem {

	public MediaRentalSystem() {
		// TODO Auto-generated constructor stub
	}
	
	public static void menuDisplay() {
		
		System.out.println("Welcome to Media Rental System");
		System.out.println("1: Load Media object");
		System.out.println("2: Find Media objects");
		System.out.println("3: Rent Media Objects.. ");
		System.out.println("9: Quit ");
		System.out.println("Enter your selection: \t");
	}

	public static void main(String[] args) {
		Manager mgt = new Manager();

		Scanner input = new Scanner(System.in);
		int menuOption; 
		String directory, mediaTitle;
		menuDisplay();
		menuOption = input.nextInt();
		while(menuOption != 0 ) {
			switch(menuOption) {
				case 1:
					System.out.println("Enter path (directory) where to load from: C:");
					directory = input.next();
					try {
						Manager newMgt = new Manager(directory);
						mgt.createPetFiles(directory);
					}catch(IOException e) {
						System.out.println("File cannot be opened: Could not load, no such directory.");
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println(" \nEnter a title for the media: \t");
					mediaTitle = input.nextLine();
					ArrayList<Media> found = mgt.findMedia(mediaTitle);
					if(found.size() == 0)
						System.out.println("There are no media files with this title: " + mediaTitle);
					for(int i = 0; i < found.size(); i++) {
						found.get(i).toString();
					}
					break;
				case 3:
					System.out.println("Enter the media id");
					int mediaID = input.nextInt();
					System.out.println("Enter path (directory) where to load from: C:");
					directory = input.next(); //.nextLine();
					try {
						mgt.rentMedia(mediaID, directory);
					} catch (IOException e) {
						System.out.println("The media not found");
						e.printStackTrace();
					}
					break;
				case 9:
					System.out.println("Thanks for using the application");
					System.exit(0);
					break;
				default:
			}
			menuDisplay();
			menuOption = input.nextInt();
		}
	}

}