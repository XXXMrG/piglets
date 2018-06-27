package service;

import dao.DBconnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register {

    public int update(String username, String password, int priv, int asu_id){
        DBconnect dBconnect = new DBconnect();
        int i = 0;
        dBconnect.conn();           //加载数据库
        i = dBconnect.executeInsert(username, password, asu_id, priv);


        return i;
    }
}
