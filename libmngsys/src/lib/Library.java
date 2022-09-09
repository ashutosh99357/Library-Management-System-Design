package lib;

import java.util.List;
import Book.BookCopy;
import User.Member;
import dataaccessor.DBAccessor;
import dataaccessor.Results;
import dataaccessor.ResultsConvertor;

public class Library {

	private final DBAccessor dbAccessor;
	public Library(DBAccessor dbAccessor)
	{
		this.dbAccessor=dbAccessor;
	}
	public void addBookCopy(BookCopy bookCopy)
	{
		if(bookCopy == null)
			 throw new IllegalArgumentException("Bookcopy can't be null");
        dbAccessor.insertBookCopy(bookCopy);
	}
	public void deleteBookCopy(BookCopy bookCopy)
	{
		if(dbAccessor.isCopyAvailable(bookCopy))
			dbAccessor.deleteBookCopy(bookCopy);
	}
	public void blockMember(Member member)
	{
		if(!dbAccessor.markAsBlocked(member))
			dbAccessor.markAsBlocked(member);
	}
	public void issueBook(BookCopy bookCopy, Member member)
	{
		if(dbAccessor.isCopyAvailable(bookCopy))
			dbAccessor.issueBookCopyToMember(bookCopy, member);
	}
	public void submitBook(BookCopy bookCopy, Member member)
	{
		//validation checks can be done in each function
		if(bookCopy != null)
			dbAccessor.submitBookCopyFromMember(bookCopy, member);
	}
	public Member getBorrower(BookCopy bookCopy)
	{
		if(bookCopy != null)
		{
			Results results = dbAccessor.getBorrower(bookCopy);
			return ResultsConvertor.convertToMember(results);
		}
	}
	public List<BookCopy> getBorrowerBooks(Member member)
	{
		if(member != null)
		{
		Results results = dbAccessor.getBorrowedBooks(member);
		return ResultsConvertor.convertToBookCopies(results);
		}
	}
}
