package Controller;

import dao.DBconnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Reservation_edit")
public class Reservation_edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tel = request.getParameter("R_tel");
        int sum = Integer.parseInt(request.getParameter("R_sum"));
        String R_time_start = request.getParameter("R_time_start");
        String R_time_end = request.getParameter("R_time_end");
        String T_id = request.getParameter("T_id");
        String comment = request.getParameter("R_comment");
        DBconnect dBconnect = new DBconnect();
        dBconnect.conn();
        dBconnect.editRes(tel, sum, T_id, R_time_start, R_time_end, comment, id);


        response.sendRedirect("/ReservationController?id=" + id + "&flag=" + 1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
