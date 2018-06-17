

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/MyDerbyClientServlet")
public class MyDerbyClientServlet extends HttpServlet {
	
	@Resource(name="java:global/DerbyPool")
	DataSource ds;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection conn = ds.getConnection("APP", "APP");
			System.out.println("Got pooled connection to DerbyDB");
 
			String sqlQuery = "SELECT * from Employee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery); 
 
			//Process each column in the result set and print the data
			while (rs.next()){
				int empNo = rs.getInt("EMPNO");
				String eName = rs.getString("ENAME");
				String job = rs.getString("JOB_TITLE");
				System.out.println(""+ empNo + ", " + eName + ", " + job );
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}