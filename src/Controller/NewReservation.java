package Controller;

import dao.DBconnect;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewReservation extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        String R_id = null;
        String date = (String) session.getAttribute("date");
        String R_name = (String) session.getAttribute("R_name");
        String R_tel = (String) session.getAttribute("R_tel");
        String R_sum = (String) session.getAttribute("R_sum");
        String R_time_start = (String) session.getAttribute("R_time_start");
        String R_time_end = (String) session.getAttribute("R_time_end");
        String T_id = request.getParameter("table_id");
        String sql = null;
        System.out.println(T_id);
        ResultSet rs = null;
        DBconnect dBconnect = new DBconnect();
        dBconnect.conn();
        if (R_tel != null) {  //非wallin
            sql = "INSERT INTO reservation (R_date, R_name, R_tel, R_sum, R_time_start, R_time_end, " +
                    " T_id ) VALUES ('" + date + "','" + R_name + "','" + R_tel + "'," + R_sum + ",'" + R_time_start
                    + "','" + R_time_end + "','" + T_id + "')";
        }
        else {  //wallin顾客
            sql = "INSERT INTO reservation (R_date, R_name, R_sum, E_time_start, E_time_end, " +
                    " T_id, R_isWalkin, R_isOver) VALUES ('" + date + "','" + R_name + "'," + R_sum + ",'" + R_time_start
                    + "','" + R_time_end + "','" + T_id + "',1, 1)";
            // 直接占用餐桌
            String sql1 = "UPDATE tables SET run = 1 WHERE table_id = " + "'" + T_id + "'";
            dBconnect.executeUpdate(sql1);
        }
        System.out.println(sql);
        //获取得到的预约号
        dBconnect.executeUpdate(sql);
        sql = "select R_id from reservation where R_name = '" + R_name + "'";
        rs = dBconnect.executeQuery(sql);
        try {
            while (rs.next()) {
                R_id = rs.getString("R_id");
            }
            System.out.println(R_id);
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        //更新预约餐桌的已有预约数
        sql = "update tables set number = number + 1";
        dBconnect.executeUpdate(sql);
        session.setAttribute("R_id", R_id);
        session.setAttribute("T_id", T_id);
    }
}
