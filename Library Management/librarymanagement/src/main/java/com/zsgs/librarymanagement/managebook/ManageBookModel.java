package com.zsgs.librarymanagement.managebook;
import java.util.Map;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;

public class ManageBookModel 
{
    static
    {
        LibraryDatabase.getInstance().pullBookDataFromJSON();
    }
    private ManageBookView manageBookView;
	ManageBookModel(ManageBookView manageBookView)
    {
		this.manageBookView = manageBookView;
	}
    public void storeBook(Book book,int bookCount)
    {
        if (book.getBookName().length() <3  || book.getBookName().length() > 50) 
		{
			ManageBookView.showAlert("Enter valid name");
			return;
		}
        LibraryDatabase.getInstance().storeBook(book,bookCount);

        LibraryDatabase.getInstance().pushBookDataToJSON();
        ManageBookView.showAlert("Book added successfully"); 
    }
    public Map<Integer,Book> listOfBook() 
    {
        LibraryDatabase.getInstance().pullBookDataFromJSON();
        return LibraryDatabase.getInstance().book(); 
    }
    public Book checkBookValidate(int bookId) 
    {
        Book book = null;
        if(bookId<1000)
        {
            ManageBookView.showAlert("Book Id is Invalid"); 
        }
        Map<Integer,Book> bookList = listOfBook();
        book = bookList.get(bookId);
        return book;
    }
    public void isValidBook(Book books) 
    {
        if(books==null) 
        {
            manageBookView.showAlert("This Book is  Invalid");
        }
        else
        {
            manageBookView.showEditing(books);
        }
    }
}
