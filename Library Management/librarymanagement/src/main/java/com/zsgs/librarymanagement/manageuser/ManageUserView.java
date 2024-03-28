package com.zsgs.librarymanagement.manageuser;

import java.util.Map;
import java.util.Scanner;

import com.zsgs.librarymanagement.borrowhistory.BorrowerView;
import com.zsgs.librarymanagement.model.User;

public class ManageUserView 
{
    private ManageUserModel manageUserModel;
    private static Scanner scan = new Scanner(System.in);
    public ManageUserView()
    {
       manageUserModel = new ManageUserModel(this);
    }
    public  void displayUsersMenu() 
    {
        while(true)
        {
            System.out.println("********************************************");
            System.out.println("1.Add user \n2.borrowing book  \n3.View User  \n4.Back");
            System.out.println("********************************************");
            int num = scan.nextInt();
            switch(num)
            {
                case 1: scan.nextLine(); getUserDetails();break;
                case 2: new BorrowerView().borrowerMenu(); break;
                case 3: viewUser(); break;
                case 4: return;
                default : System.out.println("Enter the correct option");
            }
        }
    }
    public void viewUser() 
    {
        Map <String,User> users=  manageUserModel.viewUsers();
        for(Map.Entry<String,User> data : users.entrySet())
        {
            System.out.println(data.getValue());
            System.out.println("--------------------------------");
        }
    }
    public void getUserDetails() 
    {
       System.out.println("Enter the username :");  
       String userName = scan.nextLine();
       System.out.println("Enter the email ");
       String email = scan.nextLine();
       System.out.println("Enter the address");
       String address = scan.nextLine();
       System.out.println("Enter the phone no");
       long phoneNo = scan.nextLong();
       User user = new User(userName,email,phoneNo,address);
       manageUserModel.validUser(user);
    }
    public  void showAlert(String alert) 
    {
        System.out.println(alert);
    }
}