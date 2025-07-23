// designing a 'Library' (to be filled with 'Book's)

public class Library {
	private String address = "";		// initialized address string
	private static String hours = "Mon-Fri  8:00a-8:00p" + "\n\tSat  9:00a-6:00p";	// standardizedd hours
	private static int capacity = 20;	// maximum number of books these libraries can hold
	private int bookCount = 0;		// total number of books owned by library (borrowed or not)
	private int borrowCount = 0;		// number of books currently borrowed from library
	private Book[] books = new Book[capacity];		// initialized array to hold books (each added via method)
	private String[] borrbks = new String[capacity];	// initialized array to hold titles of borrowed books

	public Library (String addr) {
		// give blank values to array of borrowed titles
		for (int i=0; i<capacity; i++) {
			borrbks[i] = "";
		}
		// input address
		this.address = addr;
	}

	public void addBook (Book bk) {
		// add book to array
		this.books[bookCount] = bk;
		this.bookCount += 1; 
	}

	private boolean hasStr (String[] sarr, String str) {
		for (String s: sarr) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}

	public void borrowBook (String title) {
		// borrow a book
		boolean match = false;
		String t = "notitle";
		for (int i=0; i<this.bookCount; i++) {
			t = this.books[i].getTitle();
			//this.print("borrow; loop1: t = " + t + ", i = " + i);
			if (t.equals(title)) {
				match = true;
				if (hasStr(borrbks, t)) {
					this.print("The book '" + t + "' is unavailable for borrowing.\n");
					break;
				} 
				this.books[i].borrowed();
				this.borrowCount += 1;
				for (int j=0; j<this.borrowCount; j++) {
					//this.print("borrow; loop2: borrbks[j] = " + borrbks[j] + ", j = " + j);
					if (borrbks[j].equals("")) {
						//this.print("borrow; slot found: t = " + t + ", j = " + j);
						this.borrbks[j] = t;
						break;
					}
				}
				//this.print("'breaking...'");
				break;
			}
		}
		if (!match) {
			this.print("The book '" + title + "' is not held by this library.");
		}
	}

	public void returnBook (String title) {
		// return a book
		boolean match = false;
		for (int i=0; i<this.bookCount; i++) {
			String t = this.books[i].getTitle();
			if (t.equals(title)) {
				if (!hasStr(borrbks, t)) {
					this.print("The book '" + title + "' is not currently borrowed; it cannot be returned");
					return;
				}
				this.books[i].returned();
				for (int j=0; j<borrowCount; j++) {
					if (borrbks[j].equals(t)) {
						borrbks[j] = "";
						break;
					}
				}
				this.borrowCount -= 1;
			}
		}
	}

	private void print(String s) {
		// generic print for simplicity
		System.out.println("\n\t" + s);
	}

	public void printOpeningHours() {
		// print out hours
		this.print(this.hours);
	}

	public void printAddress() {
		// print out address
		this.print(this.address);
	}

	public void printAvailableBooks() {
		// print only the books available for checkout (not currently borrowed)
		String titles = "";
		if (this.bookCount == 0 || this.bookCount <= this.borrowCount) {
			this.print("There are no books at this library\n");
			return;
		}
		for (int i=0; i<this.bookCount; i++) {
			String t = this.books[i].getTitle();
			boolean borr = false;
			for (int j=0; j<this.borrowCount; j++) {
				if (borrbks[j].equals(t)) {
					borr = true;
					break;
				}
			}
			if (borr) {
				continue;
			} else {
			titles += t + "\n\t";
			}
		}
		this.print(titles);
	}
	
	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new Book("Of Mice and Men")); 
		firstLibrary.addBook(new Book("Life of Pi")); 
		firstLibrary.addBook(new Book("Forrest Gump")); 
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Add two books to the second library
		secondLibrary.addBook(new Book("Our Poisoned Earth and Sky"));
		secondLibrary.addBook(new Book("NM Rocks and Minerals"));

		// Print opening hours and the addresses
		System.out.println();
		System.out.println();
		System.out.println("Library hours:"); 
		firstLibrary.printOpeningHours(); 
		secondLibrary.printOpeningHours();
		System.out.println();
		System.out.println("Library addresses:"); 
		firstLibrary.printAddress(); 
		secondLibrary.printAddress(); 

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println();
		System.out.println("Borrowing The Lord of the Rings:"); 
		firstLibrary.borrowBook("The Lord of the Rings"); 
		System.out.println("again...");
		firstLibrary.borrowBook("The Lord of the Rings"); 
		System.out.println("second library...");
		secondLibrary.borrowBook("The Lord of the Rings"); 
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:"); 
		firstLibrary.printAvailableBooks();
		System.out.println("Books available in the second library:"); 
		secondLibrary.printAvailableBooks();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:"); 
		firstLibrary.returnBook("The Lord of the Rings"); 
		System.out.println();
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks(); 
	}
}
