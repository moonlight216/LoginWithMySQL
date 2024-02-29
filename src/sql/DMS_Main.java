package sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DMS_Main {
    public static void main(String[] args) throws SQLException {
        Connecting connecting = new Connecting("root","gyn020928","login","3306");
        Connection connection;
        try {
            connection = connecting.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        SQLS MySQLS = new SQLS(connection);
        Map<String, List<String>> tableInfo = MySQLS.getLogin_Table();

        //登录
        Scanner scanner = new Scanner(System.in);
        System.out.print("account_name:");
        String input_account = scanner.nextLine();
        System.out.print("password:");
        String input_password = scanner.nextLine();

        if(input_account!="" && input_password!=""){
            List<String> info = tableInfo.get(input_account);
            if(info!=null){
                if(input_password.equals(info.get(0))){
                    switch (info.get(1)){
                        case "admin" -> System.out.println("admin login");
                        case "student" -> System.out.println("student login");
                    }
                }else {
                    System.out.println("password wrong!");
                }
            }else{
                System.out.println("account does not exist!");
            }
        }else{
            System.out.println("account or password is null!");
        }
    }
}
