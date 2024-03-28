package com.zsgs.librarymanagement.borrowhistory;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Scanner;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.Book;
import com.zsgs.librarymanagement.model.HistoryOfBooks;
import com.zsgs.librarymanagement.model.User;

public class BorrowerView 
{
    private BorrowerModel borrowerModel;
    static Scanner scan = new Scanner(System.in);
    public BorrowerView()
    {
        this.borrowerModel = new BorrowerModel(this);
    }
    public void borrowerMenu() 
    {
        while(true)
        {
            System.out.println("***************************************");
            System.out.println("1.Borrowing book \n2.Return Book \n3.Borrowing History \n4.Exit");
            System.out.println("***************************************");
            int num = scan.nextInt();
            switch (num) 
            {
                case 1:scan.nextLine(); borrowBook(); break;
                case 2:scan.nextLine();returnBook(); break;
                case 3: scan.nextLine();borrowerHistory();break;
                case 4: return;
                default:System.out.println("Enter the correct option");
            }
        }
    }
    public String enterEmail()
    {
        System.out.println("Enter the email");
        String email = scan.nextLine();
        return email;
    }
    public void borrowerHistory() 
    {
        String email = enterEmail();
        borrowerModel.getUserHistory(email); 
    }
    public void returnBook() 
    {
        String email = enterEmail();
        borrowerModel.getHistory(email);
    }
    public void borrowBook()  
    {
        String email = enterEmail();
        borrowerModel.getUser(email); 
    }
    public void showAlert(String alert)
    {
        System.out.println(alert);
    }
    public void getBook(User user) 
    {
        System.out.println("Enter book id 1000 above"); 
        int bookId = scan.nextInt();
        borrowerModel.validateBook(bookId,user); 
    }
    public void finalizeBook(Book book,User user)  
    {
        Date date = new Date();
        HistoryOfBooks history = new HistoryOfBooks(book,user,date);
        Map <String,ArrayList<HistoryOfBooks>> historyBook =  LibraryDatabase.getInstance().addHistory();
        borrowerModel.isValidBook(historyBook,history);
    }
    public void historyBooks(ArrayList<HistoryOfBooks> ls) 
    {
        for(int i=0;i<ls.size();i++) 
        {
           System.out.println(ls.get(i));
        }
    }
}
