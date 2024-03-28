package com.zsgs.librarymanagement;

import java.util.Scanner;

import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.login.LoginView;

public class App 
{
    static
    {
        LibraryDatabase.getInstance().pullUserDataFromJSON();
        LibraryDatabase.getInstance().pullHistoryDataFromJSON();
    }
    public static void main(String[] args) throws Exception 
    {
        System.out.println(" Welcome! " +   " \"Library Application\""); 
        Scanner scan = new Scanner(System.in);
        while(true)
        {
           System.out.println("*********************************");
           System.out.println("1.Admin  \n2.Exit"); 
           System.out.println("*********************************");
           int num = scan.nextInt();
           switch(num)
           {
               case 1: new LoginView().init(); break;
               case 2:  System.exit(0);
               default : System.out.println("Enter the correct option!");
           }
        }
        
    }
}
