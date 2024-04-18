<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="hme">
    <div class="hma">
        <form action="LibraryServlet" method="post">
            <input type="hidden" name="action" value="addBook">
            <input type="number" name="book_id" placeholder="Book Id">
            <input type="text" name="book_name" placeholder="Book name">
            <input type="text" name="author_name" placeholder="Author name">
            <input type="number" name="price" placeholder="book price">
            <input type="submit" value="Add Book">
            <div class="bkh"><button><a href="home.jsp">Back</a></button></div>
        </form>
    </div>
   </div> 
</body>
</html>