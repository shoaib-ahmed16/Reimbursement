const login =()=>{ 
let data ={
"email": document.getElementById("emailId").value,
"password":document.getElementById("passwordId").value,
}
debugger
$.ajax({
  url:"http://localhost:8888/reimbursement/userLogin",
  type: "PUT",
  contentType: "application/json",
  data:JSON.stringify(data),
  processData: false,
  success: function(data,status,xhr){
  console.log(data);
  localStorage.setItem("loginUser",JSON.stringify(data))
  setTimeout(()=>{window.location.href="/home.html"},20000)
},
error: function(){
alert("Unknown server error!");
},
})
}

const signUpUser =()=>{
$.ajax( window.location.href="/index-register-user.html")
}