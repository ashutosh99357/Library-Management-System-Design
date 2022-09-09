package Book;
import tester.tester;
import java.util.List;
import java.util.Date;

public class BookDetails {
	
private final String name;
private final Date publicationDate;
private final List<String> authors;

 public BookDeatils(String name, Date publicationDate, List<String> authors)
{
	this.name= name;
	this.publicationDate = publicationDate;
	this.authors  = authors;
}
}
