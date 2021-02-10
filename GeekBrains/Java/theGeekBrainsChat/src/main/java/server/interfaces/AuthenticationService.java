package server.interfaces;

import java.sql.SQLException;

public interface AuthenticationService {
    void start();
    String getNick(String login, String password);
    void stop();
    public void changeNick(String nick, String newNick);

}
