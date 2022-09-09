package dataaccessor;
// This class will contain the SQL queries to manipulate the DB stored.
import java.util.List;

import Book.BookCopy;
import User.Member;

public class DBAccessor {

	public Results getBooksWithName(String bookName)
	{
		return null;
	}
	public Results getBooksWithAuthorName(List<String> authors)
	{
		return null;
	}
	public Results getMembersWithName(String memberName)
	{
		return null;
	}
	public void insertBookCopy(BookCopy bookCopy)
	{
		
	}
	public void deleteBookCopy(BookCopy bookCopy)
	{
		
	}
	public void markAsBlocked(Member member)
	{
		
	}
	public void issueBookCopyToMember(BookCopy bookCopy,Member member)
	{
		
	}
	public void submitBookCopyFromMember(BookCopy bookCopy,Member member)
	{
		
	}
	public boolean isCopyAvailable(BookCopy bookCopy)
	{
		return true;
	}
	public Results getBorrower(BookCopy bookCopy)
	{
		return null;
	}
	public Results getBorrowedBooks(Member member)
	{
		return null;
	}
}
