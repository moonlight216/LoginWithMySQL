package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connecting {
    private static String user;
    private static String password;
    private static String db_name;
    private static String host;

    public Connecting(String user,String password,String db_name,String host) {
        Connecting.user = user;
        Connecting.password = password;
        Connecting.host = host;
        Connecting.db_name = db_name;
    }

    public Connection getConnection() throws ClassNotFoundException {
        Connection MyConnection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:"+host+"/"+db_name+"?useUnicode=true&characterEncoding=utf8&useSSL=true";
        try{
            MyConnection = DriverManager.getConnection(url,user,password);
            System.out.println("connect successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
        return MyConnection;
    }
}
