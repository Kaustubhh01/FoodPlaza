<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "templatemo_style.css" rel = "stylesheet" type = "text/css" />

</head>
<body>

<%
String uEmail = (String) session.getAttribute("uEmail");
String aEmail = (String) session.getAttribute("aEmail");
%>

<c:if test="${uEmail!=null && aEmail==null }">
<jsp:include page="UserHeader.jsp"></jsp:include>
</c:if>

<c:if test="${uEmail==null && aEmail!=null }">
<jsp:include page="AdminHeader.jsp"></jsp:include>
</c:if>

<div id = "templatemo_container" class = "parent" >

<form action="cpservlet" method = "post" onsubmit="return ChangePassValdiation()" class = "main" >

<table border = "1" >
<caption>Change Password</caption>

<tr>
<td>EmailId :</td>
<td><input type = "email" name = "email" id = "email" ></td>
<td><span id = "emailerror" style = "color:red" ></span></td>
</tr>

<tr>
<td>Old Password :</td>
<td><input type = "password" name = "pass" id = "pass" ></td>
<td><span id = "passerror" style = "color:red" ></span></td>
</tr>

<tr>
<td>New Password :</td>
<td><input type = "password" name = "npass" id = "npass" ></td>
<td><span id = "npasserror" style = "color:red" ></span></td>
</tr>

<tr>
<td>Confirm Password :</td>
<td><input type = "password" name = "cpass" id = "cpass" ></td>
<td><span id = "cpasserror" style = "color:red" ></span></td>
</tr>

</table>

<input type = "submit" value = "ChangePass" name = "action" >
<input type = "reset" value = "clear" >

</form>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>