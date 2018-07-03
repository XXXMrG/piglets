package Controller;

import bean.Reservation;
import bean.ReservationList;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "ReservationController")
public class ReservationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ReservationList res = new ReservationList();
        res.setList();
        ArrayList list = res.getList();
        HttpSession session = request.getSession();
        Iterator <Reservation> it  = list.iterator();
        while (it.hasNext()){
            Reservation reservation = it.next();
            String iswalkin = "预约客户";
            System.out.println(reservation.getR_id());
            if (reservation.getR_id() == id){
                if (reservation.isR_isWalkin()){
                    iswalkin = "零散客户";
                }

                session.setAttribute("R_id", id);
                session.setAttribute("R_name", reservation.getR_name());
                session.setAttribute("R_tel", reservation.getR_tel());
                session.setAttribute("R_sum", reservation.getR_sum());
                session.setAttribute("R_date", reservation.getR_date());
                session.setAttribute("R_time_start", reservation.getR_time_start());
                session.setAttribute("R_time_end", reservation.getR_time_end());
                session.setAttribute("E_time_start", reservation.getE_time_start());
                session.setAttribute("E_time_end", reservation.getE_time_end());
                session.setAttribute("T_id", reservation.getT_id());
                session.setAttribute("R_pay", reservation.getR_pay());
                session.setAttribute("R_isWalkin", iswalkin);
                session.setAttribute("R_comment", reservation.getR_comment());


                break;
            }




        }
        response.sendRedirect("reservation_content.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
