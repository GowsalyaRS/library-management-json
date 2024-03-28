package com.zsgs.librarymanagement.login;

import java.util.Scanner;

import com.zsgs.librarymanagement.librarysetup.LibrarySetupView;

public class LoginView 
{
    private LoginModel loginModel;
	public LoginView() 
    {
		loginModel = new LoginModel(this);
	}
    static Scanner scan = new Scanner(System.in);
    public void init() 
    {
        System.out.println("Enter the username ");
        String username = scan.nextLine();
        System.out.println("Enter the password ");
        String password = scan.nextLine();
        loginModel.validateCheck(username,password);
    }
    public void onSuccess() 
    {
       System.out.println(" Successfully Login !");
       new LibrarySetupView().init();
    }
    public void alert(String str) 
    {
       System.out.println(str);
    }
}
