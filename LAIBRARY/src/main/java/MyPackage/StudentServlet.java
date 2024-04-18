package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

//@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentServlet() {
        super();
        
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    Connection con = null;
	        PreparedStatement stmt = null;
	      
	        try
	        {
	        	con=Database.getConnection();
	        	    String  student_name = request.getParameter("student_name");
	                String student_id = request.getParameter("student_id");
	                int std_id=Integer.parseInt(student_id); 
	                String branch = request.getParameter("branch");
	                String password = request.getParameter("password");
	                String sql = "INSERT INTO student (student_name, student_id, branch,password) VALUES (?, ?, ?, ?)";
	                stmt=con.prepareStatement(sql);
	                stmt.setString(1, student_name);
	                stmt.setInt(2, std_id);
	                stmt.setString(3, branch);
	                stmt.setString(4, password);
	                
	                int affectedRow = stmt.executeUpdate();
	                System.out.println("connected ");
	                if (affectedRow > 0) {
	                    response.sendRedirect("Signin.jsp");
	                } else {
	                   
	                }
	        }
	        catch(Exception e)
	        {
	        	
	        }
	}

}
