package com.zsgs.librarymanagement.model;

public class Book 
{
   private int id;


    private static int count=1000;
    private String bookName;
   private String authorName;
   private String edition;
   private String publication;
   private int volume;  
   private boolean availability;
   public Book(){
   }
    public Book(String bookName, String authorName, String edition, String publication, int volume)
   {
    this.id = count++;
    this.bookName = bookName;
    this.authorName = authorName;
    this.edition = edition;
    this.publication = publication;
    this.volume = volume;
    availability = true;
   }
    public int getId() 
    {
      return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
    public String getPublication() {
        return publication;
    }
   
    public void setPublication(String publication) {
        this.publication = publication;
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public String toString()
    {
        return "Book Id     : " + id +
             "\nBook Name   : " + bookName +
             "\nAuthor Name : " + authorName +
             "\nEdition     : " + edition +
             "\nPublication : " + publication +
             "\nVolume      : " + volume +
             "\n------------------------------------------";
    }
}