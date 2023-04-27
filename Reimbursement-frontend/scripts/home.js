let months=[]
let loginUser=JSON.parse(localStorage.getItem("loginUser"));
$(document).ready(function(){
 document.getElementById("user-login-name").innerHTML=loginUser.firstName+" "+loginUser.lastName;
 let letter= loginUser.firstName.substring(0,1);
 document.getElementById("left-menu-circle").innerHTML=letter;
 document.getElementById("cicular-firstLetter").innerHTML=letter;
})
 $.ajax({
    url:"http://localhost:8888/reimbursement/getSelectionMonth",
    type: "GET",
    success: function(data,status,xhr){
      months=data;
    },
    error: function(){
        alert("Unknown server error!");
      },
})
  // reimbursement unpaid for current month or upcoming month  display api
$.ajax({
  url:"http://localhost:8888/reimbursement/allReimbursementDetails",
  type: "GET",
  success: function(data,status,xhr){
    data.forEach((elem,index)=>{
      let currentMonthIndex=0;
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
      currentMonthIndex=monthIndex-1;
      monthofReibursement.innerHTML=months[monthIndex-1];
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
        claimStatus.style="cursor:pointer; color:red"
        claimStatus.addEventListener("click",()=>{
        localStorage.setItem("paidReimburse",JSON.stringify(elem))
         setTimeout(()=>{window.location.href="/reimbursePaidPage.html"},2)
        })
      }
      else{
         claimStatus.style="cursor:pointer; color:green"
      }

     
      }
      let detailsButton =document.createElement("div");
      {
      detailsButton.setAttribute("id","rembursiment_item"+elem.reimbursementId+elem.paidStatus+index);
      detailsButton.addEventListener("click",()=>{
       let divviewbox =document.createElement("div")
        {
            divviewbox.setAttribute("class","view-div-0");
        }
        let divmesument1 =document.createElement("div")
        {
           divmesument1.setAttribute("class","divmesument");
        }
         let divmesument2 =document.createElement("div")
        {
           divmesument2.setAttribute("class","divmesument");
        }
        let divviewbox1 =document.createElement("div")
        {
          divviewbox1.setAttribute("class","view-div-1");
          divviewbox1.innerHTML=`Reimbursement Status: ${(elem.paidStatus)?"Paid":"Unpaid"}`;
        }

        let divviewbox2 =document.createElement("div")
        {
          divviewbox2.setAttribute("class","view-div-2");
          divviewbox2.innerHTML="Date Of Expense: "+elem.dateOfExpense
        }
        divmesument1.append(divviewbox1,divviewbox2);
        divviewbox.append(divmesument1);
        let divviewbox3 =document.createElement("div")
        {
          divviewbox3.setAttribute("class","view-div-1");
          let month=elem.dateOfExpense.substring(3,5)
          let monthIndex=parseInt(month)
          currentMonthIndex=monthIndex-1;
          divviewbox3.innerHTML="Month of Claim: "+months[monthIndex-1];
        }
        let divviewbox4 =document.createElement("div")
        {
          divviewbox4.setAttribute("class","view-div-2");
          divviewbox4.innerHTML="Year of Claim: "+elem.claimYear;
        }
        divmesument2.append(divviewbox3,divviewbox4);
        divviewbox.append(divmesument2);
        // divmesument.innerHTML="";
        let divviewbox5 =document.createElement("div")
        {
          divviewbox5.setAttribute("class","view-div-3");
          divviewbox5.innerHTML="Amount Claim: "+elem.amount;
        }
        let divviewbox6 =document.createElement("div")
        {
          divviewbox6.setAttribute("class","view-div-4");
          divviewbox6.innerHTML="Cancel";
          divviewbox6.addEventListener("click",()=>{
            document.getElementById("display-view-details").innerHTML="";
          })
          divviewbox6.style="cursor:pointer"
        }
         divviewbox.append(divviewbox5,divviewbox6);
         document.getElementById("display-view-details").append(divviewbox)
      })
        detailsButton.style="cursor:pointer"
        detailsButton.innerHTML="view Details";
       }
       const d = new Date();
       if(currentMonthIndex>=d.getMonth()-1)
       {
        blockDiv.append(checkBox,monthofReibursement,dateOfClaim,claimAmount,claimStatus,detailsButton)
       document.getElementById("saved0-expense-display").append(blockDiv)
       }
    })
  },
  error: function(){
  alert("Unknown server error!");
    },
})
  // reimbursement history display api
  $.ajax({
  url:"http://localhost:8888/reimbursement/allReimbursementPaidDetails",
  type: "GET",
  success: function(data,status,xhr){
    data.forEach((elem,index)=>{
      let currentMonthIndex=0;
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
      currentMonthIndex=monthIndex-1;
      monthofReibursement.innerHTML=months[monthIndex-1];
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
        if(elem.paidStatus){
          claimStatus.style="color:green;cursor: no-drop"
        }
        else{
           claimStatus.style="color:lightgrey;cursor:no-drop"
        }
      }
      let detailsButton =document.createElement("div");
      {
      detailsButton.setAttribute("id","rembursiment_item"+elem.reimbursementId+elem.paidStatus+index);
        detailsButton.addEventListener("click",()=>{
          localStorage.setItem("detailsView",JSON.stringify(elem))
          setTimeout(()=>{window.location.href="/home.html"},20000)
        })
        detailsButton.innerHTML="view Details";
       }
       const d = new Date();
       if(currentMonthIndex>=d.getMonth())
       {
        blockDiv.append(monthofReibursement,dateOfClaim,claimAmount,approvedAmount,paidAmount,claimStatus,detailsButton)
       document.getElementById("history-expense-display").append(blockDiv)
       }
    })
  },
  error: function(){
  alert("Unknown server error!");
    },
  })
const gotoSubmitExpensePage=()=>{
  setTimeout(()=>{window.location.href="/submit-expense.html"},2)
}
 

