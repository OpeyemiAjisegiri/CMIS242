
public class MovieDVD extends Media {
	
	/*	Private attribute: size in MB */
	private double size;

	/*	Constructor	*/
	public MovieDVD(int id, String title, int year, boolean rented, double Size ) {
		super(id, title, year, rented);
		this.size = Size;
	}
	
	/*	Overloaded Constructor to parse object	*/
    public MovieDVD(String line) {
        super(line);
        size = Double.parseDouble(line.substring(line.indexOf("<size>") + 16, line.indexOf("</size>")));              
    }
	
	/*	Getters and Setters	*/
	public double getSize() { return this.size; }
	
	public void setSize(double Size) { this.size = Size; }
	
	/*	Movie has a flat rate which is the same as the rental fee	*/
	public String to_string() {
		return "The details of the Movie DVD is: [id: "+ this.getId() + ", title: "+ this.getTitle() + ", year: "
				+ getYear() + ", movie size: "+ this.size + " MB, Rental Fee: $" + this.CalculateRentalFee() + " ]";
	}
}
