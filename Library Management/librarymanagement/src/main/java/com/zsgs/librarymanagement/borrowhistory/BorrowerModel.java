package com.zsgs.librarymanagement.borrowhistory;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.HistoryOfBooks;
import com.zsgs.librarymanagement.model.User;

public class BorrowerModel 
{
    private BorrowerView borrowerView ;
    public BorrowerModel(BorrowerView borrowerView) 
    {
         this.borrowerView = borrowerView;
    }
    public void getUser(String email)  
    {
        Map<String,User> userView = LibraryDatabase.getInstance().viewUserList(); 
        if( userView.get(email)!=null)
        {
           borrowerView.getBook(userView.get(email));
        }
        else
        {
           borrowerView.showAlert("user email invalid!");
        }
    }
    public void validateBook(int bookId,User user) 
    {
        Map<Integer,Book> books = LibraryDatabase.getInstance().book();
        if(books.get(bookId)!=null)
        {
           borrowerView.finalizeBook(books.get(bookId),user);
           borrowerView.showAlert("Book borrowing is successful!");
        }
        else 
        {
           borrowerView.showAlert("book id is invalid!");
        }
    }
    public void isValidBook(Map<String, ArrayList<HistoryOfBooks>> historyBook, HistoryOfBooks history) 
    {
        ArrayList <HistoryOfBooks> al = new ArrayList<>();
        String email =  history.getUser().getEmail();
        if( historyBook.get(history.getUser().getEmail())==null)
        {
            al.add(history);
            historyBook.put(email,al);
        }
        else
        {
            ArrayList<HistoryOfBooks> ls =  historyBook.get(email);
            ls.add(history); 
        }
        LibraryDatabase.getInstance().pushHistoryDataToJSON();
    }
    public void getHistory(String email) 
    {
        Map<String, ArrayList<HistoryOfBooks>>  history = LibraryDatabase.getInstance().addHistory();
        if(history.get(email)!=null)
        {
            ArrayList<HistoryOfBooks> ls = history.get(email);
            findBook(ls);
        }
        else
        {
            borrowerView.showAlert(".....This email id is not valid.....");
        }
    }
    public void findBook(ArrayList<HistoryOfBooks> ls) 
    {
        System.out.println("Enter the book id");
        int bookId = new Scanner(System.in).nextInt();
        for(int i=0;i<ls.size();i++)
        {
            int bookIds= ls.get(i).getBook().getId();
            if(bookId==bookIds && ls.get(i).getReturnDate()==null )
            {
                ls.get(i).setReturnDate(new Date());
                borrowerView.showAlert("Return book successfully !");
                return;
            }
        }
        borrowerView.showAlert("Your book is not bending !");
    }
    
    public void getUserHistory(String email) 
    {
        Map<String, ArrayList<HistoryOfBooks>>  history = LibraryDatabase.getInstance().addHistory();
        if(history.get(email)!=null)
        {
            ArrayList<HistoryOfBooks> ls = history.get(email);
            if(ls!=null)
            {
               borrowerView.historyBooks(ls);
            }
            else
            {
                borrowerView.showAlert(".....This user not get any book ....");
            }
        }
        else
        {
            borrowerView.showAlert(".....This email id is not valid.....");
        }
    }
}
