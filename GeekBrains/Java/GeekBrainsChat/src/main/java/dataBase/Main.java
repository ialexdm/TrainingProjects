package dataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String ... args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        //userDAO.addUser(new User("login4", "pass4", "Nick4"));
        //System.out.println(userDAO.getUserByNick("Nick4"));
        System.out.println(userDAO.getAllUser());
    }
}

