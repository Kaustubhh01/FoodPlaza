<%@page import="pojo.customer"%>
<%@page import="dao.CustomerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
CustomerDaoImpl cd = new CustomerDaoImpl();
String emailID = request.getParameter("customer_emailID");
customer c = cd.searchCustomerById(emailID);
%>

<jsp:include page="UserHeader.jsp"></jsp:include>

<div id="templatemo_container" class="parent">

		<form action="customer" method="post" onsubmit="UpdateCustomerValidation()"
			class="main">

			<br>
			<h1>Update Customer</h1>
			
			<table border="1">

				<tr>
					<td>CustomerName:</td>
					<td><input type="text" name="cname" id="cname"
						value="<%=c.getCustomer_name()%>"></td>
					<td><span id="cnameerror" style="color: red"></span></td>
				</tr>
</body>
</html>