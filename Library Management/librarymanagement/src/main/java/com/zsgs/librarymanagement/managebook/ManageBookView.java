package com.zsgs.librarymanagement.managebook;
import java.util.Map;
import java.util.Scanner;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.manageuser.ManageUserView;
import com.zsgs.librarymanagement.model.Book;

public class ManageBookView {

    private ManageBookModel manageBookModel;
    private Book book;
    static  Scanner scan = new Scanner(System.in);
	public ManageBookView() {
		manageBookModel = new ManageBookModel(this);
	}
    public void initAdd() 
    {
        while(true)
        {
            System.out.println("********************************************");
            System.out.println("1.Add book \n2.list of book \n3.Search book  \n4.Edit book  \n5.User Details \n6.Back ");
            System.out.println("********************************************");
            int choose = scan.nextInt();
            switch(choose)
            {
                case 1:addBook();break;
                case 2:viewBook();break;
                case 3:Book books =findBook(); System.out.println(books);break;  
                case 4:editBook();break;
                case 5:new ManageUserView().displayUsersMenu() ; break; 
                case 6:return;
                default : System.out.println("Enter the correct option");
            }
        } 
    }
    public void editBook() 
    {
        Book book = findBook();
        manageBookModel.isValidBook(book);
    }
    public Book findBook() 
    {
        System.out.println("Enter the book Id"); 
        int bookId = scan.nextInt();
        Book book =  manageBookModel.checkBookValidate(bookId);
        return book;
    }
    public void addBook() 
    {
        scan.nextLine();
        System.out.println("Enter the Book name :");
        String name = scan.nextLine();
        System.out.println("Enter the author name :");
        String authorName = scan.nextLine();
        System.out.println("Enter the edition : ");
        String edition = scan.nextLine();
        System.out.println("Enter the publication");
        String publication = scan.nextLine();
        System.out.println("Enter the volume");
        int volume = scan.nextInt();
        System.out.println("Enter the book count");
        int bookCount = scan.nextInt();
        book = new Book(name,authorName,edition,publication,volume);
        manageBookModel.storeBook(book,bookCount-1);
    }
    public static void showAlert(String alert) 
    {
        System.out.println(alert);
    }
    public void  viewBook()
    {
       Map<Integer,Book> books = manageBookModel.listOfBook();
       for(int i:books.keySet())
       {
            Book book = books.get(i);
            if(book.isAvailability())
            {
                System.out.println(book);
            }
       }
    }
    public void showEditing(Book books) 
    { 
        while(true) 
        {
            System.out.println("********************************************");
            System.out.println("1.Book name  \n2.Author Name  \n3.Publication \n4.Edition  \n5.Volume \n6.Back");
            System.out.println("********************************************");
            int num = scan.nextInt();
            scan.nextLine();
            switch (num) 
            {
               case 1: editBookName(books); break;
               case 2: editAuthorName(books);break;
               case 3: editPublication(books);break;
               case 4: editEdition(books);break;
               case 5: editVolume(books);break;
               case 6: return;
               default : System.out.println("Enter the correct option ");
            }   
        }   
    }
    public void editVolume(Book books) 
    {
        System.out.println("Enter the Volume Number ");
        int  volume= scan.nextInt();
        books.setVolume(volume);
        showAlert("Volume editing successfully"); 
        LibraryDatabase.getInstance().pushBookDataToJSON();   
    }
    public void editEdition(Book books) {
        System.out.println("Enter the Edition Name ");
        String edition= scan.nextLine();
        books.setEdition(edition);
        showAlert("Edition editing successfully"); 
        LibraryDatabase.getInstance().pushBookDataToJSON();    
    }
    public void editPublication(Book books) 
    {
        System.out.println("Enter the publication Name ");
        String publication = scan.nextLine();
        books.setPublication(publication);
        LibraryDatabase.getInstance().pushBookDataToJSON();  
        showAlert("Publication editing successfully");   
    }
    public void editAuthorName(Book books) 
    {
        System.out.println("Enter the Author Name ");
        String authourName = scan.nextLine();
        books.setAuthorName(authourName);
        LibraryDatabase.getInstance().pushBookDataToJSON();  
        showAlert("Author name editing successfully");  
    } 
    public void editBookName(Book books) 
    {
        System.out.println("Enter the Book Name ");
        String bookName = scan.nextLine();
        books.setBookName(bookName);
        LibraryDatabase.getInstance().pushBookDataToJSON();  
        showAlert("Book name editing successfully");
    }
}
