$(document).ready(function(){

  let months=[];
    $.ajax({
    url:"http://localhost:8888/reimbursement/getSelectionMonth",
    type: "GET",
    success: function(data,status,xhr){
      console.log(data)
      months=data;
    },
    error: function(){
        alert("Unknown server error!");
      },
    })
  $.ajax({
  url:"http://localhost:8888/reimbursement/allReimbursementDetails",
  type: "GET",
  success: function(data,status,xhr){
    console.log(data)
    data.forEach((elem,index)=>{
      let currentMonthIndex="January";
      let blockDiv =document.createElement("div");
      blockDiv.setAttribute("class","blockDiv");
      let checkBox =document.createElement("input");
      {
        checkBox.setAttribute("id","rembursiment_item"+elem.reimbursementId);
        checkBox.setAttribute("type","checkBox");
      }
      let monthofReibursement =document.createElement("div");
      {
      monthofReibursement.setAttribute("id","rembursiment_item"+elem.dateOfExpense);
      let month=elem.dateOfExpense.substring(3,5)
      let monthIndex=parseInt(month)
      currentMonthIndex=monthIndex;
      monthofReibursement.innerHTML=months[monthIndex];
      }
      let dateOfClaim =document.createElement("div");
      {
      dateOfClaim.setAttribute("id","rembursiment_item"+elem.dateOfExpense+elem.reimbursementId);
      dateOfClaim.innerHTML=elem.dateOfExpense
      }
      let claimAmount =document.createElement("div");
      {
      claimAmount.setAttribute("id","rembursiment_item"+elem.reimbursementId+elem.claimAmount);
      claimAmount.innerHTML=elem.amount
      }
      let claimStatus =document.createElement("div");
      {
      claimStatus.setAttribute("id","rembursiment_item"+elem.reimbursementId+elem.paidStatus+index);
      claimStatus.innerHTML=(elem.paidStatus)?"Paid":"Unpaid";
      if(!elem.paidStatus)
      {
        claimStatus.style="cursor:pointer"
        claimStatus.addEventListener("click",()=>{
        console.log(elem);
        localStorage.setItem("paidReimburse",JSON.stringify(elem))
        })
      }
     
      }
      let detailsButton =document.createElement("div");
      {
      detailsButton.setAttribute("id","rembursiment_item"+elem.reimbursementId+elem.paidStatus+index);
        detailsButton.addEventListener("click",()=>{
          console.log(index)
          console.log(elem);
           localStorage.setItem("viewsDetails",JSON.stringify(elem))
        })
        detailsButton.style="cursor:pointer"
        detailsButton.innerHTML="view Details";
       }
       const d = new Date();
       if(currentMonthIndex>=d.getMonth())
       {
        blockDiv.append(checkBox,monthofReibursement,dateOfClaim,claimAmount,claimStatus,detailsButton)
       document.getElementById("saved0-expense-display").append(blockDiv)
       }
    })
    localStorage.setItem("loginUser",JSON.stringify(data))
    setTimeout(()=>{window.location.href="/home.html"},20000)
  },
error: function(){
  alert("Unknown server error!");
    },
  })

  $.ajax({
  url:"http://localhost:8888/reimbursement/allReimbursementPaidDetails",
  type: "GET",
  success: function(data,status,xhr){
    console.log(data)
    data.forEach((elem,index)=>{
      let currentMonthIndex="January";
      let blockDiv =document.createElement("div");
      blockDiv.setAttribute("class","blockDiv-history");
      let checkBox =document.createElement("input");
      {
        checkBox.setAttribute("type","checkBox");
      }
      let monthofReibursement =document.createElement("div");
      {
      let month=elem.dateOfExpense.substring(3,5)
      let monthIndex=parseInt(month)
      currentMonthIndex=monthIndex;
      monthofReibursement.innerHTML=months[monthIndex];
      }
      let dateOfClaim =document.createElement("div");
      {
        dateOfClaim.innerHTML=elem.dateOfExpense
      }
      let claimAmount =document.createElement("div");
      {
        claimAmount.innerHTML=elem.claimAmount
      }
      let approvedAmount =document.createElement("div");
      {
        approvedAmount.innerHTML=elem.aprovedAmount
      }
      let paidAmount =document.createElement("div");
      {
        paidAmount.innerHTML=elem.paidAmount
      }
      let claimStatus =document.createElement("div");
      {
        claimStatus.innerHTML=(elem.paidStatus)?"Paid":"Unpaid";
      }
      let detailsButton =document.createElement("div");
      {
      detailsButton.setAttribute("id","rembursiment_item"+elem.reimbursementId+elem.paidStatus+index);
        detailsButton.addEventListener("click",()=>{
          console.log(index)
          console.log(elem);
        })
        detailsButton.style="cursor:pointer"
        detailsButton.innerHTML="view Details";
       }
       const d = new Date();
       if(currentMonthIndex<d.getMonth())
       {
        blockDiv.append(monthofReibursement,dateOfClaim,claimAmount,approvedAmount,paidAmount,claimStatus,detailsButton)
       document.getElementById("history-expense-display").append(blockDiv)
       }
    })
    localStorage.setItem("loginUser",JSON.stringify(data))
    setTimeout(()=>{window.location.href="/home.html"},20000)
  },
error: function(){
  alert("Unknown server error!");
    },
  })
})
