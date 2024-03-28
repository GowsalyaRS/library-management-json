package com.zsgs.librarymanagement.librarysetup;

import java.util.Scanner;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.model.Library;

public class LibrarySetupView 
{
    static Scanner scan = new Scanner(System.in);
    private LibrarySetupModel librarySetupModel;
    private Library library ;
    public LibrarySetupView()
    {
       librarySetupModel = new LibrarySetupModel(this);
    }
    public void init() 
    {
        librarySetupModel.setup();
    }
	public void showAlert(String alert) {
		System.out.println(alert);
	}
	public void initiateSetup() 
	{
        System.out.println("Enter the Library name");
        String name = scan.nextLine();
        System.out.println("Enter the email");
        String email = scan.nextLine();
        System.out.println("Enter the phoneNo");
        Long phoneNo = scan.nextLong();
		scan.nextLine();
        System.out.println("Enter the address");
        String address = scan.nextLine();
		library = new Library(name, email, phoneNo, address);
        librarySetupModel.createLibrary(library);
	}
    public void onSetupComplete(Library library2) 
    {
        showAlert("Library details added successfully....!");
		new ManageBookView().initAdd();
    }
}
