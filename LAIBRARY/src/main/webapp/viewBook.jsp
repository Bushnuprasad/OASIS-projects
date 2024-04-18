<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet" %>
<%@ page import="MyPackage.Database" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Books</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="tbl">
        <h2>Book List</h2>
        <button><a href="StudentHome.jsp">Back</a></button>
        <table border="1">
            <tr>
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Author Name</th>
                <th>Book Price</th>
            </tr>
            <% 
            try {
                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;

                con = Database.getConnection();
                String sql = "SELECT book_id, book_name, author_name, book_price FROM book";
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
            %>
                    <tr>
                        <td><%= rs.getInt("book_id") %></td>
                        <td><%= rs.getString("book_name") %></td>
                        <td><%= rs.getString("author_name") %></td>
                        <td><%= rs.getString("book_price") %></td>
                    </tr>
            <% 
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace(); // or handle the exception as needed
            }
            %>
        </table>
    </div>
</body>
</html>
