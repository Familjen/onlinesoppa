package se.onlinesoppa.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:C:/Users/Morgan/databases/testDB;create=true";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		Statement statement = null;
		response.setContentType("text/json");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		
		printWriter.println("<head><title>swag</title></head>");
		printWriter.println("<body><table width = 30%><tr>");
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(JDBC_URL);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from app.posts");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
						
			
			for(int i=1; i <= resultSetMetaData.getColumnCount(); i++)
			{
				printWriter.println("<td>" + resultSetMetaData.getColumnName(i) + "</td>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		printWriter.println("</tr></table></body>");
		
		printWriter.println("</html>");
	}

}
