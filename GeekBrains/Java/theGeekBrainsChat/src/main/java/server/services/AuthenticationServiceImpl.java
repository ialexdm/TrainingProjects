package server.services;

import dataBase.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.handler.ClientHandler;
import server.interfaces.AuthenticationService;
import server.interfaces.Server;

import java.sql.SQLException;


public class AuthenticationServiceImpl implements AuthenticationService {
    public static final Logger LOGGER = LogManager.getLogger(AuthenticationServiceImpl.class);

    public void changeNick(String nick, String newNick) {
        try {
            userDAO.changeNick(nick, newNick);
        } catch (SQLException throwables) {
            LOGGER.error(throwables.getStackTrace());
        }
    }

    private UserDAO userDAO = new UserDAO();

    public void start() { LOGGER.info("AuthenticationService was started...");
    }

    public String getNick(String login, String password){
        try {
            return userDAO.getNickByLoginPassword(login, password);
        } catch (SQLException throwables) {
            LOGGER.error(throwables.getStackTrace());
        }
        return null;
    }

    public void stop() {
        LOGGER.info("AuthenticationService was stopped.");
    }
}
