<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<script>
    function submitForm(action) {
        document.getElementById('action').value = action;
        document.getElementById('libraryForm').submit();
    }
</script>
</head>
<body>
<div class="content">
    <div class="hm">
        <form id="libraryForm" action="libraryServlet" method="post">
            <input type="hidden" id="action" name="action">
            <button type="button" onclick="submitForm('addBook')" value="addBook"> <a href="Addbook.jsp">Add Book</a> </button>
            <button type="button" onclick="submitForm('deleteBook')"><a href="DeleteBook.jsp">Delete Book</a></button>
            <button type="button" onclick="submitForm('viewIssued')"><a href="issuedBooks.jsp">View Issued</a></button>
            <button type="button" ><a href="Conform.jsp">Conform Issue</a></button>
            <button type="button" ><a href="index.jsp" >Log Out</a></button>
        </form>
         <form action="ApplyServlet" method="post">
                <button><a href="ReturnBook.jsp" >Return Book</a></button>
         </form>
    </div>
</div> 
</body>
</html>
