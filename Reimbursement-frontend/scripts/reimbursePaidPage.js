let prev =JSON.parse(localStorage.getItem("paidReimburse"));
(function addPrevData(prev){
  document.getElementById("claimMonth").value=prev.claimMonth;
  document.getElementById("claimYear").value=prev.claimYear;
  document.getElementById("claimType").value=prev.claimType;
  document.getElementById("dateOfExpense").value=prev.dateOfExpense;
  document.getElementById("claimAmount").value=prev.amount;
})(prev);


const paidReimbursment =()=>{
  const date =new Date();
  let todayDate=date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear();
  let data ={
    "claimType": $("#claimType").val(),
    "dateOfExpense": $("#dateOfExpense").val(),
    "claimAmount": $("#claimAmount").val(),
    "aprovedAmount": $("#aprovedAmount").val(),
    "paidAmount": $("#paidAmount").val(),
    "claimMonth":  $("#claimMonth").val(),
    "claimYear": $("#claimYear").val(),
    "paymentDate":todayDate
  }
  $(document).ready(function(){
    $.ajax({
    url: "http://localhost:8888/reimbursement/reimbursementPaid",
    type: "POST",
    contentType: "application/json",
    data:JSON.stringify(data),
    processData: false,
    dataType: "text",
    success: function(data){
        $.ajax({
          type: "DELETE",
          url: "http://localhost:8888/reimbursement/delete/" + prev.reimbursementId,
          success: function (result, status, xhr) {
            alert(result)
            setTimeout(() => { window.location.href = "/home.html" }, 200)
          },
          error: function (xhr, status, error) {
            alert("Error: " + status + " " + error + " " + xhr.status + " " + xhr.statusText);
          }
      });
    },
    error: function(xhr, status, error){
       alert("Unknown server error!");
    },
    })
  })
}
const cancel =()=>{
  setTimeout(() => { window.location.href = "/home.html" }, 2)
}