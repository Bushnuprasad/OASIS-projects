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
//@WebServlet("/libraryServlet")
public class LibraryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LibraryServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Database.getConnection(); // Get connection using Database class

            String action = request.getParameter("action");

        if ("addBook".equals(action)) 
            {
                // Handle add book functionality
                String bookId = request.getParameter("book_id");
                String title = request.getParameter("book_name");
                String author = request.getParameter("author_name");
                String price = request.getParameter("price");

                String sql = "INSERT INTO book (book_id, book_name, author_name, book_price) VALUES (?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, bookId);
                stmt.setString(2, title);
                stmt.setString(3, author);
                stmt.setString(4, price);
                int affectedRow = stmt.executeUpdate();
                System.out.println("connected ");
                if (affectedRow > 0) {
                    response.sendRedirect("home.jsp");
                } else {
                   
                }
            }
        else if ("deleteBook".equals(action)) 
            {
                String bookId = request.getParameter("book_id");
                String sql = "DELETE FROM book WHERE book_id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, bookId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("home.jsp");
                } else {
                    System.out.println("book deleted failed");
                }
            }
        else if ("logout".equals(action)) 
            {
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
            } 
        else 
            {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action parameter");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
