
public abstract class Media {
	
	/*	Private Attributes	*/
	private final int id;
	private String title;
	private int year; 
	/*	Rented or Available	*/
	private boolean rented;

	/*	Constructor	*/
	public Media(int Id, String Title, int Year, boolean Rented) {
		this.id = Id; 
		this.title = Title; 
		this.year = Year;
		this.rented = Rented;
	}
	
    /*	Overloaded Constructor to parse objects*/
    public Media(String line) {
        id = Integer.parseInt(line.substring(line.indexOf("<id>") + 7, line.indexOf("</id>")));
        title = line.substring(line.indexOf("<title>") + 10, line.indexOf("</title>"));
        year = Integer.parseInt(line.substring(line.indexOf("<year>") + 16, line.indexOf("</year>")));
        rented = Boolean.parseBoolean(line.substring(line.indexOf("<title>") + 6, line.indexOf("</title>")));
        
    }
	
	/* Getters and Setters	*/
	public int getId() { return this.id; }
	public String getTitle() { return this.title; }
	public int getYear() { return this.year; }
	public boolean IsRented() { return this.rented; }
	
	/*	ID value can not be changed after creation 
	public void setID(int Id) { this.id = Id; }*/
	public void setTitle(String Title) { this.title = Title; }
	public void setYear(int Year) { this.year = Year; }
	public void rentMedia(boolean Rented) { this.rented = Rented; }
	
	/*	Calculating The Rental Fee assuming the basic rental fee = $3.50	*/
	public double CalculateRentalFee() {
		return 3.50;
	}
}
