package com.zsgs.librarymanagement.librarysetup;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.managebook.ManageBookView;
import com.zsgs.librarymanagement.model.Library;
public class LibrarySetupModel 
{
    static
    {
        LibraryDatabase.getInstance().pullLibraryDataFromJSON();
    }
    private Library library = LibraryDatabase.getInstance().getLibrary();
    private LibrarySetupView librarySetupView;
    LibrarySetupModel(LibrarySetupView librarySetupView) 
	{
       
		this.librarySetupView = librarySetupView;
	}
    public void   setup() 
	{
        if (library.getName() == null ) 
        {
			librarySetupView.initiateSetup();
		} 
        else 
        {
            librarySetupView.showAlert("--------------------------WELCOME  " + library.getName() + " Library------------------------");
            System.out.println(library);
            System.out.println("-------------------------------------------------------------------------");
			new ManageBookView().initAdd();
		}
	}
    public void createLibrary(Library library2) 
    {
        if (library2.getName().length() <3  || library2.getName().length() > 50) 
		{
			librarySetupView.showAlert("Enter valid name");
			return;
		}
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(library2.getEmail());
        if(!matcher.matches())
        {
            librarySetupView.showAlert(" email is Invalid");
            return;
        }
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
        matcher = ptrn.matcher(""+library2.getPhoneNo());
        if(!matcher.matches())
        {
            librarySetupView.showAlert(" Phone no is Invalid");
            return;
        }
		this.library = LibraryDatabase.getInstance().insertLibrary(library2);
        LibraryDatabase.getInstance().pushLibraryDataToJSON();		
		librarySetupView.onSetupComplete(library2);
    }
}
