<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<%
	String ctxPath = request.getContextPath();
	//		/SemiProject
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/SemiProject/bootstrap-4.6.0-dist/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<jsp:include page="../header.jsp" />

</head>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<style type="text/css">

.titleArea {
    margin: 0 0 30px;
    text-align: center;
}

.titleArea h2 {
    display: inline-block;
    position: relative;
    margin: 10px auto 10px;
    padding: 8px 15px;
    min-width: 180px;
    color: #353535;
    font-size: 11pt;
    font-weight: bold;
    letter-spacing: 1px;
    border: 1px #ddd solid;
}

p.desc {
	font-size: 9pt;
}

#container {
    width: 1250px;
    margin: auto;
}

#contents {
   /*  position: relative; */
    margin: auto;
    min-height: 1000px;
}

table.tbl {
	width: 1000px;
	margin: auto;
	text-align: center;
	border: 1px solid #d5d5d5;
	line-height: 25px;
}
td {
	border: 1px solid #d5d5d5;
	padding: 4px 3px 4px 6px;
}
input {
	border: 1px solid #d5d5d5;
}
textarea {
	border: 1px solid #d5d5d5;
}
button {
	width: 90px;
	height: 31px;
	border: 1px solid #8c8c8c;
	background-color: #444444;
    float: right;
    text-align: center;
    font-size: 9pt;
    padding: 5px;
    margin-right: 10px;
}
button.btn {
	border: 1px solid #8c8c8c;
}


</style>

<body>


<script type="text/javascript">

	
		$(document).ready(function(){
	    
		    $("button#GoEdit").click(function(){ // ????????? ???????????? ???????????? ???????????? ????????? ???????????? ???????????? ???????????????
		       
		        if( $("input[name=rwriter]").val().trim() == "" ){
		          alert("???????????? ?????????????????????!");
		          return;
		       }
		       
		       if(  $("input[name=rtitle]").val().trim() == ""  ){
		          alert("???????????? ?????????????????????!");
		          return;
		       }
		       
		       if(  $("textarea[name=rcontent]").val().trim() == ""  ){
		          alert("???????????? ?????????????????????!");
		          return;
		       }
		       
		       if( parseInt($("input[name=rtitle]").val().length) > 100  ){
		          alert("???????????? ?????? ?????????!");
		          return;
		       }
		       
		       
		    // ?????? ????????? ?????? ????????? ????????? ?????? ?????????.
		       $("input#rnum").prop("disabled", false);
		       $("input#rwriter").prop("disabled", false);
		       
		       var frm = document.registerFrm;
		       frm.action="reviewEditEnd.go";
		       frm.method="POST";
		       frm.submit();	       
		       
		    });// end of $("button#btnGoInsert").click(function(){})---------------------------------
		    
		});// end of $(document).ready(function(){})-------------------------------


</script>




<div id="container" >
    <div id="contents">

		<div class="titleArea">
	           <h2><font color="#333333">REVIEW</font> </h2>
	           <p class="desc">?????? ?????????????????????.</p>
	    </div>
		<br><br>   
    
		<form name="registerFrm">
		
		<table class="tbl" border="1" >
			<thead>
			 	<tr> 
			       <th colspan="2" id="th"><span style="font-size: 9pt; "><span class="star">*</span>????????? ?????????????????? ?????????.</span></th>
			  	</tr>
			</thead>
		    <tbody>
		       <tr>
			      <td style="font-weight: bold;">?????????&nbsp;<span class="star">*</span></td>
			      <td style="text-align: left;">
				      <input type="text" id="rnum" name="rnum" value="${requestScope.rnum}" disabled="disabled"/>
			      </td> 
			   </tr>
			   <tr>
			      <td style="font-weight: bold;">?????????&nbsp;<span class="star">*</span></td>
			      <td style="text-align: left;">
				      <input type="text" id="rwriter" name="rwriter" value="${requestScope.rwriter}" disabled="disabled"/>&nbsp;&nbsp;
				      <span id="idcheckResult"></span>
			      </td> 
			   </tr>
			   <tr>
			      <td style="font-weight: bold;">??????&nbsp;<span class="star">*</span></td>
			      <td style="text-align: left;">
			          <input type="text" id="rtitle" name="rtitle" maxlength="100"  style="width:50%" placeholder="${requestScope.rtitle}" autofocus required />
			      </td>
			   </tr>
			   <tr>
			      <td style="font-weight: bold;">??????&nbsp;<span class="star">*</span></td>
			      <td style="text-align: left;">
			        <textarea name="rcontent" style="width:650px; height:400px;" placeholder="${requestScope.rcontent}" wrap="hard" required style="resize: none; width: 90%;" ></textarea>
			      </td>
			   </tr>
			   <tr>
			      <td style="font-weight: bold;"width="25%" class="prodInputName">????????????(??????)</td>
			      <td width="75%" align="left" style="border-top: hidden; border-bottom: hidden;">
			         <input type="file" name="prdmanualFile" />
			      </td>
			   </tr>
			   <tr>
			   </tr>
		     </tbody>
		 </table>
		 <br>
		 	<button id="GoEdit" type="button" class="btn btn-dark btn-md" style="margin-right: 125px;">??????</button>
      		<button type="button" class="btn" onclick="javascript:history.back()">??????</button>
		 </form>
		<br><br>
		
	</div>
</div>

<jsp:include page="../footer.jsp" />