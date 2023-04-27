
 $.ajax({
    url:"http://localhost:8888/reimbursement/getSelectionMonth",
    type: "GET",
    success: function(data,status,xhr){
      months=data;
      data.forEach((elem,index)=>{
        let opt =document.createElement("option")
        opt.setAttribute("id",index)
        opt.innerHTML=elem;
        document.getElementById("claimMonth").append(opt);
      })
     
    },
    error: function(){
        alert("Unknown server error!");
      },
    })
    
const cancel =()=>{
   $.ajax(window.location.href="/home.html")
}
const submitClaim =()=>{
   let data ={
   "claimType": $("#claimType").val(),
    "dateOfExpense": $("#dateOfExpense").val(),
    "amount": $("#amount").val(),
    "claimMonth":  $("#claimMonth").val(),
    "claimYear":  $("#claimYear").val(),
   }
   $.ajax({
    url: "http://localhost:8888/reimbursement/addOrUpdate",
    type: "POST",
    contentType: "application/json",
    data:JSON.stringify(data),
    processData: false,
    dataType: "text",
    success: function(data){
        alert(data);
        setTimeout(()=>{window.location.href="/home.html"},200)
    },
    error: function(){
       alert("Unknown server error!");
    },
    })
}