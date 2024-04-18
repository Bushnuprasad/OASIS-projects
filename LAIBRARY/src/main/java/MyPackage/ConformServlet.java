package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConformServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ConformServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
           
            
                con = Database.getConnection();
                String sql = "UPDATE laibrary SET conform_issue = 'conform' WHERE book_id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(request.getParameter("book_id")));
                stmt.executeUpdate();
            
         
            response.sendRedirect(request.getHeader("referer"));
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace(); // Handle the exception properly, this is just for demonstration
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
