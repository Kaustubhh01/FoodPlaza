<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="pojo.food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String uEmail = (String) session.getAttribute("uEmail");
String aEmail = (String) session.getAttribute("aEmail");

List<food> l = (List<food>) session.getAttribute("flist");
%>

<c:if test="${uEmail==null && aEmail==null}">
<jsp:include page="Header.jsp"></jsp:include>
</c:if>

<c:if test="${uEmail!=null && aEmail==null}">
<jsp:include page="UserHeader.jsp"></jsp:include>
</c:if>

<c:if test="${uEmail==null && aEmail!=null}">
<jsp:include page="AdminHeader.jsp"></jsp:include>
</c:if>

<div id="templatemo_container" class="parent">

<div class="child">
     <form>
     
     <br> <h1 align="center">Food List</h1>
          <table border="1" style="" align="center">
               
                <tr>
                    <th>FoodId</th>
                    <th>FoodName</th>
                    <th>FoodType</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    
                    <c:if test="${uEmail==null && aEmail!=null}">
                    <th colspan="2">Action</th>
                    </c:if>
                    
                    <c:if test="${uEmail!=null && aEmail==null}">
                    <th colspan="1">Action</th>
                    </c:if>
                   
                </tr>
              
                <%
                
                Iterator <food> itr = l.iterator();
                
                while(itr.hasNext()){
                	food f = itr.next();
              
                %>
                
                <tr>
                    <td><%=f.getFood_ID()%></td>
                    <td><%=f.getFood_name()%></td>
                    <td><%=f.getFood_type()%></td>
                    <td><%=f.getFood_quantity()%></td>
                    <td><%=f.getFood_price()%></td>
                    
                    <c:if test="${uEmail==null && aEmail!=null}">
                    <td><a href="UpdateFood.jsp?foodId=<%=f.getFood_ID()%>">Edit</a></td>
                    <td><a href="food?action=delete&foodId=<%=f.getFood_ID()%>">Delete</a></td>
                    </c:if>
                    
                    <c:if test="${uEmail!=null && aEmail==null}">
                    <td><a href="AddToCart.jsp?foodId=<%=f.getFood_ID()%> &fName=<%=f.getFood_name()%>">Add</a></td>
                    </c:if>
                    
                </tr>
                
                <% } %>
                
          </table> 
          <br>      
     </form>
</div>

</div>
     
     <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>