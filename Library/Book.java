// designing a 'Book' (to be placed in a 'Library')

public class Book { 
	String title = "";
	boolean borrowed = false;

	// Creates a new Book
	public Book(String bookTitle) {
		this.title = bookTitle;
	}
	// Marks the book as borrowed
	public void borrowed() { 
		System.out.println("\n" + this.getTitle() + " has been borrowed.\n");
		this.borrowed = true;
	}
	// Marks the book as not borrowed
	public void returned() {
		System.out.println("\n" + this.getTitle() + " has been returned.\n");
		this.borrowed = false;
	}
	// Returns true if the book is borrowed, false otherwise
	public boolean isBorrowed() { 
		return borrowed;
	}
	// Returns the title of the book
	public String getTitle() { 
		return title;
	}
  
	public static void main(String[] args) {
		// Small test of the Book class
		Book example = new Book("Of Mice and Men");
		System.out.println("\n\nTitle (should be 'Of Mice and Men'): " + example.getTitle()); 
		System.out.println("\nBorrowed? (should be false): " + example.isBorrowed()); 
		example.borrowed();
		System.out.println("Borrowed? (should be true): " + example.isBorrowed()); 
		example.returned();
		System.out.println("Borrowed? (should be false): " + example.isBorrowed() + "\n\n");
	} 
}
