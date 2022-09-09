package searcher;

import java.util.List;

import Book.BookCopy;

public class IdBasedBookSearcher implements BookSearcher{

	private final int id;
	public IdBasedBookSearcher(int id)
	{
		this.id=id;
	}
	@Override
	public List<BookCopy> search() {
		// TODO Auto-generated method stub
		return null;
	}

}
