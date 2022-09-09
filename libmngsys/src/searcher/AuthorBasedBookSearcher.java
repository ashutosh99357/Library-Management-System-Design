package searcher;
import java.util.List;

import Book.BookCopy;
public class AuthorBasedBookSearcher implements BookSearcher{
private final List<String> authors; //input will be taken in this

public  AuthorBasedBookSearcher(List<String> authors)
{
	this.authors=authors;
}
@Override
	public List<BookCopy> search() {
		// TODO Auto-generated method stub
		return null;
	}
	



}
