import java.util.Calendar; 

public class EBook extends Media{
	
	/*	Private Attribute  */
	private int numOfChapters;

	public EBook(int id, String title, int year, boolean rented, int chapters) {
		super(id, title, year, rented);
		this.numOfChapters = chapters;
	}
	
	/*	Getters and Setters	*/
	public int getNumOfChapters() { return this.numOfChapters; }
	
	public void setNumOfChapters(int chapters) { this.numOfChapters = chapters; }
	
	/*	Calculate rental fee, $0.10/Chapter and adding $1 if the book was published that year */
	@Override
	public double CalculateRentalFee() { 
		double rentalFee = this.numOfChapters * 0.10;  
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(this.getYear() == currentYear)
			rentalFee+= 1;  
		return rentalFee;
	}	
	
	/*	Display EBlectronic Book function	*/
	public String to_string() {
		return "The details of the Book is: [id: "+ this.getId() + ", title: "+ this.getTitle() + ", year: "+ getYear() +
			", has "+ this.numOfChapters + " chapters, Rental Fee: $" + this.CalculateRentalFee() + " ]";
	}
	

}
