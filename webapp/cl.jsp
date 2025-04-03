<%@page import="java.util.Iterator"%>
<%@page import="pojo.customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "templatemo_style.css" rel = "stylesheet" type = "text/css" />
<script src = "Validation.js"></script>

</head>
<body>

<%List<customer>l = (List)session.getAttribute("clist"); %>


<jsp:include page="AdminHeader.jsp"></jsp:include>

<div id = "templatemo_container" >

<form class="main">

<table border = "1" >
<caption>Customer List</caption>

<tr>
<th>Name</th>
<th>EmailId</th>
<th>Password</th>
<th>Address</th>
<th>ContactNo</th>
<th colspan = "2" >Action</th>
</tr>

<%
Iterator<customer> itr = l.iterator();

while(itr.hasNext()){
	customer cs = itr.next(); 
%>	


<tr>
<td><%=cs.getCustomer_name() %></td>
<td><%=cs.getCustomer_emailID() %></td>
<td><%=cs.getCustomer_password() %></td>
<td><%=cs.getCustomer_address() %></td>
<td><%=cs.getCustomer_contactNO() %></td>
<td><a href = "customer?action=delete&emailId=<%=cs.getCustomer_emailID() %>" >Delete</a></td>
</tr>


<%
}
%>

</table>

</form>

</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>