let signup=document.querySelector(".signupbtn")
let signIn=document.querySelector(".disable")
let namefield=document.querySelector(".namefield")
let title=document.querySelector(".title")
let underline=document.querySelector(".underline")
let text=document.querySelector(".txtx")
signIn.addEventListener('click',function(){
     namefield.style.maxHeight='0'
     title.innerHTML="sign in"
     text.innerHTML="lost password"
     signup.classList.add("disable")
     signIn.classList.remove("disable")

 })
 signup.addEventListener('click',function(){
    namefield.style.maxHeight='60px'
    title.innerHTML="sign up"
    text.innerHTML="password suggestion"
    signup.classList.remove("disable")
    signIn.classList.add("disable")
    
})