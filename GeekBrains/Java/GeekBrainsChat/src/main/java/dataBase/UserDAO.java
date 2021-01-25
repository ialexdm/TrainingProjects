package dataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    PreparedStatement ps = null;

    public void addUser(User user) throws SQLException {
        ps = DBConn.getInstance().connection().prepareStatement("INSERT INTO users (login, pass, nick) VALUES(?, ?, ?) ");
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getPass());
        ps.setString(3, user.getNick());
        ps.executeUpdate();

    }
    public User getUserByNick(String nick) throws SQLException {
        ps = DBConn.getInstance().connection().prepareStatement("SELECT * FROM users WHERE nick = ?");
        ps.setString(1, nick);
        ResultSet set = ps.executeQuery();
        User user = new User();
        if(set.next()){
            user.setLogin(set.getString("LOGIN"));
            user.setPass(set.getString("PASS"));
            user.setNick(set.getString("NICK"));
        }
        return user;

    }

    public void changeNick(String nick, String newNick) throws SQLException {
        ps = DBConn.getInstance().connection().prepareStatement("update users set NICK = ? where NICK = ?;");
        ps.setString(1, newNick);
        ps.setString(2, nick);
        ps.executeUpdate();
    }

    public String getNickByLoginPassword(String login,String password) throws SQLException {
        ps = DBConn.getInstance().connection().prepareStatement("SELECT * FROM users where login = ? and  pass = ?;");
        ps.setString(1, login);
        ps.setString(2, password);
        ResultSet set = ps.executeQuery();
        User user = new User();
        if(set.next()){
            user.setLogin(set.getString("LOGIN"));
            user.setPass(set.getString("PASS"));
            user.setNick(set.getString("NICK"));
        }
        return user.getNick();

    }

    public List<User> getAllUser() throws SQLException {
        List<User> userList = new ArrayList<>();
        ps = DBConn.getInstance().connection().prepareStatement("SELECT * FROM users");
        ResultSet set = ps.executeQuery();
        while (set.next()){
            User user = new User();
            user.setLogin(set.getString("LOGIN"));
            user.setPass(set.getString("PASS"));
            user.setNick(set.getString("NICK"));
            userList.add(user);
        }
        return userList;

    }
}
