package bean;

import dao.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableList {
    ArrayList list = new ArrayList();

    public ArrayList getList() {
        return list;
    }

    public void setList(String sql) {
        ResultSet rs = null;
        DBconnect con = new DBconnect();
        con.conn(); //连接数据库
        rs = con.executeQuery(sql);
        try {
            while (rs.next()) {
                Table Table = new Table();
                Table.setTable_id(rs.getString("table_id"));
                Table.setNumber(rs.getInt("number"));
                Table.setPlaces(rs.getInt("places"));
                Table.setRun(rs.getInt("run"));
                list.add(Table);
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
}
