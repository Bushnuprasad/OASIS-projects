package MyPackage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            con = Database.getConnection();
            String student_name = request.getParameter("student_name");
            String student_id = request.getParameter("student_id");
            String password = request.getParameter("password");

            String sql = "SELECT student_name, student_id, password FROM student WHERE student_name = ? AND student_id = ? AND password = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, student_name);
            stmt.setString(2, student_id);
            stmt.setString(3, password);

            result = stmt.executeQuery();

            if (result.next()) {
                // Successful login
                response.sendRedirect("StudentHome.jsp");
            } else {
                // Invalid credentials
                response.sendRedirect("Signin.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (result != null) result.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception for debugging
            }
        }
    }
}
