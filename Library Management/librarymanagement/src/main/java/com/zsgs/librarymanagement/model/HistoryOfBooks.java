package com.zsgs.librarymanagement.model;

import java.util.Date;

public class HistoryOfBooks 
{
    private User  user;
    private Book book; 
    private Date borrowingDate;     
    private Date returnDate ;
    public HistoryOfBooks()
    {
        
    }  
    public HistoryOfBooks(Book book, User user, Date borrowingDate) 
    {
        this.book = book;
        this.user = user;
        this.borrowingDate = borrowingDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Date getBorrowingDate() {
        return borrowingDate;
    }
    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }  
    public String toString() 
    {
        return "user email     : " + user.getEmail()+
             "\nBook id        : " + book.getId()+
             "\nBorrowing Date : " + borrowingDate+
             "\nReturn Date    : " + returnDate;
    }
}
