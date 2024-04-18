<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Book</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="del">
        <div class="de">
            <h2>Delete Book</h2>
            <form action="LibraryServlet" method="post">
                <input type="hidden" name="action" value="deleteBook">
                <input type="number" name="book_id" placeholder="Book Id">
                <input type="submit" value="Delete Book">
                 <div class="bkh"><button><a href="home.jsp">Back</a></button></div>
            </form>
        </div>
    </div>
</body>
</html>
