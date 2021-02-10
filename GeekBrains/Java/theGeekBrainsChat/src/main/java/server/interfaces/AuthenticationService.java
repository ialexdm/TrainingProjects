package server.interfaces;

import java.sql.SQLException;

public interface AuthenticationService {
    void start();
    String getNick(String login, String password) throws SQLException;
    void stop();
    public void changeNick(String nick, String newNick) throws SQLException;

}
