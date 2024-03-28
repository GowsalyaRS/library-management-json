package com.zsgs.librarymanagement.manageuser;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.zsgs.librarymanagement.datalayer.LibraryDatabase;
import com.zsgs.librarymanagement.model.User;

public class ManageUserModel
{
    private ManageUserView manageUserView;
    public ManageUserModel(ManageUserView manageUserView) 
	{
        this.manageUserView = manageUserView;
    }
	public void validUser(User user) 
	{
        if(user.getName().length()<3 || user.getName().length()>50)
        {
            manageUserView.showAlert("User name is Invalid");
            return;
        }
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(user.getEmail());
        if(!matcher.matches())
        {
            manageUserView.showAlert("User email is Invalid");
            return;
        }
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
        matcher = ptrn.matcher(""+user.getPhoneNo());
        if(!matcher.matches())
        {
            manageUserView.showAlert("User Phone no is Invalid");
            return;
        }
        validateCheckingUser(user);
	}
    public void validateCheckingUser(User user)
    {
        Map<String,User> userList = LibraryDatabase.getInstance().viewUserList();
        if(userList.get(user.getEmail())==null)
        {
            LibraryDatabase.getInstance().addUser(user);
            LibraryDatabase.getInstance().pushUserDataToJSON();
            manageUserView.showAlert("User Added Successfully"); 
        }
        else
        {
            manageUserView.showAlert("Already user in Library");  
        }
    }
    public Map<String,User>  viewUsers() 
    {
        return LibraryDatabase.getInstance().viewUserList();
    }
}
