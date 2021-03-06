package Controllers;

import Exceptions.TooShortPasswordException;
import Exceptions.UserAlreadyInTheBaseException;
import Exceptions.UserNotExistInBaseException;
import Models.User;

import java.io.IOException;


public class UserControllers {

    public User userLogin(String login, String password) throws TooShortPasswordException, UserNotExistInBaseException, IOException {
        return UserList.getInstance().findUser(login, password);
    }

    public boolean userRegister(String login, String password) throws UserAlreadyInTheBaseException, TooShortPasswordException, IOException {
        if (UserList.getInstance().registerUser(login, password)) {
            return true;
        }
        return false;
    }
}







