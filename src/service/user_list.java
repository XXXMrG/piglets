package service;

import bean.users;
import dao.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class user_list {
    ArrayList list = new ArrayList();

    public void setList() {
        DBconnect dBconnect = new DBconnect();
        ResultSet resultSet;
        dBconnect.conn();
        String sql = "SELECT * FROM user";
        resultSet = dBconnect.executeQuery(sql);
        try {
            while (resultSet.next()){
                users user = new users();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public ArrayList getList() {
        return list;
    }
}
