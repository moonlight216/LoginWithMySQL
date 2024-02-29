package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLS {
    Connection connection;
    public SQLS(Connection connection){
        this.connection = connection;
    }

    public Map<String, List<String>> getLogin_Table() throws SQLException {
        Map<String, List<String>> tableInfo = new HashMap<>();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM login_table";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            String account_name = rs.getString("account_name");
            List<String> info = new ArrayList<>();
            info.add(rs.getString("password"));
            info.add(rs.getString("status"));
            tableInfo.put(account_name,info);
        }
        return tableInfo;
    }
}
