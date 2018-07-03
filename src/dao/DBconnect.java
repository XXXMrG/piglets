package dao;
import java.sql.*;

public class DBconnect {
    String drivername  = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/restaurantsystem?useSSL=false";
    Connection connect = null;
    ResultSet rs = null;
    Statement stmt = null;

    //加载数据库
    public void conn() {
        try {
            Class.forName(drivername);  //加载mysql的驱动程序
        }
        catch(java.lang.ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    //执行查询语句
    public ResultSet executeQuery(String sql) {
        try {
            connect = DriverManager.getConnection(url,"root","Ln/y&aF37vBnmdt4");
            stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs;
    }

    //执行更新语句
    public int executeUpdate(String sql) {
        int result = 0;
        try {
            connect = DriverManager.getConnection(url,"root","Ln/y&aF37vBnmdt4");
            stmt = connect.createStatement();
            result = stmt.executeUpdate(sql);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    //
    public int executeInsert(String username, String password, int asu_id, int priv){
        int result = 0;
        String sql = "INSERT INTO user VALUES (?, ?, ?, ?) ";
        PreparedStatement pstmt;
        try {
            connect = DriverManager.getConnection(url,"root","Ln/y&aF37vBnmdt4");
            pstmt = connect.prepareStatement(sql);
            pstmt.setInt(1,asu_id);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setInt(4, priv);
            result = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    //执行sql语句
    public boolean execute(String sql) {
        boolean result = false;
        try {
            connect = DriverManager.getConnection(url,"root","Ln/y&aF37vBnmdt4");
            stmt = connect.createStatement();
            result = stmt.execute(sql);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    //关闭资源
    public void closeDate() throws SQLException {
        rs.close();
        stmt.close();
        connect.close();
    }

    /*public static void main(String[] args) {
		DBconnect con = new DBconnect();
		con.executeQuery("select * from user");
		if(con.rs != null) {
			System.out.println("成功连接数据库！");
		}
	}*/

}
