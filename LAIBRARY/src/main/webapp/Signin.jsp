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
    <div class="container">
        <div class="form-box">
          <h1 class="title">sign in</h1>
          <div class="underline">
              <form action="SigninServlet" method="post">
                  <div class="inpput-group">
                      <div class="input-field  namefield">
                          <i class="fa-solid fa-user"></i>
                          <input type="text" placeholder="Name" name="student_name">
                      </div>
                      <div class="input-field">
                          <i class="fa-solid fa-envelope"></i>
                          <input type="number" placeholder="student Id" name="student_id">
                      </div>
                     
                        <div class="input-field">
                          <i class="fa-solid fa-lock"></i>
                          <input type="password" placeholder="password" name="password">
                      </div>
                 
                  </div>
                  <div class="btn-field">
                   <button class="signupbtn">Sign In</button>
                 
                  </div>
                
              </form>
          </div>
        </div>
      </div>
   
</body>
</html>