package Controller;

import bean.Reservation;
import bean.ReservationList;
import dao.DBconnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "Reservation_over")
public class Reservation_over extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("R_id"));
        String E_time_start = request.getParameter("E_time_start");
        int isover = 1;
        String tid = request.getParameter("tid");
        ReservationList res = new ReservationList();
        res.setList();
        ArrayList list = res.getList();
        int result = 0;
        Iterator<Reservation> it  = list.iterator();
        while(it.hasNext()){
            Reservation reservation = it.next();
            if (reservation.getR_id() == id){
                String sql = "UPDATE tables SET run = 1 WHERE table_id = " + "'" + tid + "'";
                DBconnect dBconnect = new DBconnect();
                dBconnect.conn();
                result = dBconnect.executeUpdate(sql);
                dBconnect.UpdateRes(E_time_start, id, isover);
            }
        }
        System.out.println(result);
        response.sendRedirect("/ReservationController?id=" + id + "&flag=" + 1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
