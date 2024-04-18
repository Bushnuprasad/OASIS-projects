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
          <h1 class="title">sign up</h1>
          <div class="underline">
              <form action="StudentServlet" method="post">
                  <div class="inpput-group">
                      <div class="input-field  namefield">
                          <i class="fa-solid fa-user"></i>
                          <input type="text" placeholder="Name" name="student_name">
                      </div>
                      <div class="input-field">
                          <i class="fa-solid fa-envelope"></i>
                          <input type="number" placeholder="collage Id" name="student_id">
                      </div>
                       <div class="input-field">
                          <i class="fa-solid fa-lock"></i>
                          <input type="text" placeholder="branch" name="branch">
                      </div>
                        <div class="input-field">
                          <i class="fa-solid fa-lock"></i>
                          <input type="password" placeholder="password" name="password">
                      </div>
                 
                  </div>
                  <div class="btn-field">
                   <button class="signupbtn">Sign up</button>
                    <button class="signupbtn"> <a href="Signin.jsp" >Sign in</a></button>
                 
                  </div>
                
              </form>
          </div>
        </div>
      </div>
     
</body>
</html>