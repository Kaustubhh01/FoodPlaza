<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "templatemo_style.css" rel = "stylesheet" type = "text/css" />

</head>
<body>

<jsp:include page="UserHeader.jsp"></jsp:include>

<div id = "templatemo_container" class = "parent" >

<form action="feedback" method = "post" onsubmit="AddFeedbackValidation()" class = "main" >

<table border = "1" >
<caption>Add Feedback</caption>

<tr>
<td>Name :</td>
<td><input type = "text" name = "cname" id = "cname" ></td>
<td><span id = "cnameerror" style = "color:red" ></span></td>
</tr>

<tr>
<td>EmailId :</td>
<td><input type = "email" name = "uemail" id = "uemail" ></td>
<td><span id = "uemailerror" style = "color:red" ></span></td>
</tr>

<tr>
<td>Review :</td>
<td><input type = "text" name = "review" id = "review" ></td>
<td><span id = "reviewerror" style = "color:red" ></span></td>
</tr>

<tr>
<td>Rank :</td>
<td><input type = "number" name = "rank" id = "rank" ></td>
<td><span id = "rankerror" style = "color:red" ></span></td>
</tr>

<tr>
<td>Suggestion :</td>
<td><input type = "text" name = "suggest" id = "suggest" ></td>
<td><span id = "suggesterror" style = "color:red" ></span></td>
</tr>

</table>

<input type = "submit" value = "AddFeedback" name = "action" >
<input type = "reset" value = "clear" >

</form>

</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>