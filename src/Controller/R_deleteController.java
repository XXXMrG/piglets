package Controller;

import dao.DBconnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "R_deleteController")
public class R_deleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DBconnect dBconnect = new DBconnect();
        dBconnect.conn();
        String sql = "DELETE FROM Reservation WHERE R_ID = ' " + id + "'";
        Boolean is = dBconnect.execute(sql);
        System.out.println(is);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
