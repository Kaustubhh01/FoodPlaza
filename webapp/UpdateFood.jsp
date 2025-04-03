<%@page import="pojo.food"%>
<%@page import="dao.FoodDaoImpl"%>
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
	FoodDaoImpl fd = new FoodDaoImpl();
	int id = Integer.parseInt(request.getParameter("foodId"));
	food f = fd.searchFoodById(id);
	%>

	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<div id="templatemo_container" class="parent">

		<form action="food" method="post" onsubmit="UpdateFoodValidation()"
			class="main">

			<br>
			<h1>Update Food</h1>

			<table border="1">

				<tr>
					<td>FoodID:</td>
					<td><input type="number" name="fid" id="fid"
						value="<%=f.getFood_ID()%>"></td>
					<td><span id="fiderror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>FoodName:</td>
					<td><input type="text" name="fname" id="fname"
						value="<%=f.getFood_name()%>"></td>
					<td><span id="fnameerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>FoodType:</td>
					<td><input type="text" name="ftype" id="ftype"
						value="<%=f.getFood_type()%>"></td>
					<td><span id="ftypeerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>FoodQuantity:</td>
					<td><input type="number" name="fquan" id="fquan"
						value="<%=f.getFood_quantity()%>"></td>
					<td><span id="fquanerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>FoodPrice:</td>
					<td><input type="number" name="fprice" id="fprice"
						value="<%=f.getFood_price()%>"></td>
					<td><span id="fpriceerror" style="color: red"></span></td>
				</tr>

			</table>

			<input type="submit" value="UpdateFood" name="action"> <input
				type="reset" value="Clear">

		</form>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>