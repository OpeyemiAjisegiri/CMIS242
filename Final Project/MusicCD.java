import java.util.Calendar;

public class MusicCD extends Media {

	/* Private Attribute */
	private int length;
	
	/*	Constructor	*/
	public MusicCD(int id, String title, int year, boolean rented, int length) {
		super(id, title, year, rented);
		this.length = length;
	}
	
	/*	Overloaded Constructor to parse object	*/
    public MusicCD(String line) {
        super(line);
        length = Integer.parseInt(line.substring(line.indexOf("<length>") + 8, line.indexOf("</length>")));                
    }
	
	/*	Getters and Setters	*/
	public int getLength() { return this.length; }
	
	public void setLength(int length) { this.length = length; }
	
	/* Calculating Rental Fee; if the music was released in 
	 * the same year add $1 and 2 cents for each second of the song */
	@Override
	public double CalculateRentalFee() {
		double rentalFee = length* 0.02;  // basic fee
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(this.getYear() == currentYear) rentalFee+= 1;  
		return rentalFee;
	}
	

	/*	Display Music Media function	*/
	public String to_string() {
		return "The details of the Music CD is: [id: "+ this.getId() + ", title: "+ this.getTitle() +
			", year: "+ getYear() + ", music length: "+ this.length+ " minutes, Rental Fee: $" + this.CalculateRentalFee() + " ]";
	}
}
