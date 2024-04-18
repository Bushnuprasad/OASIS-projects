package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ApplyServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String student_id = request.getParameter("student_id");
            int stdId = Integer.parseInt(student_id);
            String student_name = request.getParameter("student_name");
            String branch = request.getParameter("branch");
            String book_id = request.getParameter("book_id");
            int bookId = Integer.parseInt(book_id);
            String date = request.getParameter("date");

            con = Database.getConnection();
            
            // Check if the student has already applied for a book
            String query = "SELECT COUNT(*) AS count FROM laibrary WHERE student_id = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, stdId);
            rs = stmt.executeQuery();
            rs.next(); // Move the cursor to the first row
            int applicationCount = rs.getInt("count");

            if (applicationCount == 0) {
                String sql = "INSERT INTO laibrary (student_id, student_name, branch, book_id, date) VALUES (?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, stdId);
                stmt.setString(2, student_name);
                stmt.setString(3, branch);
                stmt.setInt(4, bookId);
                stmt.setString(5, date);
                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    response.sendRedirect("StudentHome.jsp");
                } else {
                    // Handle insertion failure
                }
            } else {
                // Student has already applied for a book
                response.sendRedirect("msg.html");
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception for debugging
            }
        }
    }
}
