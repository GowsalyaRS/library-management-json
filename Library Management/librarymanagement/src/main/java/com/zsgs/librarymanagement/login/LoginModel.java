package com.zsgs.librarymanagement.login;

public class LoginModel 
{
    private LoginView loginView;
	LoginModel(LoginView loginView) 
    {
		this.loginView = loginView;
	}
    public void validateCheck(String username, String password) 
    {
       
        if(username.equals("zsgs")) 
        {
            if(password.equals("1234"))
            {
               loginView.onSuccess();
            }
            else
            {
                loginView.alert("Passord Invalid!");
            }
        }
        else
        {
            loginView.alert("Username Invalid");
        }
    }
}
