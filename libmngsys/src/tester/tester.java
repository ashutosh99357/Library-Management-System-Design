package tester;
import java.util.Date;
import java.util.List;

import Book.BookCopy;
import Book.BookDetails;
import User.Member;
import auth.UserAuthenticator;
import dataaccessor.DBAccessor;
import id.IDGenerator;
import lib.Library;
import searcher.AuthorBasedBookSearcher;
import searcher.BookSearcher;
import searcher.IdBasedBookSearcher;
import searcher.IdBasedMemberSearcher;
import searcher.MemberSearcher;
import searcher.NameBasedBookSearcher;
import searcher.NameBasedMemberSearcher;

public class tester {
	// Always validate parameters
	private final DBAccessor dbAccessor;
	public List<BookCopy> searchBooksByName(String bookName)
    {
      if(bookName == null)
    	  throw new IllegalArgumentException("Book Name can't be null");
       BookSearcher bookSearcher = new NameBasedBookSearcher(bookName);
       return  bookSearcher.search();
    }
    public List<BookCopy> searchBooksByAuthorName(List<String> authorNames)
    {
    	if(authorNames == null || authorNames.size() == 0)
      	  throw new IllegalArgumentException("author Name can't be null or empty");
         BookSearcher bookSearcher = new AuthorBasedBookSearcher(authorNames);
         return  bookSearcher.search();
    }
    public List<Member> searchMembersByName(String memberName, String adminToken) throws IllegalAccessException
    {
      //authentication check
    	if(!UserAuthenticator.isAdmin(adminToken)) {
    		throw new IllegalAccessException("Operation forbidden");
    		
    	}
    	MemberSearcher memberSearcher = new NameBasedMemberSearcher(memberName);
    	return memberSearcher.search();
    }
    public void addBook(String bookName, Date publicationDate, List<String> authors, String adminToken)
    {
    	if(!UserAuthenticator.isAdmin(adminToken)) {
    		throw new IllegalAccessException("Operation forbidden");	
    	}
    	BookCopy bookCopy = new BookCopy(new BookDetails(bookName, publicationDate, authors), IDGenerator.getUniqueId());
    	new Library(dbAccessor).addBookCopy(bookCopy);
    }
    public void deleteBook(int bookCopyId, String adminToken) throws IllegalAccessException
    {
    	if(!UserAuthenticator.isAdmin(adminToken)) {
    		throw new IllegalAccessException("Operation forbidden");
    	}
    	if(bookCopyId <= 0 || adminToken ==null || adminToken.length()==0)
    	{
    		throw new IllegalArgumentException("Forbidden");
    	}
    	BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
    	List<BookCopy> bookCopies = bookSearcher.search();
    	if(bookCopies == null || bookCopies.size()==0)
    	{
    		throw new RuntimeException("NO book of that is available");
    	}
    	new Library(dbAccessor).deleteBookCopy(bookCopies.get(0));
    }
    public void blockMember(int memberId, String adminToken) throws IllegalAccessException
    {
    	if(!UserAuthenticator.isAdmin(adminToken)) {
    		throw new IllegalAccessException("Operation forbidden");
    	}
    	if(memberId < 0 || adminToken ==null || adminToken.length()==0)
    	{
    		throw new IllegalArgumentException("Forbidden");
    	} 
    	MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
    	List<Member> members = memberSearcher.search();
    	if(members == null || members.size()==0)
    	{
    		throw new RuntimeException("NO member of that is available");
    	}
    	new Library(dbAccessor).blockMember(members.get(0));
    	
    }
    public void issueBook(int bookCopyId, int memberId,String adminToken) throws IllegalAccessException
    {
    	if(!UserAuthenticator.isAdmin(adminToken)) {
    		throw new IllegalAccessException("Operation forbidden");
    	}
    	if(bookCopyId < 0 || adminToken ==null || adminToken.length()==0)
    	{
    		throw new IllegalArgumentException("Forbidden");
    	}
    	BookSearcher bookSearcher= new IdBasedBookSearcher(bookCopyId);
    	List<BookCopy> bookCopies = bookSearcher.search();
    	if(bookCopies == null || bookCopies.size()==0)
    	{
    		throw new RuntimeException("NO book of that is available");
    	}
    	MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
    	List<Member> members = memberSearcher.search();
    	if(members == null || members.size()==0)
    	{
    		throw new RuntimeException("NO member of that is available");
    	}
    	new Library(dbAccessor).issueBook(bookCopies.get(0), members.get(0));
    }
    public void submitBook(int bookCpoyId, int memberId,String adminToken)
    {
    	if(!UserAuthenticator.isAdmin(adminToken)) {
    		throw new IllegalAccessException("Operation forbidden");
    	}
    	if(bookCopyId < 0 || adminToken ==null || adminToken.length()==0)
    	{
    		throw new IllegalArgumentException("Forbidden");
    	}
    	BookSearcher bookSearcher= new IdBasedBookSearcher(bookCopyId);
    	List<BookCopy> bookCopies = bookSearcher.search();
    	if(bookCopies == null || bookCopies.size()==0)
    	{
    		throw new RuntimeException("NO book of that is available");
    	}
    	MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
    	List<Member> members = memberSearcher.search();
    	if(members == null || members.size()==0)
    	{
    		throw new RuntimeException("NO member of that is available");
    	}
    	new Library(dbAccessor).submitBook(bookCopies.get(0), members.get(0));
    	
    }
  public Member getBorrowerOfBook(int bookCopyId, String adminToken) throws IllegalAccessException
  {
	  if(!UserAuthenticator.isAdmin(adminToken)) {
  		throw new IllegalAccessException("Operation forbidden");
  	}
  	if(bookCopyId < 0 || adminToken ==null || adminToken.length()==0)
  	{
  		throw new IllegalArgumentException("Forbidden");
  	}
  	BookSearcher bookSearcher= new IdBasedBookSearcher(bookCopyId);
  	List<BookCopy> bookCopies = bookSearcher.search();
  	if(bookCopies == null || bookCopies.size()==0)
  	{
  		throw new RuntimeException("NO book of that is available");
  	}
  	new Library(dbAccessor).getBorrower(bookCopies.get(0));
  }  
  public List<BookCopy> getBooksBorrowedByMember(int memberId, String adminToken) throws IllegalAccessException
  {
	  if(!UserAuthenticator.isAdmin(adminToken)) {
	  		throw new IllegalAccessException("Operation forbidden");
	  	}
	  MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
  	List<Member> members = memberSearcher.search();
  	if(members == null || members.size()==0)
  	{
  		throw new RuntimeException("NO member of that is available");
  	}
  	new Library(dbAccessor).getBorrowerBooks(members.get(0));
  	
  }
  // We can write here the main function to test our code we can use hasmap to store a bit of data in dbaccessor
}
