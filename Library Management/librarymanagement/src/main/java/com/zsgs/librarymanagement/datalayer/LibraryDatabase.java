package com.zsgs.librarymanagement.datalayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.HistoryOfBooks;
import com.zsgs.librarymanagement.model.Library;
import com.zsgs.librarymanagement.model.User;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class LibraryDatabase 
{
    private static LibraryDatabase libraryDatabase;
	private Library library ;
	private Map<Integer,Book> bookList = new LinkedHashMap<>();
	private Map<String,User> userList = new LinkedHashMap<>();
	private Map<String,ArrayList<HistoryOfBooks>> historyList = new HashMap<>();
    private ObjectMapper mapper = new ObjectMapper();
	private LibraryDatabase() 
	{
	}
	public static LibraryDatabase getInstance() 
	{
		if (libraryDatabase == null) 
		{
			libraryDatabase = new LibraryDatabase();
		}
		return libraryDatabase;
	}
	public Library getLibrary() 
	{
		return library;
	}
    public Library insertLibrary(Library librarys) 
	{
        library = librarys;
		this.library.setId(10234);
		return library;
    }
	public void storeBook(Book book,int bookCount) 
	{
		int bookId = bookList.size()+1000;
		book.setId(bookId);
		bookList.put(book.getId(),book);
		for(int i=0;i<bookCount;i++)
		{
			Book book2 = new Book(book.getBookName(),book.getAuthorName(),book.getEdition(),book.getPublication(),book.getVolume());
			bookId = bookList.size()+1000;
			book2.setId(bookId);
			bookList.put(book2.getId(), book2);
		}
	}
	public Map<Integer,Book> book() 
	{
		return bookList;
	}
	public Map<String,User> viewUserList ()
	{
        return userList;
	}
	public void addUser(User user) 
	{
	    userList.put(user.getEmail(),user);
	}
    public  Map <String,ArrayList<HistoryOfBooks>> addHistory() 
	{
        return historyList;
    }
	private String booksFileName = "/home/gowsalya/Gowsalya/Library Management/librarymanagement/src/main/resources/bookss.txt"; 
	Path filePath = Path.of(booksFileName);
	public void pushBookDataToJSON() 
	{
		File file = new File(booksFileName);
		if (file.exists()) {
			try {
				String s = mapper.writeValueAsString(bookList);
				Files.writeString(filePath, s);
			} catch (Exception e ) {
				e.printStackTrace();
			}
		}
	}
	public void pullBookDataFromJSON() 
	{
		File url = new File(booksFileName);
		if (url.exists()) 
		{
			try 
			{
				bookList.putAll(mapper.readValue(url, new TypeReference<Map<Integer, Book>>(){}));
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.err.println("File not found: " + booksFileName);
		}
	}
	private String libraryFileName = "/home/gowsalya/Gowsalya/Library Management/librarymanagement/src/main/resources/Library.txt"; 
	Path filePath1 =Path.of(libraryFileName); 
	public void pushLibraryDataToJSON() 
	{
		File file = new File(libraryFileName);
		if (file.exists()) {
			try {
				String s = mapper.writeValueAsString(library);
				Files.writeString(filePath1, s);
			} catch (Exception e ) {
				e.printStackTrace();
			}
		}
		else 
		{
			System.err.println("File not found: " + libraryFileName);
		}
	}
	public void pullLibraryDataFromJSON() 
	{
		File url = new File(libraryFileName);
		if (url.exists()) 
		{
			try 
			{
				library = mapper.readValue(url, new TypeReference<Library>(){});
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.err.println("File not found: " + libraryFileName);
		}
	}
	private String userFileName = "/home/gowsalya/Gowsalya/Library Management/librarymanagement/src/main/resources/User.txt"; 
	private Path filePath2 =Path.of(userFileName); 

	public void pushUserDataToJSON() 
	{
		File file = new File(userFileName);
		if (file.exists()) 
		{
			try 
			{
				String s = mapper.writeValueAsString(userList);
				Files.writeString(filePath2, s);
			} 
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}
		else 
		{
			System.err.println("File not found: " + userFileName);
		}
	}
	public void pullUserDataFromJSON() 
	{
		File url = new File(userFileName);
		if (url.exists()) 
		{
			try 
			{
				userList = mapper.readValue(url, new TypeReference<Map<String,User>>(){});
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.err.println("File not found: " + userFileName);
		}
	}
	private String historyFileName = "/home/gowsalya/Gowsalya/Library Management/librarymanagement/src/main/resources/HistoryBook.txt"; 
	private Path filePath3 =Path.of(historyFileName); 
	public void pushHistoryDataToJSON() 
	{
		File file = new File(historyFileName);
		if (file.exists()) 
		{
			try 
			{
				String s = mapper.writeValueAsString(historyList);
				Files.writeString(filePath3, s);
			} 
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}
		else 
		{
			System.err.println("File not found: " + historyFileName);
		}
	}
	public void pullHistoryDataFromJSON() 
	{
		File url = new File(historyFileName);
		if (url.exists()) 
		{
			try 
			{
				historyList= mapper.readValue(url, new TypeReference<Map<String,ArrayList<HistoryOfBooks>>>(){});
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.err.println("File not found: " + historyFileName);
		}
	}
}
