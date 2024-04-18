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
        <div>
            <h2>Book List</h2>
            <table border="1">
                <tr>
                    <th>Student ID</th>
                    <th>Student name</th>
                    <th>Branch</th>
                    <th>Book Id</th>
                    <th>Date</th>
                    <th>Conform Issue</th>
                </tr>
                <% 
                try {
                    Connection con = null;
                    Statement stmt = null;
                    ResultSet rs = null;

                    con = Database.getConnection();
                    String sql = "SELECT * FROM laibrary";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(sql);

                    while (rs.next()) {
                %>
                        <tr>
                            <td><%= rs.getInt("student_id") %></td>
                            <td><%= rs.getString("student_name") %></td>
                            <td><%= rs.getString("branch") %></td>
                            <td><%= rs.getInt("book_id") %></td>
                            <td><%= rs.getString("date") %></td>
                            <td>
                                <form action="ConformServlet" method="post">
                                    <input type="hidden" name="book_id" value="<%= rs.getInt("book_id") %>">
                                    <button class="conform">Conform</button>
                                </form>
                            </td>
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
       
        <div class="bkh"><button><a href="home.jsp">Back</a></button></div>
    </div>
   
</body>
</html>
