package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReturnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReturnServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            String student_id = request.getParameter("student_id");
            int stdId = Integer.parseInt(student_id);
            String book_id = request.getParameter("book_id");
            int bookId = Integer.parseInt(book_id);

            con = Database.getConnection();
            String sql = "DELETE FROM laibrary WHERE student_id = ? AND book_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, stdId);
            stmt.setInt(2, bookId);

            int affectedRow = stmt.executeUpdate();
            if (affectedRow > 0) {
                response.sendRedirect("aftreturn.jsp");
            } else {
                // Handle deletion failure, if needed
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace(); // Log the exception for debugging
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception for debugging
            }
        }
    }
}
