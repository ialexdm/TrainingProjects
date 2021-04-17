package notebook.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class UsersDAO {

    PreparedStatement preparedStatement = null;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("dbStructure");
    String table = resourceBundle.getString("table");
    String mail = resourceBundle.getString("mail");
    String pass = resourceBundle.getString("pass");
    String un = resourceBundle.getString("un");
    String loc = resourceBundle.getString("loc");
    String sex = resourceBundle.getString("sex");
    String insert = MessageFormat.format( "INSERT INTO {0} ({1}, {2}, {3}, {4}, {5}) VALUES(?,?,?,?,?)", table,mail,pass,un,loc,sex);
    String select = MessageFormat.format("SELECT * FROM {0} WHERE {1} = ? AND {2} = ?",table, mail, pass);

    public void addUser(User user) throws SQLException {

        preparedStatement = DBConn
                .getInstance()
                .connection()
                .prepareStatement(insert);
        preparedStatement.setString(1,user.getEmail());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getUsername());
        preparedStatement.setString(4,user.getCountry());
        preparedStatement.setBoolean(5,user.isGender());
        preparedStatement.executeUpdate();
    }

    public void authentication(User user) throws SQLException {
        preparedStatement = DBConn
                .getInstance()
                .connection()
                .prepareStatement(select);
        preparedStatement.setString(1,user.getEmail());
        preparedStatement.setString(2,user.getPassword());
        ResultSet result= preparedStatement.executeQuery();
        if (result.next()){
            user.setUsername(result.getString(un));
            user.setCountry(result.getString(loc));
            user.setGender(result.getBoolean(sex));
        }
    }

}
