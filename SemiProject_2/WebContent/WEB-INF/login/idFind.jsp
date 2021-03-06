<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    String ctxPath = request.getContextPath();
    //    /SemiProject
%>    

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/bootstrap-4.6.0-dist/css/bootstrap.min.css" > 

<!-- 직접 만든 CSS -->
<link rel="stylesheet" type="text/css" href="<%= ctxPath%>/css/style.css" />

<!-- Optional JavaScript -->
<script type="text/javascript" src="<%= ctxPath%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%= ctxPath%>/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js" ></script>

<style type="text/css">

a.navbar-brand {
		color: #4d4d4d;
		font-family: Copperplate, Fantasy;
		font-size: 28pt;
	}

</style>


<script type="text/javascript">
	$(document).ready(function(){
		
		var method = "${requestScope.method}"
		//console.log("method => " + method);
		
		if(method == "GET"){
			$("div#div_findResult").hide();
		}
		else if(method == "POST"){
			$("input#name").val("${requestScope.name}");
			$("input#email").val("${requestScope.email}");
		}
		
		$("button#btnFind").click(function(){
			
			// 성명 및 이메일에 대한 유효성 검사(정규표현식)는 생략하겠습니다.
			
			var frm = document.idFindFrm;
			frm.action = "<%= ctxPath%>/login/idSearch.go";
			frm.method = "POST";
			frm.submit();
			
		});
		
	}); 
	
</script> 

<form name="idFindFrm">

	   
   <div class="topArea container-fluid navbar-header mx-auto text-center">
    <div class="container-fluid p-3" style="background-color: #ffe6e6;" ></div>
				<a class="navbar-brand mx-auto mb-3">o H ! &nbsp; D a i L Y</a>
	</div>
   
   <ul style="list-style-type: none">
         <li style="margin: 25px 0">
            <label for="userid" style="display: inline-block; width: 90px; color: #4d4d4d;">성명</label>
            <input type="text" name="name" id="name" size="25" placeholder="성명을입력하세요" autocomplete="off" required />
         </li>
         <li style="margin: 25px 0">
            <label for="userid" style="display: inline-block; width: 90px; color: #4d4d4d;">이메일</label>
            <input type="text" name="email" id="email" size="25" placeholder="abcd1234@gmail.com" autocomplete="off" required />
         </li>
   </ul>
   
   <div class="my-3">
    <p class="text-center">
       <button type="button" class="btn btn-success" id="btnFind">찾기</button>
    </p>
   </div>
   
   <div class="my-3" id="div_findResult">
        <p class="text-center">
        <span style="color: black; font-size: 16pt; font-weight: bold;">회원님의 아이디는 ${requestScope.userid} 입니다.</span> 
      </p>
   </div>
   
</form> 