package Book;

public class BookCopy {

	// Instead of inheritance to get the book Details we are using composition
	private final BookDetails bookDetails;
	private final int id;
	
	public BookCopy(BookDetails bookDetails, int id)
	{
		this.bookDetails = bookDetails;
		this.id=id;
	}
}
