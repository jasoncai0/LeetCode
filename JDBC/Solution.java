package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by zhensheng on 2016/5/16.
 */
public class Solution {

    protected static Logger log;
    protected static Connection connection;
    public void connectDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String  url = "jdbc:mysql://127.0.0.1:3306/xtrcontroller";
            String user = "root";
            String password = "wjcai376";
            connection  =  DriverManager.getConnection(url, user, password);
            if(!connection.isClosed())
                System.out.println("SUCCESS!");
        }catch(ClassNotFoundException e) {
            System.out.println("Sorry,cant't  find  the  Driver!!");

            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String []args){
        Solution s = new Solution();
        s.connectDatabase();

    }
}
