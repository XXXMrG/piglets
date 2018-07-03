package bean;

import dao.DBconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationList {
    private ArrayList list = new ArrayList();
    private ArrayList table_r = new ArrayList();

    public void setList() {
        DBconnect dBconnect = new DBconnect();
        ResultSet resultSet;
        dBconnect.conn();
        String sql = "SELECT * FROM Reservation";
        resultSet = dBconnect.executeQuery(sql);
        try{
            while (resultSet.next()){
                setRes(resultSet, list);
            }
            dBconnect.closeDate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public ArrayList getList() {
        return list;
    }

    public void setTable_r(String Table_id) {
        DBconnect dBconnect = new DBconnect();
        ResultSet resultSet;
        dBconnect.conn();
        String sql = "SELECT * FROM Reservation where T_id ='" + Table_id + "'";
        System.out.print(sql);
        resultSet = dBconnect.executeQuery(sql);
        try{
            while (resultSet.next()){
                setRes(resultSet, table_r);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList getTable_r() {
        return table_r;
    }

    public void setRes(ResultSet resultSet, ArrayList list) {
        try {
            Reservation reservation = new Reservation();
            reservation.setR_id(resultSet.getInt("R_id"));
            reservation.setR_name(resultSet.getString("R_name"));
            reservation.setR_tel(resultSet.getString("R_tel"));
            reservation.setR_sum(resultSet.getInt("R_sum"));
            reservation.setR_date(resultSet.getString("R_date"));
            reservation.setR_time_start(resultSet.getString("R_time_start"));
            reservation.setR_time_end(resultSet.getString("R_time_end"));
            reservation.setE_time_start(resultSet.getString("E_time_start"));
            reservation.setE_time_end(resultSet.getString("E_time_end"));
            reservation.setT_id(resultSet.getString("T_id"));
            reservation.setR_pay(resultSet.getInt("R_pay"));
            reservation.setR_isWalkin(resultSet.getBoolean("R_isWalkin"));
            reservation.setR_comment(resultSet.getString("R_comment"));
            list.add(reservation);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
