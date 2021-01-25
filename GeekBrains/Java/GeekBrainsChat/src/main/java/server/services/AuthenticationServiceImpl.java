package server.services;

import dataBase.UserDAO;
import server.interfaces.AuthenticationService;

import java.sql.SQLException;


public class AuthenticationServiceImpl implements AuthenticationService {

    UserDAO userDAO = new UserDAO();

    public void start() {
        System.out.println("AuthenticationService was started...");
    }

    public String getNick(String login, String password) throws SQLException {
        return userDAO.getNickByLoginPassword(login, password);
    }

    public void stop() {
        System.out.println("AuthenticationService was stopped.");
    }
}
