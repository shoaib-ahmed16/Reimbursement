const signup =()=>{
  let data ={
  "email": $("#email-user").val(),
  "password": $("#password-user").val(),
  "firstName":$("#firstName-user").val(),
  "lastName": $("#lastName-user").val(),
  }
  $(document).ready(function(){
    $.ajax({
    url: "http://localhost:8888/reimbursement/userRegister",
    type: "POST",
    contentType: "application/json",
    data:JSON.stringify(data),
    processData: false,
    dataType: "text",
    success: function(data){
        alert(data);
        setTimeout(()=>{window.location.href="/index.html"},200)
    },
    error: function(){
       alert("Unknown server error!");
    },
    })
  })
}
const loginPage =()=>{
   $.ajax(window.location.href="/index.html")
}