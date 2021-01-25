package dataBase;

public class DBConn {//Singleton

    private static DBConn instance;

    private DBConn(){

    }

    public static DBConn getInstance(){
        if (instance == null){
            instance = new DBConn();
        }
        return instance;
    }
}
