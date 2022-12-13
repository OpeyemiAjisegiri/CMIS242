import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    /*  Private Attributes  */
    private ArrayList<Media> medias;

    /*  Constructors  */
        /* Default Constructor creates an empty list of medias*/
	public Manager() {
		medias = new ArrayList<Media>();
	}
	
		/*	An overloaded constructor loads media from a file based on a pre-assumed naming convention	
		 *   and throws an exception if the file is not found */
    public Manager(String directory) throws FileNotFoundException {
        medias = new ArrayList<Media>();
        File directoryPath = new File(directory);
        File ListOfFiles[] = directoryPath.listFiles();   
       if (ListOfFiles == null)
            throw new FileNotFoundException("Could not load, no such directory");
        /* Declaring local variables  */ 
        Media media = null;
        String line = null;
        Scanner scan = null;       
        /*	Processing each Media file	*/ 
        for (File file : ListOfFiles) {
            if (file.getName().contains("MusicCD") || file.getName().contains("MovieDVD")) {
                scan = new Scanner(file);
                line = scan.nextLine();
                /* Parsing Media objects based on their type */
                if (file.getName().contains("MusicCD")) 
                    media = new MusicCD(line);    //Check the constructor   
                if (file.getName().contains("MovieDVD")) 
                    media = new MovieDVD(line);
                medias.add(media);
            }
        }
    }
    
    /*	creates/updates Media files for each media	*/
    public void createPetFiles(String directory) throws IOException {
        PrintWriter output = null;     
        for (int j = 0; j < medias.size(); j++) {
            String nameOfFile = directory + "/" + medias.get(j).getClass().getSimpleName() + "-" + medias.get(j).getId() + ".txt";
            output = new PrintWriter(new FileWriter(nameOfFile));  
            output.println(medias.get(j).toString());  
            output.flush();      
            output.close();    
        }
    }
    
    /*	Find all media objects for a specific title and returns that list	*/
    public ArrayList<Media> findMedia(String SpecificTitle) {
        ArrayList<Media> foundMedias =  new ArrayList<Media>();
        for(int j = 0; j < medias.size(); j++)
        	foundMedias.add(medias.get(j));
    	return foundMedias;
    }
    
    /*	Rent Media based on id (updates rental status 
     * 	on media, updates file, returns rental fee);
     *  rented is a boolean attribute */
    public double rentMedia(int id, String directory) throws IOException {
    	double rentalFee = 0;
    	PrintWriter output = null;   
    	for(int j = 0; j < medias.size(); j++) {
    		if(medias.get(j).getId() == id) {
    			medias.get(j).rentMedia(true);
    			String nameOfFile = directory + "/" + medias.get(j).getClass().getSimpleName() + "-" + medias.get(j).getId() + ".txt";
    			output = new PrintWriter(new FileWriter(nameOfFile));
                output.println(medias.get(j).toString());  
                output.flush();      
                output.close();    
    			rentalFee = medias.get(j).CalculateRentalFee();
    		}
    	}
		return rentalFee;
    }
    
    /*	Add new Media object to its Media list	*/
    public void addMedia(Media media) {
    	medias.add(media);
    }
}
