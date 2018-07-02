/**
    执行注册控制及逻辑执行的Servlet
    最后修改于2018/6/27
    by keith
 */
package Controller;

import dao.DBconnect;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerCheck")


public class registerCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession();				//用于存储参数的session对象
        //int result = 0;
        DBconnect dBconnect = new DBconnect();

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("adminName");
        String password = request.getParameter("password");
        int priv = Integer.parseInt( request.getParameter("adminRole") );// get the select frame
        int asu_id = Integer.parseInt( request.getParameter("adminID"));// get the adminid
        dBconnect.conn();
        dBconnect.executeInsert(username, password, asu_id, priv);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
