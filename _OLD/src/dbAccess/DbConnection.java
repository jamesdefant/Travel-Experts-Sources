package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {

    public Connection createConnection()
    {
        Connection conn=null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties userInfo = new Properties();
            userInfo.put("user", "admin");
            userInfo.put("password", "password");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", userInfo);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}



