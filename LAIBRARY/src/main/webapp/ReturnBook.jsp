<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return book</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="hmer">
    <div class="hma">
        <form action="ReturnServlet" method="post">
            <!-- Add Book -->
            <input type="hidden" name="action" value="addBook">
            <input type="number" name="student_id" placeholder="Student Id">
            <input type="number" name="book_id" placeholder="book Id">
            <input type="submit" value="Return Book">
             <div class="bkh"><button><a href="home.jsp">Back</a></button></div>
        </form>
    </div>
   </div>
</body>
</html>