<%@page import="java.util.Iterator"%>
<%@page import="pojo.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "templatemo_style.css" rel = "stylesheet" type = "text/css" />
<script src = "Validation.ja"></script>

</head>
<body>

<% List<Feedback> l = (List)session.getAttribute("flist"); %>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div id = "templatemo_container" >

<form class="main">

<table border = "1" >
<caption>Feedback List</caption>

<tr>
<th>Name</th>
<th>EmailId</th>
<th>Review</th>
<th>Rank</th>
<th>Suggestion</th>
</tr>

<%
Iterator<Feedback> itr = l.iterator();

while(itr.hasNext()){
	Feedback fd = itr.next();
%>

<tr>
<td> <%=fd.getName() %> </td>
<td> <%=fd.getEmailId() %> </td>
<td> <%=fd.getReview() %> </td>
<td> <%=fd.getRank() %> </td>
<td> <%=fd.getSuggestionn() %> </td>
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