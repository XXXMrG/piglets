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

@WebServlet(name = "Reservation_end")
public class Reservation_end extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("R_id"));
        String E_time_end = request.getParameter("E_time_end");
        int pay = Integer.parseInt(request.getParameter("R_pay"));
        int isover = 2;
        String tid = request.getParameter("tid");
        ReservationList res = new ReservationList();
        res.setList();
        ArrayList list = res.getList();
        int result = 0;
        Iterator<Reservation> it  = list.iterator();
        while(it.hasNext()){
            Reservation reservation = it.next();
            if (reservation.getR_id() == id){
                String sql = "UPDATE tables SET run = 0 WHERE table_id = " + "'" + tid + "'";
                DBconnect dBconnect = new DBconnect();
                dBconnect.conn();
                result = dBconnect.executeUpdate(sql);
                dBconnect.EndRes(E_time_end, id, isover, pay);
            }
        }
        System.out.println(tid);
        response.sendRedirect("/ReservationController?id=" + id + "&flag=" + 1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
