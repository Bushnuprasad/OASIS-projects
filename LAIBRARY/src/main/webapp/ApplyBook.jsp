<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apply for book</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="hmee">
    <div class="hma">
        <form action="ApplyServlet" method="post">
            <!-- Add Book -->
            <input type="hidden" name="action" value="addBook">
            <input type="number" name="student_id" placeholder="Student Id">
            <input type="text" name="student_name" placeholder="Student name">
            <input type="text" name="branch" placeholder="Branch name">
            <input type="number" name="book_id" placeholder="book Id">
            <input type="date" name="date" placeholder="Date">
            <input type="submit" value="Apply ">
             <div class="bkh"><button><a href="StudentHome.jsp">Back</a></button></div>
        </form>
    </div>
   </div>
</body>
</html>