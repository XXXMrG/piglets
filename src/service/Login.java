package service;
import dao.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    String message = null;

    public String check(String username, String password) {
        DBconnect dBconnect = new DBconnect();
        ResultSet result    = null;
        String sql = null;
        if(username.equals("") || password.equals("")) {		//处理输入为空的情况
            message = "用户名或者密码为空，请重新输入";
        }
        else {
            dBconnect.conn();           //加载数据库
            sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            result = dBconnect.executeQuery(sql);
            try {
                if (!result.next())
                    message = "用户名不存在或者密码错误，请重新输入";
                else if (result.getInt("priv") == 2)
                    message = "right2";
                else if (result.getInt("priv") == 1)
                    message = "right1";
                else
                    message = "right0";
                dBconnect.closeDate();
            }
            catch(SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
        return message;
    }
}
