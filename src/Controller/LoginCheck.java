package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Login;

/**
 * Servlet implementation class LoginCheck
 */

public class LoginCheck extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();				//用于存储参数的session对象
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("logname");  //获取用户名
        String password = request.getParameter("logpass");  //获取密码
        String message = null;
        Login login = new Login();
        message = login.check(username, password);
        if (message.equals("right2")) {
            response.sendRedirect("index.jsp");
        }
        else if (message.equals("right1")) {
            response.sendRedirect("index.jsp");
        }
        else if (message.equals("right0")) {
            response.sendRedirect("index.jsp");
        }
        else {
            session.setAttribute("message", message);
            response.sendRedirect("login.jsp");
        }

    }

}

