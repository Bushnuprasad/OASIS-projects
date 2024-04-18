<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
   <div class="contenthome">
    <div class="hm">
    <form action="ViewServlet" method="post">
         <button><a href="viewBook.jsp" >View Book</a></button>
    </form>
        
        <form action="ApplyServlet" method="post">
           <button><a href="ApplyBook.jsp" >Apply Book</a></button>
        </form>
           <button name="logout"><a href="index.jsp" >Log Out</a></button>
        
        
    </div>
   </div> 
</body>
</html>