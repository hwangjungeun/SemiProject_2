<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<%
	String ctxPath = request.getContextPath();
	//		/SemiProject
%>


<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/SemiProject/bootstrap-4.6.0-dist/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<jsp:include page="../header.jsp" />

<style type="text/css">

#contents {
    position: relative;
    margin: 0 auto;
    min-height: 750px;
    width:1250px;
}

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
.box{
	text-align: center;
}

img {
	display: block;
	width: 500px;
	height: auto;
	margin: auto;
}
.ec-base-button {
    padding: 10px 0;
    text-align: center;
}
a.imgLink {
	font-size: 10pt;
}
strong {
	font-size: 10pt;
}
select{
	display: inline-block;
    min-width: 100px;
    height: 22px;
    margin: 0 2 0 0px;
    padding: 0 0 0 5px;
    color: #333;
    border: 1px #d5d5d5 solid;   
}
input {
    height: 22px;
    padding: 2px 4px;
    border: 1px solid #d5d5d5;
    color: #353535;
    font-size: 12px;
}
a.btnBasic {
    display: inline-block;
    box-sizing: border-box;
    padding: 2px 8px;
    border: 1px solid #d5d5d5;
    line-height: 16px;
    text-align: center;
    color: #353535;
}

.xans-board-listpackage .boardSort {
    float: left;
    margin: 0 0 10px;
}
.ec-base-table.typeList table {
	margin:auto;
	width:100%;
    border-top: 1px solid #dfdfdf;
    border-left: none;
    border-right: none;
}
.ec-base-table table {
    position: relative;
    margin: 10px 0 0;
    border-top: 1px solid #dfdfdf;
    border-bottom: 1px solid #dfdfdf;
    border-top: 0;
    color: #fff;
    line-height: 1.5;
}

.ec-base-table th:first-child {
    border-left: 0;
}
.ec-base-table thead th {
    padding: 12px 0;
    border-bottom: 1px solid #dfdfdf;
    color: #353535;
    vertical-align: middle;
    font-size: 11px;
    font-weight: 500;
    text-transform: uppercase;
    background: #fff;
    text-align: center;
}
.ec-base-table th {
    word-break: break-all;
    word-wrap: break-word;
}

.ec-base-table.typeList .center td.left {
    padding-left: 10px;
}
.ec-base-table.typeList .center td, .ec-base-table.typeList td.center {
    padding-left: 0;
    padding-right: 0;
}
.xans-board-listpackage .ec-base-table .subject {
    font-size: 12px;
}
.ec-base-table.typeList td {
    padding: 14px 10px;
    border-top: 1px #f1f1f1 solid;
}
.ec-base-table .left {
    text-align: left;
}
.ec-base-table td {
    padding: 12px 10px 12px;
    border-top: 1px solid #dfdfdf;
    color: #353535;
    font-size: 11px;
    vertical-align: middle;
    word-break: break-all;
    word-wrap: break-word;
}
th, td {
    border: 0;
    vertical-align: top;
    text-align: center;
}
p {
	font-size: 12px;
}
button {
	padding: 8px;

}
.left {text-align:left;}
caption {display:none;}
</style>
</head>
<body>


	<div id="container">
		<div id="contents">
			<div class="titleArea">
				<h2>
					<font color="#353535">REVIEW</font>
				</h2>
				<p class="desc">상품 사용후기입니다.</p>
			</div>
			<div class="boardSort">
				<div class="ec-base-table typeList">
					<table border="1" summary="리뷰 게시판">
						<caption>리뷰 목록</caption>
						<colgroup>
							<col style="width: 10%;">
							<col>
							<col style="width: 12%;">
							<col style="width: 10%;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">NO</th>
								<th scope="col">CONTNETS</th>
								<th scope="col">NAME</th>
								<th scope="col">DATE</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="rvo" items="${requestScope.reviewList}">
								<tr onclick="location.href='<%=ctxPath%>/board/reviewShow.go?rnum=${rvo.rnum}'">
									<td class="rnum">${rvo.rnum}</td>
					                <td class="rtitle">${rvo.rtitle}</td>
					                <td class="rwriter">${rvo.rwriter}</td>
					                <td class="rdate">${rvo.rdate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div
		class="xans-element- xans-board xans-board-buttonlist-4 xans-board-buttonlist xans-board-4 ec-base-button ">
		<span class="gLeft">
				<input id="board_no" name="board_no" value="4" type="hidden">
				<input id="page" name="page" value="1" type="hidden"> <input
					id="board_sort" name="board_sort" value="" type="hidden">
				<div class="xans-element- xans-board xans-board-search-4 xans-board-search xans-board-4 ">
					<fieldset class="boardSearch">
						
						<p>
							<select id="search_key" name="search_key" fw-filter=""
								fw-label="" fw-msg="">
								<option value="subject">제목</option>
								<option value="content">내용</option>
								<option value="writer_name">작성자</option>
							</select> <input id="search" name="search" fw-filter="" fw-label=""
								fw-msg="" class="inputTypeText" placeholder="" value=""
								type="text"> <a href="<%=ctxPath%>/%??%/" class="btnBasic"
								onclick="goSearch();">찾기</a>
						</p>
					</fieldset>
				</div>
		</span>
		<button type="button" onclick="location.href = '<%=ctxPath%>/board/reviewWrite.go';" style="margin-right: 30px;">리뷰쓰기</button>
	</div>
		</div>
	</div>

	

<jsp:include page="../footer.jsp" />
</body>
</html>





