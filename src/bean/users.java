package bean;

import dao.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class users {
    private String username;
    private String password;
    private ResultSet res ;
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    public static class user_list {
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
}
