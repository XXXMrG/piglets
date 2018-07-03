package bean;

import dao.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * table表的数据模型
 */

public class Table {

    String table_id;
    int number;
    int places;
    int run;        //记录餐桌使用状态：0 未启用，1 已启用

    ArrayList<Table> Tables = new ArrayList<Table>();   //从数据库获得的餐桌集合


    public ArrayList getTables() {
        String sql = "SELECT * FROM `Tables`";
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
                Tables.add(Table);
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return Tables;
    }

    public String getTable_id() {
        return table_id;
    }

    public String setTable_id(String setTable_id) {
        this.table_id = setTable_id;
        return table_id;
    }

    public int getNumber() {
        return number;
    }

    public int setNumber(int number) {
        this.number = number;
        return number;
    }

    public int getPlaces() {
        return places;
    }

    public int setPlaces(int places) {
        this.places = places;
        return places;
    }

    public int getRun() {
        return run;
    }

    public int setRun(int run) {
        this.run = run;
        return run;
    }

    /*public static void main(String[] args) {
        Table Table = new Table();
        ArrayList<Table> Tables = new ArrayList<Table>();
        Tables = Table.getTables();
        java.util.Iterator iter = Tables.iterator();
        while (iter.hasNext()) {
            Table tableone = (Table) iter.next();
            System.out.print(" " + tableone.getTable_id());
        }
    }*/
}
